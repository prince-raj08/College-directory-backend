package com.directrory.collegeDirectory.services.AuthServices;

import org.springframework.stereotype.Service;

@Service
public interface AuthServices {
    public boolean sendOtp(String email);
    public boolean verifyOtp(String email, String otp);
    public void updatePassword(String email, String password);
    public boolean registerOtp(String email);
}
