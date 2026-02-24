    package com.directrory.collegeDirectory.controller.studentController;


    import com.directrory.collegeDirectory.DTO.studentDto.*;
    import com.directrory.collegeDirectory.services.studentServices.StudentServicesImpl;
    import lombok.RequiredArgsConstructor;
    import lombok.extern.slf4j.Slf4j;
    import org.springframework.http.ResponseEntity;
    import org.springframework.web.bind.annotation.*;

    import java.util.List;

    @CrossOrigin(origins = "http://localhost:5173")
    @Slf4j
    @RequiredArgsConstructor
    @RestController
    @RequestMapping("/api/v1/student")
    public class StudentController {
        private final StudentServicesImpl studentServices;

        @PostMapping(value = "/register", consumes = "multipart/form-data")
        public ResponseEntity<StudentRegisterResponse> registerStudent(@ModelAttribute StudentRegisterRequest studentRegisterRequest)
        {
            log.info("Inside student register controller --------------------------->");
            ResponseEntity<StudentRegisterResponse> response = studentServices.registerStudent(studentRegisterRequest);
            log.info("Sending response back to client  -----------------------------{}",response);
            return response;
        }

        @PostMapping("login")
        public ResponseEntity<StudentLoginResponse> login(@RequestBody StudentLoginRequest studentLoginRequest)
        {
            log.info("Inside student login controller ------------------> ");
            ResponseEntity<StudentLoginResponse> response = studentServices.login(studentLoginRequest);
            log.info("Sending respinse back to the client --------------------------->");
            return response;
        }


        @GetMapping("/profile/{id}")
        public ResponseEntity<DashboardResponse> getStudentProfile(@PathVariable Long id) {
            log.info("Inside student dashboard controller ------------------------>");
            ResponseEntity<DashboardResponse> response = studentServices.dashboard(id);
            log.info("Sending response to the client ----------------------------->");
            return response;
        }

        @GetMapping("/list-student")
        public ResponseEntity<List<StudentList>> getAllStudent()
        {
            log.info("Inside get all student controller ----------------------->");
            ResponseEntity<List<StudentList>> response = studentServices.getAllStudent();
            log.info("Sending response back to the client ---------------------->");
            return response;
        }
    }
