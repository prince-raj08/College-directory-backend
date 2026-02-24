package com.directrory.collegeDirectory.services.facultyServices;

import com.directrory.collegeDirectory.DTO.facultyDto.FacultyLoginRequest;
import com.directrory.collegeDirectory.DTO.facultyDto.FacultyLoginResponse;
import com.directrory.collegeDirectory.DTO.facultyDto.ListFaculty;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface FacultyService {
    public ResponseEntity<FacultyLoginResponse> login(FacultyLoginRequest facultyLoginRequest);
    public ResponseEntity<List<ListFaculty>> facultyList();
}
