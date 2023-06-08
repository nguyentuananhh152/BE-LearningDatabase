package com.example.learningdatabase.service;

import com.example.learningdatabase.entity.Admin;
import org.springframework.stereotype.Service;

@Service
public interface AdminService {
    public Admin saveAdmin(Admin admin);
    public Admin getAdminByID(int id);
    public void deleteAdminByID(int id);

    public boolean exist(int id);
}
