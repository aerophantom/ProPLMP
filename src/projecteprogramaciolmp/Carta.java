/////////////////////////////////////
//
//  Enmagatzema la informació de una carta.
//  Serveix per verificar si un jugador pot fer realment un rol
//  ATRIBUTS: nomCarta (String) que ha de coincidir amb un dels rols que hi ha al 
//  joc.
//
/////////////////////////////////////
package projecteprogramaciolmp;

/**
 *
 * @author aerop
 */
public class Carta {
    String nomCarta;
    
    public Carta(){
        nomCarta="defecte";
    }
    public Carta(String nomRol){
        nomCarta= nomRol;
    }
}
