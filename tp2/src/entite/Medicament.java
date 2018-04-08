package entite;
// Generated Apr 8, 2018 2:33:08 AM by Hibernate Tools 4.3.1


import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;

/**
 * Medicament generated by hbm2java
 */
public class Medicament  implements java.io.Serializable {


     private BigDecimal idmed;
     private Categories categories;
     private String nommed;
     private BigDecimal prix;
     private Set ordonnancemedicamentses = new HashSet(0);

    public Medicament() {
    }

	
    public Medicament(BigDecimal idmed, String nommed) {
        this.idmed = idmed;
        this.nommed = nommed;
    }
    public Medicament(BigDecimal idmed, Categories categories, String nommed, BigDecimal prix, Set ordonnancemedicamentses) {
       this.idmed = idmed;
       this.categories = categories;
       this.nommed = nommed;
       this.prix = prix;
       this.ordonnancemedicamentses = ordonnancemedicamentses;
    }
   
    public BigDecimal getIdmed() {
        return this.idmed;
    }
    
    public void setIdmed(BigDecimal idmed) {
        this.idmed = idmed;
    }
    public Categories getCategories() {
        return this.categories;
    }
    
    public void setCategories(Categories categories) {
        this.categories = categories;
    }
    public String getNommed() {
        return this.nommed;
    }
    
    public void setNommed(String nommed) {
        this.nommed = nommed;
    }
    public BigDecimal getPrix() {
        return this.prix;
    }
    
    public void setPrix(BigDecimal prix) {
        this.prix = prix;
    }
    public Set getOrdonnancemedicamentses() {
        return this.ordonnancemedicamentses;
    }
    
    public void setOrdonnancemedicamentses(Set ordonnancemedicamentses) {
        this.ordonnancemedicamentses = ordonnancemedicamentses;
    }




}


