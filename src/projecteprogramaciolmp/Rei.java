/////////////////////////////////////
//
//  Rol Rei --
//  El rei, quan realitza la seva acció de rol, obté 3 monedes del Banc Nacional i la suma a la seva
//  quantitat de monedes
//
/////////////////////////////////////

package projecteprogramaciolmp;

public class Rei extends Rol{
    
     // ============================================================
    // Mètodes CONSTRUCTORS
    // ============================================================
    
    public Rei() {/**
     * PRE:--
     * POST: L'identificador del Rol ara es "Rei".
     */
        _nomRol="Rei";
    }
    
    @Override
    public void accioDeRol(Partida p){/**
     * PRE: <p> setejat.
     * POST: Es resten 3 monedes al banc de <p> i s'afegeix la mateixa quantitat
     * al compte corrent del jugador executador.
     */
        p.treureMonedesBanc(3);
        p.afegirMonedesJugador(p.obtIndexJugadorExecutador(), 3);
        
    }
}
