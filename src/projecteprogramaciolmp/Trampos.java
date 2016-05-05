/////////////////////////////////////
//
//  Rol Trampós --
//  El Trampós, quan realitza la seva acció de rol, el jugador executant
//  necessitara menys monedes per guanyar (De 13 a 10 per defecte). 
//
/////////////////////////////////////

package projecteprogramaciolmp;

public class Trampos extends Rol {
    
     // ============================================================
    // Mètodes CONSTRUCTORS
    // ============================================================
    
    public Trampos() {/**
     * PRE:--
     * POST: L'identificatiu de Rol ara es "Trampos".
     */
        
        _nomRol="Trampos";
    }
    
    //S'HA DE PODER CAMBIAR EL VALOR LIMIT DE TRAMPOS A SETTINGS
    @Override
    public void accioDeRol(Partida p){/**
     * PRE: <p> setejat
     * POST: El fi de partida <p> es força a 10 i es verifica si la partida ha
     * acabat.
     */
        p.fiPartidaTrampos(10);
    }
}
