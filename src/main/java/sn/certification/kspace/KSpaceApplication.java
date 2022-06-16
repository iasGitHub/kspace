package sn.certification.kspace;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import sn.certification.kspace.model.Role;
import sn.certification.kspace.model.Utilisateur;
import sn.certification.kspace.model.UtilisateurRole;
import sn.certification.kspace.service.UtilisateurService;

import java.util.HashSet;
import java.util.Set;


@SpringBootApplication
public class KSpaceApplication implements CommandLineRunner {

    @Autowired
    private UtilisateurService utilisateurService;
    public static void main(String[] args) {
        SpringApplication.run(KSpaceApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {

        System.out.println("Enregistrement des utilisateurs");

        Utilisateur utilisateur = new Utilisateur();
        utilisateur.setNom("Kane");
        utilisateur.setPrenom("Samba");
        utilisateur.setPseudo("KBery");
        utilisateur.setFonction("Formateur Simplon");
        utilisateur.setEmail("samba23@gmail.com");
        utilisateur.setPassword("Passer123");
        utilisateur.setSexe("Masculin");

        Role role1 = new Role();
        role1.setRoleId(11L);
        role1.setLibelle("ADMIN");

        Set<UtilisateurRole> utilisateurRolesSet = new HashSet<>();
        UtilisateurRole utilisateurRole = new UtilisateurRole();

        utilisateurRole.setRole(role1);
        utilisateurRole.setUtilisateur(utilisateur);

        utilisateurRolesSet.add(utilisateurRole);

        Utilisateur utilisateur1 = this.utilisateurService.createUser(utilisateur,utilisateurRolesSet);
        System.out.println(utilisateur1.getNom() + " " + utilisateur1.getUserRole());
    }
}
