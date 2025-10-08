package com.example.hopitalnumerique.Service;

import com.example.hopitalnumerique.Model.Department;
import com.example.hopitalnumerique.Repository.Interfaces.IDepartmentRepository;
import com.example.hopitalnumerique.Service.Interfaces.IDepartmentService;

import java.util.List;

public class DepartmentService implements IDepartmentService {
    private IDepartmentRepository departmentRepository;

    public DepartmentService(IDepartmentRepository departmentRepository) {
        this.departmentRepository = departmentRepository;
    }

    @Override
    public void create(Department department) {
        this.departmentRepository.create(department);
    }

    @Override
    public Department read(int id) {
        return this.departmentRepository.read(id);
    }

    @Override
    public List<Department> readAll() {
        return this.departmentRepository.readAll();
    }

    @Override
    public void update(Department department, int id) {
        this.departmentRepository.update(department, id);
    }

    @Override
    public void delete(int id) {
        this.departmentRepository.delete(id);
    }
}
