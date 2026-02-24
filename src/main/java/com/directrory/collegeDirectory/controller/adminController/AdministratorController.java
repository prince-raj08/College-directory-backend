package com.directrory.collegeDirectory.controller.adminController;
import com.directrory.collegeDirectory.DTO.adminDto.AdminLoginRequest;
import com.directrory.collegeDirectory.DTO.adminDto.AdminLoginResponse;
import com.directrory.collegeDirectory.DTO.studentDto.StudentLoginRequest;
import com.directrory.collegeDirectory.DTO.studentDto.StudentLoginResponse;
import com.directrory.collegeDirectory.services.adminServices.AdminServicesImpl;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "http://localhost:5173")
@Slf4j
@RequiredArgsConstructor
@RestController
@RequestMapping("/api/v1/administrator")
public class AdministratorController {
    private final AdminServicesImpl adminServices;
    @PostMapping("login")
    public ResponseEntity<AdminLoginResponse> login(@RequestBody AdminLoginRequest adminLoginRequest)
    {
        log.info("Inside admin login controller ------------------> ");
        ResponseEntity<AdminLoginResponse> response =adminServices.login(adminLoginRequest);
        log.info("Sending response back to the client --------------------------->{}",response);
        return response;
    }
}
