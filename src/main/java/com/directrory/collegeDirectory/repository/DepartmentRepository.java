package com.directrory.collegeDirectory.repository;

import com.directrory.collegeDirectory.entity.Department;
import com.fasterxml.jackson.annotation.JacksonAnnotation;
import org.hibernate.sql.ast.tree.expression.JdbcParameter;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface DepartmentRepository extends JpaRepository<Department,Long> {

    Optional<Department> findByDept(String dept);
}
