package com.directrory.collegeDirectory.repository;

import com.directrory.collegeDirectory.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student,Long> {
}
