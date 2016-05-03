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
    
    public Rei() {
        _nomRol="Rei";
    }
    
    @Override
    public void accioDeRol(Partida p){
        p.treureMonedesBanc(3);
        p.afegirMonedesJugador(p.obtIndexJugadorExecutador(), 3);
        
    }
}
