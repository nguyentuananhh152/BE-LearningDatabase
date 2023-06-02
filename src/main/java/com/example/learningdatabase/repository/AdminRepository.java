package com.example.learningdatabase.repository;

import com.example.learningdatabase.entity.Admin;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AdminRepository extends JpaRepository<Admin, Integer> {
}
