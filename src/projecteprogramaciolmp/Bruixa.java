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
    
    
   // ============================================================
    // Mètodes CONSTRUCTORS
    // ============================================================
    
    public Bruixa() {/**
     * PRE: --
     * POST: Estableix com a identificador del rol "Bruixa"
     */
        _nomRol="Bruixa";
        
    }
    
    @Override
    public void accioDeRol(Partida p){/**
     * PRE: <p> inicialitzat.
     * POST: Intercanvia la quantitat de monedes del jugador executador amb un
     * altre seleccionat.
     */
        //RECOLLIDA DADES
        ArrayList<Integer> aux= new ArrayList<>();                                                                      //Crear array on  guardarem l'index del jugador seleccionat
        aux = p.escollirJugadors(1);                                                                                    //Guardem al array el jugador seleccionat
        int monedesJugExe= p.obtMonedesJugador(p.obtIndexJugadorExecutador());                                          //Guardem en una variable local les monedes que te el jugador executador
        int monedesJugVictima= p.obtMonedesJugador(aux.get(0));                                                         //Guardem en una variable local les monedes que te el jugador victima
       
        //TRACTAMENT DADES
        p.afegirMonedesJugador(p.obtIndexJugadorExecutador(), -p.obtMonedesJugador(p.obtIndexJugadorExecutador()));     //Setejo les monedes del jugador executador a 0
        p.afegirMonedesJugador(aux.get(0), -p.obtMonedesJugador(aux.get(0)));                                           //Setejo les monedes del jugador victima a 0
        
        p.afegirMonedesJugador(p.obtIndexJugadorExecutador(), monedesJugVictima);                                       //Sumo les monedes del jugador victima al jugador executador
        p.afegirMonedesJugador(aux.get(0), monedesJugExe);                                                              //Sumo les monedes del jugador executador al jugador victima 
    }
}
