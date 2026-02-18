package com.directrory.collegeDirectory.services.studentServices;

import com.directrory.collegeDirectory.DTO.studentDto.StudentRegisterRequest;
import com.directrory.collegeDirectory.DTO.studentDto.StudentRegisterResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;


@Service
public interface StudentServices {
    ResponseEntity<StudentRegisterResponse> registerStudent(StudentRegisterRequest studentRegisterRequest);
}
