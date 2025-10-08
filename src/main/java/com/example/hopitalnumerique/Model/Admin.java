package com.example.hopitalnumerique.Model;

import jakarta.persistence.*;

@Entity
@Table(name = "Admin")
public class Admin extends Personne{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idAdmin;

    public Admin(int idAdmin) {
        this.idAdmin = idAdmin;
    }

    public Admin() {
        super();
    }

    public int getIdAdmin() {
        return idAdmin;
    }

    public void setIdAdmin(int idAdmin) {
        this.idAdmin = idAdmin;
    }

    @Override
    public String toString() {
        return "Admin{" +
                "idAdmin=" + idAdmin +
                '}';
    }
}
