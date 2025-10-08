package com.example.hopitalnumerique.Service;

import com.example.hopitalnumerique.Model.Admin;
import com.example.hopitalnumerique.Repository.AdminRepository;
import com.example.hopitalnumerique.Repository.Interfaces.IAdminRepository;
import com.example.hopitalnumerique.Service.Interfaces.IAdminService;

import java.util.List;

public class AdminService implements IAdminService {
    private IAdminRepository adminRepository;

    public AdminService(IAdminRepository adminRepository) {
        this.adminRepository = adminRepository;
    }

    @Override
    public void create(Admin admin) {
        this.adminRepository.create(admin);
    }

    @Override
    public Admin read(int id) {
        return this.adminRepository.read(id);
    }

    @Override
    public List<Admin> readAll() {
        return this.adminRepository.readAll();
    }

    @Override
    public void update(Admin admin, int id) {
        this.adminRepository.update(admin, id);
    }

    @Override
    public void delete(int id) {
        this.adminRepository.delete(id);
    }
}
