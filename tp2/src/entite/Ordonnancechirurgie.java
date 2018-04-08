package entite;
// Generated Apr 8, 2018 2:33:08 AM by Hibernate Tools 4.3.1


import java.math.BigDecimal;

/**
 * Ordonnancechirurgie generated by hbm2java
 */
public class Ordonnancechirurgie  implements java.io.Serializable {


     private OrdonnancechirurgieId id;
     private Ordonnance ordonnance;
     private Chirurgie chirurgie;
     private BigDecimal rang;

    public Ordonnancechirurgie() {
    }

	
    public Ordonnancechirurgie(OrdonnancechirurgieId id, Ordonnance ordonnance, Chirurgie chirurgie) {
        this.id = id;
        this.ordonnance = ordonnance;
        this.chirurgie = chirurgie;
    }
    public Ordonnancechirurgie(OrdonnancechirurgieId id, Ordonnance ordonnance, Chirurgie chirurgie, BigDecimal rang) {
       this.id = id;
       this.ordonnance = ordonnance;
       this.chirurgie = chirurgie;
       this.rang = rang;
    }
   
    public OrdonnancechirurgieId getId() {
        return this.id;
    }
    
    public void setId(OrdonnancechirurgieId id) {
        this.id = id;
    }
    public Ordonnance getOrdonnance() {
        return this.ordonnance;
    }
    
    public void setOrdonnance(Ordonnance ordonnance) {
        this.ordonnance = ordonnance;
    }
    public Chirurgie getChirurgie() {
        return this.chirurgie;
    }
    
    public void setChirurgie(Chirurgie chirurgie) {
        this.chirurgie = chirurgie;
    }
    public BigDecimal getRang() {
        return this.rang;
    }
    
    public void setRang(BigDecimal rang) {
        this.rang = rang;
    }




}

