package com.directrory.collegeDirectory.services.adminServices;

import com.directrory.collegeDirectory.DTO.adminDto.AdminLoginRequest;
import com.directrory.collegeDirectory.DTO.adminDto.AdminLoginResponse;
import com.directrory.collegeDirectory.common.Role;
import com.directrory.collegeDirectory.entity.Admin;
import com.directrory.collegeDirectory.globalHandler.exception.SecurityError;
import com.directrory.collegeDirectory.repository.AdminRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AdminServicesImpl implements AdminService{
    private final AdminRepository adminRepository;
    @Override
    public ResponseEntity<AdminLoginResponse> login(AdminLoginRequest adminLoginRequest) {

        Admin admin = adminRepository.findByEmail(adminLoginRequest.getEmail()).orElseThrow(()-> new SecurityError("Invalid Email"));

        if(!admin.getPassword().equals(adminLoginRequest.getPassword()))
        {
            throw new SecurityError("Invalid Password");
        }

        AdminLoginResponse response = new AdminLoginResponse();
        response.setId(admin.getId());
        response.setName(admin.getName());
        response.setEmail(admin.getEmail());
        response.setPhone(admin.getPhone());
        response.setRole(String.valueOf(Role.ADMINISTRATOR));
        response.setDepartment(admin.getDepartment());
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }
}
