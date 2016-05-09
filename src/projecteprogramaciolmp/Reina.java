/////////////////////////////////////
//
//  Rol Reina --
//  La Reina, quan realitza la seva acció de rol, obté dos monedes del Banc Nacional i la suma a la seva
//  quantitat de monedes
//
/////////////////////////////////////

package projecteprogramaciolmp;

public class Reina extends Rol {
    
     // ============================================================
    // Mètodes CONSTRUCTORS
    // ============================================================
    
    public Reina() {
    // Pre: --
    // Post: L'identificador del rol ara és Reina
        _nomRol="Reina";
    }
    
    @Override
    public void accioDeRol(Partida p){
    // Pre: p setejat
    // Post: Resta 2 monedes al banc Nacional i s'afegeix a la seva quantitat existent de monedes
        p.treureMonedesBanc(2);
        p.afegirMonedesJugador(p.getIndexJugadorExecutador(0), 2);
    }
    
} // END OF CLASS REINA
