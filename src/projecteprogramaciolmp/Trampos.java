/////////////////////////////////////
//
//  Rol Trampós --
//  El Trampós, quan realitza la seva acció de rol, el jugador executant
//  necessitara menys monedes per guanyar (De 13 a 10 per defecte). 
//
/////////////////////////////////////

package projecteprogramaciolmp;

/**
 *
 * @author aerop
 */
public class Trampos extends Rol {
    
     // ============================================================
    // Mètodes CONSTRUCTORS
    // ============================================================
    
    public Trampos() {
        
        _nomRol="Trampos";
    }
    
    //S'HA DE PODER CAMBIAR EL VALOR LIMIT DE TRAMPOS A SETTINGS
    @Override
    public void accioDeRol(Partida p){
        p.fiPartidaTrampos(10);
    }
}
