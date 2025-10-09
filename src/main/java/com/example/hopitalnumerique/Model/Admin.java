package com.example.hopitalnumerique.Model;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@ApplicationScoped
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
@Data
@Entity
@Table(name = "Admin")
public class Admin extends Personne{

//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private int idAdmin;
    private String nom;

}
