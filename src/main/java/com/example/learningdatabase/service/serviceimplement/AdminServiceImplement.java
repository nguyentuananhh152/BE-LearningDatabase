package com.example.learningdatabase.service.serviceimplement;

import com.example.learningdatabase.entity.Admin;
import com.example.learningdatabase.repository.AdminRepository;
import com.example.learningdatabase.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AdminServiceImplement implements AdminService {

    @Autowired
    private AdminRepository adminRepository;

    public AdminServiceImplement() {}

    @Override
    public Admin saveAdmin(Admin admin) {
        try {
            if (!adminRepository.existsById(admin.getId())) {
                adminRepository.save(admin);
                return admin;
            } else {
                return null;
            }
        } catch(Exception e) {
            return null;
        }
    }

    @Override
    public Admin getAdminByID(int id) {
        try {
            if (adminRepository.existsById(id)) {
                return adminRepository.findById(id).get();
            } else {
                return new Admin();
            }
        } catch (Exception e) {
            return null;
        }
    }

    @Override
    public void deleteAdminByID(int id) {
        try {
            if (adminRepository.existsById(id)) {
                adminRepository.deleteById(id);
            }
        } catch (Exception e) {}
    }

    @Override
    public boolean exist(int id) {
        if (adminRepository.existsById(id)) {
            return true;
        } else {
            return false;
        }
    }
}

