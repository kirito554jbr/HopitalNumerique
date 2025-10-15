package com.example.hopitalnumerique.Repository.Interfaces;

import com.example.hopitalnumerique.Model.Department;
import com.example.hopitalnumerique.Model.Salle;

import java.util.List;

public interface IDepartmentRepository {
    void create(Department department);
    Department read(int id);
    List<Department> readAll();
    void update(Department department, int id);
    void delete(int id);
    Department finByNom(String nom);
}
