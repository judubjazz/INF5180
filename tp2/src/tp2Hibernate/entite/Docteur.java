package tp2Hibernate.entite;
// Generated Apr 8, 2018 2:33:08 AM by HibernateUtil Tools 4.3.1


import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;

/**
 * Docteur generated by hbm2java
 */
public class Docteur  implements java.io.Serializable {


     private BigDecimal matricule;
     private Specialite specialite;
     private String nomm;
     private String prenomm;
     private String ville;
     private String adresse;
     private String niveau;
     private BigDecimal nbrpatients;
     private Set consultations = new HashSet(0);
     private Set dossierpatients = new HashSet(0);

    public Docteur() {
    }

	
    public Docteur(BigDecimal matricule, String nomm, String prenomm) {
        this.matricule = matricule;
        this.nomm = nomm;
        this.prenomm = prenomm;
    }
    public Docteur(BigDecimal matricule, Specialite specialite, String nomm, String prenomm, String ville, String adresse, String niveau, BigDecimal nbrpatients, Set consultations, Set dossierpatients) {
       this.matricule = matricule;
       this.specialite = specialite;
       this.nomm = nomm;
       this.prenomm = prenomm;
       this.ville = ville;
       this.adresse = adresse;
       this.niveau = niveau;
       this.nbrpatients = nbrpatients;
       this.consultations = consultations;
       this.dossierpatients = dossierpatients;
    }
   
    public BigDecimal getMatricule() {
        return this.matricule;
    }
    
    public void setMatricule(BigDecimal matricule) {
        this.matricule = matricule;
    }
    public Specialite getSpecialite() {
        return this.specialite;
    }
    
    public void setSpecialite(Specialite specialite) {
        this.specialite = specialite;
    }
    public String getNomm() {
        return this.nomm;
    }
    
    public void setNomm(String nomm) {
        this.nomm = nomm;
    }
    public String getPrenomm() {
        return this.prenomm;
    }
    
    public void setPrenomm(String prenomm) {
        this.prenomm = prenomm;
    }
    public String getVille() {
        return this.ville;
    }
    
    public void setVille(String ville) {
        this.ville = ville;
    }
    public String getAdresse() {
        return this.adresse;
    }
    
    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }
    public String getNiveau() {
        return this.niveau;
    }
    
    public void setNiveau(String niveau) {
        this.niveau = niveau;
    }
    public BigDecimal getNbrpatients() {
        return this.nbrpatients;
    }
    
    public void setNbrpatients(BigDecimal nbrpatients) {
        this.nbrpatients = nbrpatients;
    }

    public Set getConsultations() {
        return this.consultations;
    }
    
    public void setConsultations(Set consultations) {
        this.consultations = consultations;
    }
    public Set getDossierpatients() {
        return this.dossierpatients;
    }
    
    public void setDossierpatients(Set dossierpatients) {
        this.dossierpatients = dossierpatients;
    }

    @Override
    public String toString() {
        return "Docteur{" +
                "matricule=" + matricule +
                ", specialite=" + specialite +
                ", nomm='" + nomm + '\'' +
                ", prenomm='" + prenomm + '\'' +
                ", ville='" + ville + '\'' +
                ", adresse='" + adresse + '\'' +
                ", niveau='" + niveau + '\'' +
                ", nbrpatients=" + nbrpatients +
                '}';
    }
}


