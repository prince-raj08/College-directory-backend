package com.directrory.collegeDirectory.repository;

import com.directrory.collegeDirectory.entity.FacultyProfile;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface FacultyRespository extends JpaRepository<FacultyProfile,Long> {
    Optional<FacultyProfile> findByEmail(String email);
}
