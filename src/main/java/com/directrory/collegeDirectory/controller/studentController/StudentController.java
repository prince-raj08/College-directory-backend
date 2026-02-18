package com.directrory.collegeDirectory.controller.studentController;


import com.directrory.collegeDirectory.DTO.studentDto.StudentRegisterRequest;
import com.directrory.collegeDirectory.services.studentServices.StudentServicesImpl;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "http://localhost:5173")
@Slf4j
@RequiredArgsConstructor
@RestController
@RequestMapping("/api/v1/student")
public class StudentController {
    private final StudentServicesImpl studentServices;

    @PostMapping("/register")
    public ResponseEntity<String> registerStudent(@RequestBody StudentRegisterRequest studentRegisterRequest)
    {
        log.info("Inside student register controller ---------------------------{}",studentRegisterRequest);
        ResponseEntity<String> response = studentServices.registerStudent(studentRegisterRequest);
        log.info("Sending response back to client  -----------------------------{}",response);
        return response;
    }

}
