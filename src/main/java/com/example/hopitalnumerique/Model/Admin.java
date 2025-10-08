package com.example.hopitalnumerique.Model;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@ApplicationScoped
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
@Entity
@Table(name = "Admin")
public class Admin extends Personne{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idAdmin;

}
