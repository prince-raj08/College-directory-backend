package com.directrory.collegeDirectory.services.studentServices;

import com.directrory.collegeDirectory.DTO.studentDto.StudentRegisterRequest;
import com.directrory.collegeDirectory.common.Role;
import com.directrory.collegeDirectory.entity.Student;
import com.directrory.collegeDirectory.repository.StudentRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import tools.jackson.databind.ObjectMapper;

@Slf4j
@RequiredArgsConstructor
@Service
public class StudentServicesImpl implements StudentServices {
    private final StudentRepository studentRepository;
    private final ObjectMapper mapper;
    @Override
    public ResponseEntity<String> registerStudent(StudentRegisterRequest studentRegisterRequest) {

        log.info("Indise student register services -------------------------{}",studentRegisterRequest);

        Student student = mapper.convertValue(studentRegisterRequest,Student.class);
        student.setRole(Role.Student);
        studentRepository.save(student);
        log.info("Sending response back to th student register controller");
    return ResponseEntity.status(HttpStatus.CREATED).body("User registered successfully");
    }
}
