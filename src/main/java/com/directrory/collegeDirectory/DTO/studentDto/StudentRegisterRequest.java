package com.directrory.collegeDirectory.DTO.studentDto;


import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;
import org.hibernate.validator.constraints.*;

@Data
public class StudentRegisterRequest {

    @Length(min = 3, max=45)
    private String name;
    @Length(min = 3, max=45)
    private String username;
    @Email
    private String email;
    @Length(min = 10, max=10)
    private String phone;
    @Length(min = 8)
    private String password;
    @NotBlank
    private String dept;
    @NotBlank
    private String year;
}
