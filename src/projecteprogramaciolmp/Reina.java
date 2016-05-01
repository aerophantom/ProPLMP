/////////////////////////////////////
//
//  Rol Reina --
//  La Reina, quan realitza la seva acció de rol, obté dos monedes del Banc Nacional i la suma a la seva
//  quantitat de monedes
//
/////////////////////////////////////

package projecteprogramaciolmp;

/**
 *
 * @author aerop
 */
public class Reina extends Rol {
    
     // ============================================================
    // Mètodes CONSTRUCTORS
    // ============================================================
    
    public Reina() {
        _nomRol="Reina";
    }
    public void accioDeRol(Partida p){
        p.treureMonedesBanc(2);
        /*
        mateix cas que el rei
        */
    }
}
