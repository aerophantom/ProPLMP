/////////////////////////////////////
//
//  Rol Bruixa --
//  La Bruixa, quan realitza la seva acció de rol, canvia la quantitat de monedes que té amb les d'un
//  altre jugador a escollir.
//
/////////////////////////////////////

package projecteprogramaciolmp;
import java.util.ArrayList;

public class Bruixa extends Rol {
    
    
////// ================================================================================================================= //////
//////                                                                                                                   //////
//////                                             CONSULTORS                                                            //////
//////                                                                                                                   //////
////// ================================================================================================================= //////
    
    public Bruixa() {
    // Pre: --
    // Post: Estableix com a identificador de rol BRUIXA
        _nomRol="Bruixa";
    }
    
////// ================================================================================================================= //////
//////                                                                                                                   //////
//////                                             MÈTODES MODIFICADORS                                                  //////
//////                                                                                                                   //////
////// ================================================================================================================= //////
    
    @Override
    public void accioDeRol(Partida p){
    // Pre: p inicialitzat
    // Post: Intercanvia la quantitat de monedes del jugador executador
    // amb un altre seleccionat
    
        //RECOLLIDA DADES
        ArrayList<Integer> aux = p.escollirJugadors(1);                                                                 // Guardem al array el jugador seleccionat
        int monedesJugExe= p.getMonedesJugador(p.getIndexJugadorExecutador());                                          // Guardem en una variable local les monedes que te el jugador executador
        int monedesJugVictima= p.getMonedesJugador(aux.get(0));                                                         // Guardem en una variable local les monedes que te el jugador victima
       
        //TRACTAMENT DADES
        p.afegirMonedesJugador(p.getIndexJugadorExecutador(), -p.getMonedesJugador(p.getIndexJugadorExecutador()));     // Setejo les monedes del jugador executador a 0
        p.afegirMonedesJugador(aux.get(0), -p.getMonedesJugador(aux.get(0)));                                           // Setejo les monedes del jugador victima a 0
        
        p.afegirMonedesJugador(p.getIndexJugadorExecutador(), monedesJugVictima);                                       // Sumo les monedes del jugador victima al jugador executador
        p.afegirMonedesJugador(aux.get(0), monedesJugExe);                                                              // Sumo les monedes del jugador executador al jugador victima 
    }
}
