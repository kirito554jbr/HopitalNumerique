package com.example.hopitalnumerique.Service.Interfaces;

import com.example.hopitalnumerique.Model.Department;
import jakarta.persistence.EntityNotFoundException;

import java.util.List;

public interface IDepartmentService {
    void create(Department department)  throws IllegalArgumentException;
    Department read(int id)  throws EntityNotFoundException;
    List<Department> readAll() throws EntityNotFoundException;
    void update(Department department, int id) throws IllegalArgumentException;
    void delete(int id) throws IllegalArgumentException;
    Department finByNom(String nom);
}
