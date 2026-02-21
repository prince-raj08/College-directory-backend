package com.directrory.collegeDirectory.DTO.studentDto;

import lombok.Data;

@Data
public class StudentLoginResponse {
        private Long Id;
        private String name;
        private String email;
        private String role;
}
