package com.directrory.collegeDirectory.services.studentServices;

import com.directrory.collegeDirectory.DTO.studentDto.StudentRegisterRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;


@Service
public interface StudentServices {
    ResponseEntity<String> registerStudent(StudentRegisterRequest studentRegisterRequest);
}
