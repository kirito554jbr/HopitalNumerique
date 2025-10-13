package com.example.hopitalnumerique.Service;

import com.example.hopitalnumerique.Model.Admin;
import com.example.hopitalnumerique.Model.Docteur;
import com.example.hopitalnumerique.Repository.AdminRepository;
import com.example.hopitalnumerique.Repository.Interfaces.IAdminRepository;
import com.example.hopitalnumerique.Service.Interfaces.IAdminService;
import jakarta.persistence.EntityNotFoundException;

import java.util.List;
import java.util.NoSuchElementException;

public class AdminService implements IAdminService {
    private IAdminRepository adminRepository;

    public AdminService(IAdminRepository adminRepository) {
        this.adminRepository = adminRepository;
    }

    @Override
    public void create(Admin admin) {
        if (admin.getNom() == null || admin.getPrenom() == null ||
                admin.getEmail() == null || admin.getPassword() == null) {
            throw new IllegalArgumentException("Tous les champs obligatoires doivent être remplis.");
        }
        admin.setNom(admin.getNom().trim());
        admin.setPrenom(admin.getPrenom().trim());
        admin.setEmail(admin.getEmail().trim().toLowerCase());

        if (adminRepository.findByEmail(admin.getEmail()) != null) {
            throw new IllegalArgumentException("Un docteur avec cet email existe déjà.");
        }
        this.adminRepository.create(admin);
    }

    @Override
    public Admin read(int id){
        if (id == 0 || id < 1){
            throw new IllegalArgumentException("L'identifiant du admin doit être positif.");
        }
        Admin admin =  this.adminRepository.read(id);
        if (admin == null) {
            throw new NoSuchElementException("Aucun admin trouvé avec l'identifiant : " + id);
        }
        return admin;
    }

    @Override
    public List<Admin> readAll() {
        return this.adminRepository.readAll();
    }

    @Override
    public void update(Admin admin, int id) {
        if (id <= 0) {
            throw new IllegalArgumentException("L'identifiant du admin doit être positif.");
        }
        Admin existingAdmin = this.adminRepository.read(id);
        if (existingAdmin == null) {
            throw new NoSuchElementException("Aucun admin trouvé avec l'identifiant : " + id);
        }

        if (admin.getEmail() != null) {
            admin.setEmail(admin.getEmail().trim().toLowerCase());

            // Check for email uniqueness
            Admin existingEmail = this.adminRepository.findByEmail(admin.getEmail());
            if (existingEmail != null && existingEmail.getId() != id) {
                throw new IllegalArgumentException("L'email est déjà utilisé par un autre admin.");
            }
        }

        if (admin.getPassword() == null || admin.getPassword().isBlank()) {
            admin.setPassword(existingAdmin.getPassword());
        }
        this.adminRepository.update(admin, id);
    }

    @Override
    public void delete(int id) {
        if (id == 0 || id < 1){
            throw new IllegalArgumentException("L'identifiant du admin doit être positif.");
        }

        if (adminRepository.read(id) == null) {
            throw new EntityNotFoundException("Admin with ID " + id + " not found.");
        }

        this.adminRepository.delete(id);
    }
}
