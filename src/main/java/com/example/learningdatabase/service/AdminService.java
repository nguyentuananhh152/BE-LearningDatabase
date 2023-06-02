package com.example.learningdatabase.service;

import com.example.learningdatabase.entity.Admin;
import org.springframework.stereotype.Service;

@Service
public interface AdminService {
    public void getAdminByID(int id);
    public void updateAdminByID(int id, Admin admin);
    public void deleteAdminByID(int id);
}
