package com.directrory.collegeDirectory.services.adminServices;


import com.directrory.collegeDirectory.DTO.adminDto.AdminLoginRequest;
import com.directrory.collegeDirectory.DTO.adminDto.AdminLoginResponse;
import com.directrory.collegeDirectory.common.ResetPasswordRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.awt.geom.RectangularShape;

@Service
public interface AdminService {
    ResponseEntity<AdminLoginResponse> login(AdminLoginRequest adminLoginRequest);
}
