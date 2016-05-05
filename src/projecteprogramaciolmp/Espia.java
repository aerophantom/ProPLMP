/////////////////////////////////////
//
//  Rol Espia --
//  El Espia, quan realitza la seva acció de rol, pot mirar la seva carta i escollir si intercanviarla
//  amb algun altre jugador (o amb la taula)(que tambe podrà veure) o simular
//  la acció com si la realitzés per tal de despistar el contrari.
//  
/////////////////////////////////////

package projecteprogramaciolmp;
import java.util.ArrayList;

public class Espia extends Rol{
    
     // ============================================================
    // Mètodes CONSTRUCTORS
    // ============================================================
    
    public Espia() {/**
     * PRE:--
     * POST: Seteja el identificador del rol com a "Espia"
     */
        
        _nomRol="Espia";
    }
    @Override
    public void accioDeRol(Partida p){/**
     * PRE: <p> setejat
     * POST: Selecciona un jugador i una carta d'aquest (o del _mazo) i la veu.
     * El mateix amb una de les seves cartes.
     * Despres pot decidir si intercanviar-la o no (intercanvi en fals).
     * 
     * NOTA: De moment NO esta implementat la opcio del _mazo.
     */
        //RECOLLIDA DADES
        ArrayList<Integer> aux= p.escollirJugadors(1);                                  //Guardo al array el index del jugador seleccionat pel jugador executador
             
        int nCartaExecutador= p.escollirCarta(p.obtIndexJugadorExecutador());           //Guardo en una variable local l'index de la carta que ha escollit veure l'espia
        int nCartaVictima= p.escollirCarta(aux.get(0));
        
        //TRACTAMENT DADES
        p.descobrirCarta(aux.get(0), nCartaVictima);                                    //Es veu per pantalla el rol de la carta del executador seleccionada pel executador
        p.descobrirCarta(p.obtIndexJugadorExecutador(),nCartaExecutador);               //Es veu per pantalla el rol de la carta de la victima seleccionada pel executador
        System.out.print("Una vegada vista la carta del jugador, vols fer"
                + " intercanvi? (si dius no es fara intercanvi fals)");
        if(p.preguntarJugador(p.obtIndexJugadorExecutador())){                          //Pregunto si vol fer l'intercanvi
            //fer intercanvi
            p.intercanviarCartes(p.obtIndexJugadorExecutador(), nCartaExecutador,       //Es procedeix a fer l'intercanvi de cartes entre jugadors
                    aux.get(0), nCartaVictima);
        }
        System.out.print("Intercanvi fet (o no, MUAJAJA");
    }
}
