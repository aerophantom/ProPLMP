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
    
    public Reina() {/**
     * PRE:--
     * POST: L'identificador de Rol ara es "Reina".
     */
        _nomRol="Reina";
    }
    
    @Override
    public void accioDeRol(Partida p){/**
     * PRE: <p> setejat.
     * POST: Resta dos monedes al banc de <p> i s'afegeix la mateixa quantitat al
     * compte corrent del jugador executador.
     */
        p.treureMonedesBanc(2);
        p.afegirMonedesJugador(p.obtIndexJugadorExecutador(), 2);
    }
}
