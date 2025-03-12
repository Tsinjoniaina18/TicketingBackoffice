package com.backoffice.utilisateur;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UtilisateurRepository extends JpaRepository<Utilisateur, String> {
    @Query("select u from Utilisateur u where u.email = :email and u.password = :password and u.role = 1")
    Optional<Utilisateur> check (@Param("email") String email, @Param("password") String password);
}