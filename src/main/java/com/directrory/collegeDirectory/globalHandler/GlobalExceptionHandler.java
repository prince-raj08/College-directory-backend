package com.directrory.collegeDirectory.globalHandler;


import com.directrory.collegeDirectory.DTO.studentDto.StudentRegisterResponse;
import com.directrory.collegeDirectory.globalHandler.exception.CommonException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@Slf4j
@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(CommonException.class)
    public ResponseEntity<StudentRegisterResponse> handleCommonException(CommonException commonException)
    {
        log.error("Inside common excepion handler --------------------->{}",commonException);
        StudentRegisterResponse response = new StudentRegisterResponse();
        response.setMessage(commonException.getMessage());
        log.info("sending response to client through exception handler ------------------>{}",response);
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
    }
}
