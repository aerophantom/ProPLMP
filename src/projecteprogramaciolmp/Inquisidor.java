/////////////////////////////////////
//
//  Rol Inquisidor --
//  El Inquisidor, quan realitza la seva acció de rol, obliga a un jugador a escollir a dir un rol dels que té.
//  Si el jugador escollit falla, aquest dóna 4 monedes al jugador Inquisidor. En cas contrari no passa res.
//  (nCartesPerJugador=1)
/////////////////////////////////////

package projecteprogramaciolmp;
import java.util.ArrayList;
/**
 *
 * @author aerop
 */
public class Inquisidor extends Rol {
    
////// ================================================================================================================= //////
//////                                                                                                                   //////
//////                                             CONSTRUCTORS                                                          //////
//////                                                                                                                   //////
////// ================================================================================================================= //////
    public Inquisidor() {
        
        _nomRol="Inquisidor";
    }
    
////// ================================================================================================================= //////
//////                                                                                                                   //////
//////                                             MÈTODES MODIFICADORS                                                  //////
//////                                                                                                                   //////
////// ================================================================================================================= //////
    
    @Override
    public void accioDeRol(Partida p){
    // Pre: p setejat
    // Post: El jugador executador guanyarà 4 monedes si el jugador que ha seleccionat
    // encerta amb el rol d'una de les seves cartes
    
        //RECOLLIDA DADES
        ArrayList<Integer> aux= new ArrayList<>();                              // Array on es guardara l'index del jugador victima
        aux= p.escollirJugadors(1);                                             // S'escull el jugador victima
        System.out.println("Jugador "+ aux.get(0)+" t'han obligat a escollir un "
                + "rol dels que tens. Si menteixes hauras de pagar 4 monedes al "
                + "jugador executador");
        
        //TRACTAMENT DADES
        p.setRolJugador(p.escollirRol(), aux.get(0));                           // S'escull un Rol i es guarda com a Rol actual al jugador victima
        p.escollirCartaVictima(aux.get(0));                                            // Jugador victima escull amb quina carta vol jugar (en aquest cas comparar)
        if(!p.checkPlayerRolCards(aux.get(0))){                                 // SI no te el rol escollit a la carta seleccionada per ell
            System.out.println("Mentideeeeer, hauras de sofrir i pagar 4 "
                    + "monedes al cabron del inquisidor!");
            p.afegirMonedesJugador(aux.get(0), -4);                             // Resto 4 monedes al jugador victima
            p.afegirMonedesJugador(p.obtIndexJugadorExecutador(), 4);           // Afegeixo 4 monedes al jugador executador
        }
        else{
            System.out.println("Ufffff, has dit la veritat, aquest cop t'has"   
                    + " lliurat d'una bona");  
        }
    }
}
