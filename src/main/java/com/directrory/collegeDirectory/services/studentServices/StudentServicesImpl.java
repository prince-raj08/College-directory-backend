package com.directrory.collegeDirectory.services.studentServices;

import com.directrory.collegeDirectory.DTO.studentDto.*;
import com.directrory.collegeDirectory.common.Role;
import com.directrory.collegeDirectory.entity.Department;
import com.directrory.collegeDirectory.entity.Student;
import com.directrory.collegeDirectory.globalHandler.exception.CommonException;
import com.directrory.collegeDirectory.globalHandler.exception.SecurityError;
import com.directrory.collegeDirectory.repository.DepartmentRepository;
import com.directrory.collegeDirectory.repository.StudentRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Base64;
import java.util.List;

@Slf4j
@RequiredArgsConstructor
@Transactional
@Service
public class StudentServicesImpl implements StudentServices {
    private final StudentRepository studentRepository;
    private final DepartmentRepository departmentRepository;
    @Override
    public ResponseEntity<StudentRegisterResponse> registerStudent(StudentRegisterRequest studentRegisterRequest) {

        log.info("Indise student register services ------------------------->");

        studentRepository.findByEmail(studentRegisterRequest.getEmail())
                .ifPresent(user -> {
                    throw new CommonException("User already exists with email");
                });

        studentRepository.findByPhone(studentRegisterRequest.getPhone())
                .ifPresent(user -> {
                    throw new CommonException("User already exists with phone");
                });

        studentRepository.findByUsername(studentRegisterRequest.getUsername())
                .ifPresent(user -> {
                    throw new CommonException("Username not available");
                });

        Department dept = departmentRepository.findByDept(studentRegisterRequest.getDept())
                .orElseThrow(() -> new CommonException("Invalid Department"));

        Student student = new Student();
        student.setName(studentRegisterRequest.getName());
        student.setDept(dept);
        student.setEmail(studentRegisterRequest.getEmail());
        student.setPassword(studentRegisterRequest.getPassword());
        student.setUsername(studentRegisterRequest.getUsername());
        student.setYear(studentRegisterRequest.getYear());
        student.setRole(Role.STUDENT);
        student.setPhone(studentRegisterRequest.getPhone());

        // ✅ IMAGE HANDLER ADDED
        try {
            if (studentRegisterRequest.getProfilePic() != null &&
                    !studentRegisterRequest.getProfilePic().isEmpty()) {

                student.setProfile(
                        studentRegisterRequest.getProfilePic().getBytes()
                );
            }
        } catch (Exception e) {
            throw new CommonException("Error while processing image");
        }

        studentRepository.save(student);
        StudentRegisterResponse response = new StudentRegisterResponse();
        response.setMessage("User registered successfully");
        log.info("Sending response back to th student register controller");
    return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @Override
    public ResponseEntity<StudentLoginResponse> login(StudentLoginRequest studentLoginRequest) {
        log.info("Inside student login service ------------------------------------->");
        Student student = studentRepository.findByEmail(studentLoginRequest.getEmail()).orElseThrow(()-> new SecurityError("Invalid email ID"));

        if(!student.getPassword().equals(studentLoginRequest.getPassword()))
            throw new SecurityError("Invalid Password");


        StudentLoginResponse response = new StudentLoginResponse();
        response.setId(student.getUserId());
        response.setName(student.getName());
        response.setEmail(student.getEmail());
        response.setRole(student.getRole().name());
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }

    @Override
    public ResponseEntity<DashboardResponse> dashboard(Long id) {
        Student student = studentRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Student not found"));

        DashboardResponse response = new DashboardResponse();

        response.setId(student.getUserId());
        response.setName(student.getName());
        response.setEmail(student.getEmail());
        response.setDepartment(student.getDept().getDept());
        response.setYear(student.getYear());
        response.setPhone(student.getPhone());

        if (student.getProfile() != null) {
            String base64Image = Base64.getEncoder()
                    .encodeToString(student.getProfile());
            response.setProfile(base64Image);
        }

        return ResponseEntity.status(HttpStatus.OK).body(response);
    }

    @Override
    public ResponseEntity<List<StudentList>> getAllStudent() {
        log.info("Inside Student list services ------------------>");
        List<Student> students = studentRepository.findAll();
        List<StudentList> list = new ArrayList<>();
        for( Student s : students)
        {
            StudentList result = new StudentList();
            result.setName(s.getName());
            result.setEmail(s.getEmail());
            result.setDepartment(s.getDept().getDept());
            result.setYear(s.getYear());
            result.setId(s.getUserId());
            list.add(result);
        }

        return ResponseEntity.status(HttpStatus.OK).body(list);
    }


}
