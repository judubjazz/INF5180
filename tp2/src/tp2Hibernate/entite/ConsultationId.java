package tp2Hibernate.entite;
// Generated Apr 8, 2018 2:33:08 AM by Tp2Hibernate Tools 4.3.1


import java.math.BigDecimal;
import java.util.Date;

/**
 * ConsultationId generated by hbm2java
 */
public class ConsultationId  implements java.io.Serializable {


     private BigDecimal codedocteur;
     private BigDecimal numdos;
     private Date datec;

    public ConsultationId() {
    }

    public ConsultationId(BigDecimal codedocteur, BigDecimal numdos, Date datec) {
       this.codedocteur = codedocteur;
       this.numdos = numdos;
       this.datec = datec;
    }
   
    public BigDecimal getCodedocteur() {
        return this.codedocteur;
    }
    
    public void setCodedocteur(BigDecimal codedocteur) {
        this.codedocteur = codedocteur;
    }
    public BigDecimal getNumdos() {
        return this.numdos;
    }
    
    public void setNumdos(BigDecimal numdos) {
        this.numdos = numdos;
    }
    public Date getDatec() {
        return this.datec;
    }
    
    public void setDatec(Date datec) {
        this.datec = datec;
    }


   public boolean equals(Object other) {
         if ( (this == other ) ) return true;
		 if ( (other == null ) ) return false;
		 if ( !(other instanceof ConsultationId) ) return false;
		 ConsultationId castOther = ( ConsultationId ) other; 
         
		 return ( (this.getCodedocteur()==castOther.getCodedocteur()) || ( this.getCodedocteur()!=null && castOther.getCodedocteur()!=null && this.getCodedocteur().equals(castOther.getCodedocteur()) ) )
 && ( (this.getNumdos()==castOther.getNumdos()) || ( this.getNumdos()!=null && castOther.getNumdos()!=null && this.getNumdos().equals(castOther.getNumdos()) ) )
 && ( (this.getDatec()==castOther.getDatec()) || ( this.getDatec()!=null && castOther.getDatec()!=null && this.getDatec().equals(castOther.getDatec()) ) );
   }
   
   public int hashCode() {
         int result = 17;
         
         result = 37 * result + ( getCodedocteur() == null ? 0 : this.getCodedocteur().hashCode() );
         result = 37 * result + ( getNumdos() == null ? 0 : this.getNumdos().hashCode() );
         result = 37 * result + ( getDatec() == null ? 0 : this.getDatec().hashCode() );
         return result;
   }

    @Override
    public String toString() {
        return "ConsultationId{" +
                "codedocteur=" + codedocteur +
                ", numdos=" + numdos +
                ", datec=" + datec +
                '}';
    }
}


