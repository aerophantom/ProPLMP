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
     * Despres pot decidir si intercanviar-la o no (intercanvi en fals).
     * 
     * NOTA: De moment NO esta implementat la opcio del _mazo.
     */
        //RECOLLIDA DADES
        ArrayList<Integer> aux= new ArrayList<>();                                      //Declaro array auxiliar on guardare l'index del jugador seleccionat
        aux= p.escollirJugadors(1);                                                     //Guardo al array el index del jugador seleccionat pel jugador executador
        //la siguiente linea mepa que esta mal ¿pq el parametro es el que es y no el del jugador seleccionado?
        int nCarta= p.escollirCarta(p.obtIndexJugadorExecutador());                     //Guardo en una variable local l'index de la carta 
        p.descobrirCarta(aux.get(0), nCarta);
        System.out.println("Una vegada vista la carta del jugador, vols fer intercanvi? (si dius no, es farà intercanvi fals)");
        if(p.preguntarJugador(p.obtIndexJugadorExecutador())){
            //fer intercanvi
            p.intercanviarCartes(p.obtIndexJugadorExecutador(), 0, aux.get(0), nCarta);//<--- nCarta hauria de ser 0 SEMPRE ja que nomes hi ha una carta per jugador
        }
        System.out.println("Intercanvi fet (o no) MUAJAJA");
    }
}
