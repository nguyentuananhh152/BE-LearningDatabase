package com.example.learningdatabase.repository;

import com.example.learningdatabase.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepository extends JpaRepository<Student, Integer> {
}
