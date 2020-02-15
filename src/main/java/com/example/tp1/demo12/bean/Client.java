package com.example.tp1.demo12.bean;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
public class Client implements Serializable {

    private static final long serialVersionUID = 1L;
    @GeneratedValue
    @Id
    private Long id;
    private String nom;
    private String prenom;
    private String cne;
    private int pointDeFiabilite;
    @DateTimeFormat(pattern = "dd-MM-yyyy")
    private Date dateDeNaissance;
    @Cascade({CascadeType.ALL})
    @OneToMany(mappedBy = "client")
    private List<Emprunt> emprunts;
    public Client() {
        super();
        // TODO Auto-generated constructor stub
    }

    public Client(Long id, String Nom, String Prenom, String cne, int pointDeFiabilite, Date dateDeNaissance) {
        this.id = id;
        this.nom = Nom;
        this.prenom = Prenom;
        this.cne = cne;
        this.pointDeFiabilite = pointDeFiabilite;
        this.dateDeNaissance = dateDeNaissance;
    }

    public int getPointDeFiabilite() {
        return pointDeFiabilite;
    }

    public void setPointDeFiabilite(int pointDeFiabilite) {
        this.pointDeFiabilite = pointDeFiabilite;
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

    public String getCne() {
        return cne;
    }

    public void setCneClient(String Cne) {
        cne = Cne;
    }

    public Date getDateDeNaissance() {
        return dateDeNaissance;
    }

    public void setDateDeNaissance(Date dateDeNaissance) {
        this.dateDeNaissance = dateDeNaissance;
    }

}
