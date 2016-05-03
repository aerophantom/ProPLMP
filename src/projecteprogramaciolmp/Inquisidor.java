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
    
     // ============================================================
    // Mètodes CONSTRUCTORS
    // ============================================================
    
    public Inquisidor() {
        
        _nomRol="Inquisidor";
    }
    @Override
    public void accioDeRol(Partida p){
        ArrayList<Integer> aux= new ArrayList<>();
        aux= p.escollirJugadors(1);
        
    }
}
