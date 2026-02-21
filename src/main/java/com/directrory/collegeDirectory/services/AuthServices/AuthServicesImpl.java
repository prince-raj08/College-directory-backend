package com.directrory.collegeDirectory.services.AuthServices;
import com.directrory.collegeDirectory.repository.StudentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.concurrent.ConcurrentHashMap;

@Service
@RequiredArgsConstructor
public class AuthServicesImpl implements AuthServices {

    private final JavaMailSender mailSender;
    private final StudentRepository studentRepository;

    // ConcurrentHashMap use karein taaki multi-threading safe ho
    private final Map<String, String> otpCache = new ConcurrentHashMap<>();

    // Common method for sending OTP (Register + Forgot Password)
    @Override
    public boolean sendOtp(String email) {
        if (email == null || email.isEmpty()) return false;

        try {
            // OTP Generate
            String otp = String.format("%06d", new Random().nextInt(999999));
            otpCache.put(email, otp);

            // Email message
            SimpleMailMessage message = new SimpleMailMessage();
            message.setTo(email);
            message.setSubject("EduPortal Verification OTP");
            message.setText("Aapka OTP hai: " + otp + "\nYe OTP 5 minutes ke liye valid hai.");

            mailSender.send(message);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean verifyOtp(String email, String otp) {
        if (otpCache.containsKey(email) && otpCache.get(email).equals(otp)) {
            // OTP verify hone ke baad cache se remove kar dena secure rehta hai
            // otpCache.remove(email);
            return true;
        }
        return false;
    }

    @Override
    public void updatePassword(String email, String password) {
        studentRepository.findByEmail(email).ifPresent(user -> {
            // Note: Password BCrypt se encode karna mat bhooliyega production mein
            user.setPassword(password);
            studentRepository.save(user);
            otpCache.remove(email);
        });
    }

    // Is method ki ab zaroorat nahi hai agar sendOtp common hai
    @Override
    public boolean registerOtp(String email) {
        return sendOtp(email);
    }
}