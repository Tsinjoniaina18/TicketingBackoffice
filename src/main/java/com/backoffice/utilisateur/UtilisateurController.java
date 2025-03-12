package com.backoffice.utilisateur;

import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.Optional;

@Controller
@RequestMapping("/admin")
public class UtilisateurController {

    @Autowired
    private HttpSession httpSession;

    @Autowired
    private UtilisateurService utilisateurService;

    @PostMapping("/check")
    public String check(@RequestParam("email") String email, @RequestParam("password") String password){
        Optional<Utilisateur> utilisateur = utilisateurService.check(email, password);
        if(utilisateur.isPresent()){
            httpSession.setAttribute("utilisateur", utilisateur.get());
            return "redirect:/admin/config";
        }
        return "home";
    }

}
