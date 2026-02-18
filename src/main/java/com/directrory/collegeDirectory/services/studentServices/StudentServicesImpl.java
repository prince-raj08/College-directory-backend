package com.directrory.collegeDirectory.services.studentServices;

import com.directrory.collegeDirectory.DTO.studentDto.StudentRegisterRequest;
import com.directrory.collegeDirectory.DTO.studentDto.StudentRegisterResponse;
import com.directrory.collegeDirectory.common.Role;
import com.directrory.collegeDirectory.entity.Student;
import com.directrory.collegeDirectory.globalHandler.exception.CommonException;
import com.directrory.collegeDirectory.repository.StudentRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import tools.jackson.databind.ObjectMapper;

@Slf4j
@RequiredArgsConstructor
@Transactional
@Service
public class StudentServicesImpl implements StudentServices {
    private final StudentRepository studentRepository;
    private final ObjectMapper mapper;
    @Override
    public ResponseEntity<StudentRegisterResponse> registerStudent(StudentRegisterRequest studentRegisterRequest) {

        log.info("Indise student register services -------------------------{}",studentRegisterRequest);

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

        Student student = mapper.convertValue(studentRegisterRequest,Student.class);
        student.setRole(Role.Student);
        studentRepository.save(student);
        StudentRegisterResponse response = new StudentRegisterResponse();
        response.setMessage("User registered successfully");
        log.info("Sending response back to th student register controller");
    return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }
}
