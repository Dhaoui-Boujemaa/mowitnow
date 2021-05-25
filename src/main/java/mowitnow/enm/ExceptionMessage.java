package mowitnow.enm;

public enum ExceptionMessage {

	 ERREUR_DONNEES_INCORRECTES("données incorrectes"),
	 ERREUR_FICHIER_INTROUVABE("fichier inexistant"),
	 ORIENTATION_INCORRECTE("orientation incorrecte"),
	 CONSIGNE_INCORRECTE("consigne incorrecte"),
	 POSITION_INCORRECTE("position incorrecte");
	 
     private String message ;  
     
     private ExceptionMessage(String message) {  
         this.message = message ;  
    }  
      
     public String getMessage() {  
         return  this.message ;  
    }
}
