/////////////////////////////////////
//
//  Rol Bruixa --
//  La Bruixa, quan realitza la seva acció de rol, canvia la quantitat de monedes que té amb les d'un
//  altre jugador a escollir.
//
/////////////////////////////////////

package projecteprogramaciolmp;
import java.util.ArrayList;
/**
 *
 * @author aerop
 */
public class Bruixa extends Rol {
    
    
   // ============================================================
    // Mètodes CONSTRUCTORS
    // ============================================================
    
    public Bruixa() {
        
        _nomRol="Bruixa";
        
    }
    public void accioDeRol(Partida p){
        ArrayList<Integer> aux= new ArrayList<>();
        aux = p.escollirJugadors(1);
        p.afegirMonedesJugador(p.obtIndexJugadorExecutador(), p.obtMonedesJugador(aux.get(0)));
        p.afegirMonedesJugador(aux.get(0), -p.obtMonedesJugador(p.obtIndexJugadorExecutador()));
    }
}
