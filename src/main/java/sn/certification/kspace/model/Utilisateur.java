package sn.certification.kspace.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.util.Collection;
import java.util.HashSet;

@Entity
public class Utilisateur {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotEmpty
    @Size(min = 4, max = 20)
    private String nom;
    @Size(min = 4, max = 40)
    private String prenom;
    @Column(unique = true)
    @Size(min = 4, max = 20)
    private String pseudo;
    private String fonction;
    @Column(unique = true)
    private String email;
    private String password;
    @Size(min = 4, max = 15)
    private String sexe;

    @OneToMany(cascade = CascadeType.ALL,fetch = FetchType.EAGER,mappedBy = "utilisateur")
    @JsonIgnore
    private Collection<UtilisateurRole> userRole = new HashSet<>();

    public Utilisateur() {
    }

    public Utilisateur(Long id, String nom, String prenom, String pseudo, String fonction, String email, String password, String sexe) {
        this.id = id;
        this.nom = nom;
        this.prenom = prenom;
        this.pseudo = pseudo;
        this.fonction = fonction;
        this.email = email;
        this.password = password;
        this.sexe = sexe;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getPseudo() {
        return pseudo;
    }

    public void setPseudo(String pseudo) {
        this.pseudo = pseudo;
    }

    public String getFonction() {
        return fonction;
    }

    public void setFonction(String fonction) {
        this.fonction = fonction;
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

    public String getSexe() {
        return sexe;
    }

    public void setSexe(String sexe) {
        this.sexe = sexe;
    }

    public Collection<UtilisateurRole> getUserRole() {
        return userRole;
    }

    public void setUserRole(Collection<UtilisateurRole> userRole) {
        this.userRole = userRole;
    }
}
