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
    
    public Trampos() {
    // Pre: --
    // Post: L'identificador del rol ara és TRAMPOS        
        _nomRol="Trampos";
    }
    
    //S'HA DE PODER CAMBIAR EL VALOR LIMIT DE TRAMPOS A SETTINGS
    @Override
    public void accioDeRol(Partida p){
    // Pre: p setejat
    // Post: EL fi de partida p es força a 10 i es verifica si la partida ha acabat
        p.forzarPossibleFinal(10);
    }
}
