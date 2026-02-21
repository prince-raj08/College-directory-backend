package com.directrory.collegeDirectory.common;

import com.directrory.collegeDirectory.services.AuthServices.AuthServicesImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/v1/auth")
@CrossOrigin(origins = "http://localhost:5173") // React ka default port
public class AuthController {

    private final AuthServicesImpl authService;

    // 1. Send OTP
    @PostMapping("/forgot-password")
    public ResponseEntity<?> forgotPassword(@RequestBody ForgotPasswordRequest request) {
        boolean sent = authService.sendOtp(request.getEmail());
        if (sent) return ResponseEntity.ok().build();
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("User not found");
    }



    @PostMapping("/verify-email")
    public ResponseEntity<?> emailVerify(@RequestBody VerifyEmail request) {
        boolean sent = authService.sendOtp(request.getEmail());
        if (sent) return ResponseEntity.ok().build();
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Try Again ");
    }



    // 2. Verify OTP
    @PostMapping("/verify-otp")
    public ResponseEntity<?> verifyOtp(@RequestBody VerifyOtpRequest request) {
        boolean isValid = authService.verifyOtp(request.getEmail(), request.getOtp());
        if (isValid) return ResponseEntity.ok().build();
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Invalid OTP");
    }

    // 3. Reset Password
    @PostMapping("/reset-password")
    public ResponseEntity<?> resetPassword(@RequestBody ResetPasswordRequest request) {
        authService.updatePassword(request.getEmail(), request.getPassword());
        return ResponseEntity.ok().body("Password updated successfully");
    }
}
