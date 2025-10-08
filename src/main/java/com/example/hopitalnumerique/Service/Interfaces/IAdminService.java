package com.example.hopitalnumerique.Service.Interfaces;

import com.example.hopitalnumerique.Model.Admin;
import com.example.hopitalnumerique.Model.Salle;

import java.util.List;

public interface IAdminService {
    void create(Admin admin);
    Admin read(int id);
    List<Admin> readAll();
    void update(Admin admin, int id);
    void delete(int id);
}
