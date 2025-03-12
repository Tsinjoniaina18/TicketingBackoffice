package com.backoffice.utilisateur;

import jakarta.persistence.*;

@Entity
@Table(name = "utilisateur")
public class Utilisateur {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_utilisateur")
    @SequenceGenerator(name = "seq_utilisateur", sequenceName = "seq_utilisateur", allocationSize = 1)
    private String id;

    private String nom;
    private String email;
    private String password;
    private int role;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getRole() {
        return role;
    }

    public void setRole(int role) {
        this.role = role;
    }
}
