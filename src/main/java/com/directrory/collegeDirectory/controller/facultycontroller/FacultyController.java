package com.directrory.collegeDirectory.controller.facultycontroller;
import com.directrory.collegeDirectory.DTO.facultyDto.FacultyLoginRequest;
import com.directrory.collegeDirectory.DTO.facultyDto.FacultyLoginResponse;
import com.directrory.collegeDirectory.DTO.facultyDto.ListFaculty;
import com.directrory.collegeDirectory.DTO.studentDto.StudentList;
import com.directrory.collegeDirectory.services.facultyServices.FacultyServicesImpl;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:5173")
@Slf4j
@RequiredArgsConstructor
@RestController
@RequestMapping("/api/v1/faculty-member")
public class FacultyController {

    private final FacultyServicesImpl facultyServices;

    @PostMapping("login")
    public ResponseEntity<FacultyLoginResponse> login(@RequestBody FacultyLoginRequest facultyLoginRequest) {
        log.info("Inside faculty login controller ------------------> ");
        ResponseEntity<FacultyLoginResponse> response = facultyServices.login(facultyLoginRequest);
        log.info("Sending response back to the client --------------------------->");
        return response;
    }


    @GetMapping("/list-faculty")
    public ResponseEntity<List<ListFaculty>> getAllfaculty() {
        log.info("Inside get all faculty controller ----------------------->");
        ResponseEntity<List<ListFaculty>> response = facultyServices.facultyList();
        log.info("Sending response back to the client ---------------------->");
        return response;
    }

}
