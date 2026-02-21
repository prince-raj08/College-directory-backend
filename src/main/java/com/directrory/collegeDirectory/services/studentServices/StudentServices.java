package com.directrory.collegeDirectory.services.studentServices;

import com.directrory.collegeDirectory.DTO.studentDto.*;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;


@Service
public interface StudentServices {
    ResponseEntity<StudentRegisterResponse> registerStudent(StudentRegisterRequest studentRegisterRequest);
    ResponseEntity<StudentLoginResponse> login(StudentLoginRequest studentLoginRequest);
    ResponseEntity<DashboardResponse> dashboard(@PathVariable Long id);
}
