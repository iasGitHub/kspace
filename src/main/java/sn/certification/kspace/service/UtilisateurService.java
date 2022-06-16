package sn.certification.kspace.service;

import org.springframework.context.annotation.Bean;
import sn.certification.kspace.model.Utilisateur;
import sn.certification.kspace.model.UtilisateurRole;

import java.util.Collection;

public interface UtilisateurService {

    // création d'un utilisateur
    public Utilisateur createUser(Utilisateur utilisateur, Collection<UtilisateurRole> utilisateurRoles);
}
