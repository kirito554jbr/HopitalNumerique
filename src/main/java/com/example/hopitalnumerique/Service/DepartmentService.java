package com.example.hopitalnumerique.Service;

import com.example.hopitalnumerique.Model.Department;
import com.example.hopitalnumerique.Repository.Interfaces.IDepartmentRepository;
import com.example.hopitalnumerique.Service.Interfaces.IDepartmentService;
import jakarta.persistence.EntityNotFoundException;

import java.util.List;

public class DepartmentService implements IDepartmentService {
    private IDepartmentRepository departmentRepository;

    public DepartmentService(IDepartmentRepository departmentRepository) {
        this.departmentRepository = departmentRepository;
    }

    @Override
    public void create(Department department) throws IllegalArgumentException{
        if (department == null) {
            throw new IllegalArgumentException("Department cannot be null.");
        }

        if (department.getNom() == null || department.getNom().trim().isEmpty()) {
            throw new IllegalArgumentException("Department name cannot be null or empty.");
        }


        Department existingDepartment = departmentRepository.finByNom(department.getNom());
        if (existingDepartment != null) {
            throw new IllegalStateException("A department with the same name already exists.");
        }

        this.departmentRepository.create(department);
    }


    @Override
    public Department read(int id) throws EntityNotFoundException{
        if (id <= 0) {
            return null;
        }
        Department department = this.departmentRepository.read(id);
        if (department == null) {
            throw new EntityNotFoundException("Department with id " + id + " not found.");
        }
        return department;
    }

    @Override
    public List<Department> readAll() throws EntityNotFoundException {
        List<Department> departments = this.departmentRepository.readAll();
        if (departments.isEmpty()) {
            throw new EntityNotFoundException("Department not found.");
        }
        return departments;
    }

    @Override
    public void update(Department department, int id) throws IllegalArgumentException{
        if (department == null) {
            throw new IllegalArgumentException("Department cannot be null.");
        }

        // Check if department exists before updating
        Department existingDepartment = departmentRepository.read(id);
        if (existingDepartment == null) {
            throw new EntityNotFoundException("Department with ID " + id + " not found.");
        }

        // Validate name
        if (department.getNom() == null || department.getNom().trim().isEmpty()) {
            throw new IllegalArgumentException("Department name cannot be null or empty.");
        }

        // Optional: Check if another department with the same name already exists
        Department duplicate = departmentRepository.finByNom(department.getNom());
        if (duplicate != null && duplicate.getIdDepartment() != id) {
            throw new IllegalStateException("A department with this name already exists.");
        }


        departmentRepository.update(existingDepartment, id);
    }


    @Override
    public void delete(int id) throws IllegalArgumentException {
        if (id <= 0) {
            throw new IllegalArgumentException("Department ID cannot be null.");
        }
        this.departmentRepository.delete(id);
    }

    @Override
    public Department finByNom(String nom) {
        return this.departmentRepository.finByNom(nom);
    }
}
