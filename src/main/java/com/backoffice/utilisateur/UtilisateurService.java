package com.backoffice.utilisateur;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UtilisateurService {

    @Autowired
    private UtilisateurRepository utilisateurRepository;

    public Optional<Utilisateur> check (String email, String password){
        return utilisateurRepository.check(email, password);
    }

}
