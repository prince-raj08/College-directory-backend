package com.directrory.collegeDirectory.DTO.studentDto;

import lombok.Data;

@Data
public class DashboardResponse {
    private Long id;
    private String name;
    private String email;
    private String phone;
    private String department;
    private String year;
    private String profile;
}

