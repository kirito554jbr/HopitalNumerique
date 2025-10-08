package com.example.hopitalnumerique.Service.Interfaces;

import com.example.hopitalnumerique.Model.Department;
import com.example.hopitalnumerique.Model.Salle;

import java.util.List;

public interface IDepartmentService {
    void create(Department department);
    Department read(int id);
    List<Department> readAll();
    void update(Department department, int id);
    void delete(int id);
}
