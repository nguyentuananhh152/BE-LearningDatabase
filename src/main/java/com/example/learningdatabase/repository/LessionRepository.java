package com.example.learningdatabase.repository;

import com.example.learningdatabase.entity.Lesson;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LessionRepository extends JpaRepository<Lesson, Integer> {
}
