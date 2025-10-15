package com.example.hopitalnumerique.Repository.Interfaces;

import com.example.hopitalnumerique.Model.Admin;

import java.util.List;

public interface IAdminRepository {
    void create(Admin admin);
    Admin read(int id);
    List<Admin> readAll();
    void update(Admin admin, int id);
    void delete(int id);
    Admin findByEmail(String email);
}
