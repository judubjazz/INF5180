package entite;
// Generated Apr 8, 2018 2:33:08 AM by Tp2Hibernate Tools 4.3.1


import java.math.BigDecimal;

/**
 * OrdonnancemedicamentsId generated by hbm2java
 */
public class OrdonnancemedicamentsId  implements java.io.Serializable {


     private BigDecimal numord;
     private BigDecimal idmed;

    public OrdonnancemedicamentsId() {
    }

    public OrdonnancemedicamentsId(BigDecimal numord, BigDecimal idmed) {
       this.numord = numord;
       this.idmed = idmed;
    }
   
    public BigDecimal getNumord() {
        return this.numord;
    }
    
    public void setNumord(BigDecimal numord) {
        this.numord = numord;
    }
    public BigDecimal getIdmed() {
        return this.idmed;
    }
    
    public void setIdmed(BigDecimal idmed) {
        this.idmed = idmed;
    }


   public boolean equals(Object other) {
         if ( (this == other ) ) return true;
		 if ( (other == null ) ) return false;
		 if ( !(other instanceof OrdonnancemedicamentsId) ) return false;
		 OrdonnancemedicamentsId castOther = ( OrdonnancemedicamentsId ) other; 
         
		 return ( (this.getNumord()==castOther.getNumord()) || ( this.getNumord()!=null && castOther.getNumord()!=null && this.getNumord().equals(castOther.getNumord()) ) )
 && ( (this.getIdmed()==castOther.getIdmed()) || ( this.getIdmed()!=null && castOther.getIdmed()!=null && this.getIdmed().equals(castOther.getIdmed()) ) );
   }
   
   public int hashCode() {
         int result = 17;
         
         result = 37 * result + ( getNumord() == null ? 0 : this.getNumord().hashCode() );
         result = 37 * result + ( getIdmed() == null ? 0 : this.getIdmed().hashCode() );
         return result;
   }   


}


