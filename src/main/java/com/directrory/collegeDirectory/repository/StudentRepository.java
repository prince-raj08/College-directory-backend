package com.directrory.collegeDirectory.repository;

import com.directrory.collegeDirectory.entity.Student;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface StudentRepository extends JpaRepository<Student,Long> {

    Optional<Student> findByEmail(String email);
    Optional<Student> findByPhone(String phone);
    Optional<Student> findByUsername(String username);
}
