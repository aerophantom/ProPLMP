/////////////////////////////////////
//
//  Rol Camperol --
//  El Camperol, quan realitza la seva acció de rol (manifestació), obté una moneda del Banc Nacional.
//  Si es produeix el cas que l'altre camperol també es manifesta, els dos camperols obtenen dos monedes
//  cada un del Banc Nacional
//
/////////////////////////////////////

package projecteprogramaciolmp;

public class Camperol extends Rol {
    
     // ============================================================
    // Mètodes CONSTRUCTORS
    // ============================================================
    
    public Camperol() {
    // Pre: --
    // Post: Seteja el identificador del rol com a Camperol
        _nomRol="Camperol";
    }
    
    @Override
    public void accioDeRol(Partida p){
    // Pre:
    // Post:
        //p.afegirMonedesJugador(p.obtIndexJugadorExecutador(), );
    }
}
