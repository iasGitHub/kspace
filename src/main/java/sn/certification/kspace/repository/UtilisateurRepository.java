package sn.certification.kspace.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import sn.certification.kspace.model.Utilisateur;

public interface UtilisateurRepository extends JpaRepository<Utilisateur, Long> {

    public Utilisateur findByPseudo(String pseudo);
}
