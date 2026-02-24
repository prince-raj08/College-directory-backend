package com.directrory.collegeDirectory.services.facultyServices;

import com.directrory.collegeDirectory.DTO.facultyDto.FacultyLoginRequest;
import com.directrory.collegeDirectory.DTO.facultyDto.FacultyLoginResponse;
import com.directrory.collegeDirectory.DTO.facultyDto.ListFaculty;
import com.directrory.collegeDirectory.DTO.studentDto.StudentList;
import com.directrory.collegeDirectory.entity.FacultyProfile;
import com.directrory.collegeDirectory.entity.Student;
import com.directrory.collegeDirectory.globalHandler.exception.SecurityError;
import com.directrory.collegeDirectory.repository.FacultyRespository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class FacultyServicesImpl implements FacultyService{
    private final FacultyRespository facultyRespository;
    @Override
    public ResponseEntity<FacultyLoginResponse> login(FacultyLoginRequest facultyLoginRequest) {
        FacultyProfile faculty = facultyRespository.findByEmail(facultyLoginRequest.getEmail()).orElseThrow(()-> new SecurityError("Invalid Email"));

        if(!facultyLoginRequest.getPassword().equals(facultyLoginRequest.getPassword()))
        {
            throw new SecurityError("Invalid Password");
        }

        FacultyLoginResponse response = new FacultyLoginResponse();
        response.setId(faculty.getId());
        response.setName(faculty.getName());
        response.setEmail(faculty.getEmail());
        response.setDepartment(faculty.getDepartment());
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }

    @Override
    public ResponseEntity<List<ListFaculty>> facultyList() {
        log.info("Inside Student list services ------------------>");
        List<FacultyProfile> faculty = facultyRespository.findAll();
        List<ListFaculty> list = new ArrayList<>();
        for( FacultyProfile f : faculty)
        {
           ListFaculty result = new ListFaculty();
           result.setName(f.getName());
           result.setEmail(f.getEmail());
           result.setContact(f.getPhone());
           result.setDepartment(f.getDepartment().getDept());
            list.add(result);
        }

        return ResponseEntity.status(HttpStatus.OK).body(list);
    }
}
