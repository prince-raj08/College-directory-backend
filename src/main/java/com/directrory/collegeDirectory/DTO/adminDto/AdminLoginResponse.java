package com.directrory.collegeDirectory.DTO.adminDto;

import com.directrory.collegeDirectory.common.Role;
import com.directrory.collegeDirectory.entity.Department;
import jakarta.persistence.*;
import lombok.Data;

@Data
public class AdminLoginResponse {

    private Long id;
    private String name;
    private String email;
    private String phone;
    private String role;
    private Department department;

}
