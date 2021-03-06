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
    
////// ================================================================================================================= //////
//////                                                                                                                   //////
//////                                             CONSTRUCTORS                                                          //////
//////                                                                                                                   //////
////// ================================================================================================================= //////
    
    public Espia() {
    // Pre: --
    // Post: Seteja el identificador del rol com a Espia        
        _nomRol="Espia";
    }
    
////// ================================================================================================================= //////
//////                                                                                                                   //////
//////                                             MÈTODES MODIFICADORS                                                  //////
//////                                                                                                                   //////
////// ================================================================================================================= //////
    
    @Override
    public void accioDeRol(Partida p){
    // Pre: p setejat
    // Post: Selecciona un jugador i una carta d'aquest (o del mazo) i la veu
    // El mateix amb una de les seves cartes
    // Després pot decidir si intercanviar-la o no (intercanvi fals, no realitzat)
    /*
     * NOTA: De moment NO esta implementat la opcio del _mazo.
    */
        //RECOLLIDA DADES
        ArrayList<Integer> aux= p.escollirJugadors(1);                                  // Guardo al array el index del jugador seleccionat pel jugador executador
             
        int nCartaExecutador= p.escollirCartaVictima(p.getIndexJugadorExecutador(0));           // Guardo en una variable local l'index de la carta que ha escollit veure l'espia
        int nCartaVictima= p.escollirCartaVictima(aux.get(0));
        
        //TRACTAMENT DADES
        p.descobrirCarta(aux.get(0), nCartaVictima);                                    // Es veu per pantalla el rol de la carta del executador seleccionada pel executador
        p.descobrirCarta(p.getIndexJugadorExecutador(0),nCartaExecutador);               // Es veu per pantalla el rol de la carta de la victima seleccionada pel executador
        System.out.print("Una vegada vista la carta del jugador, vols fer"
                + " intercanvi? (si dius no es fara intercanvi fals)");
        if(p.preguntarJugador(p.getIndexJugadorExecutador(0))){                          // Pregunto si vol fer l'intercanvi
            //fer intercanvi
            p.intercanviarCartes(p.getIndexJugadorExecutador(0), nCartaExecutador,       // Es procedeix a fer l'intercanvi de cartes entre jugadors
                    aux.get(0), nCartaVictima);
        }
        System.out.println("Intercanvi fet (o no) MUAJAJA");                            // XD
    }
}
