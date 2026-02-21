package com.directrory.collegeDirectory.common;

import lombok.Data;

@Data
public class VerifyOtpRequest {
    private String email;
    private String otp;
}
