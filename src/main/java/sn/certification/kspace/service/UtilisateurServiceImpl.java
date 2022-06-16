package sn.certification.kspace.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sn.certification.kspace.model.Utilisateur;
import sn.certification.kspace.model.UtilisateurRole;
import sn.certification.kspace.repository.RoleRepository;
import sn.certification.kspace.repository.UtilisateurRepository;

import java.util.Collection;

@Service
public class UtilisateurServiceImpl implements UtilisateurService {

    private UtilisateurRepository utilisateurRepository;
    private RoleRepository roleRepository;

    // Utilisation du constructeur avec argument pour utiRepo et roleRepo pour l'injection des dépendences au lieu de @Autowired
    public UtilisateurServiceImpl(UtilisateurRepository utilisateurRepository, RoleRepository roleRepository) {
        this.utilisateurRepository = utilisateurRepository;
        this.roleRepository = roleRepository;
    }

    //Méthode de création d'un user impléméntée dp8 l'interface
    @Override
    public Utilisateur createUser(Utilisateur utilisateur, Collection<UtilisateurRole> utilisateurRoles) {
        Utilisateur uti = this.utilisateurRepository.findByPseudo(utilisateur.getPseudo());
        if (uti != null) {
            System.out.println("Cet utilisateur existe déjà !");
        } else {
            // création d'un utilisateur
            for(UtilisateurRole utiRole:utilisateurRoles)
            {
                roleRepository.save(utiRole.getRole());
            }

            utilisateur.getUserRole().addAll(utilisateurRoles);
            uti = this.utilisateurRepository.save(utilisateur);
        }
        return uti;
    }
}
