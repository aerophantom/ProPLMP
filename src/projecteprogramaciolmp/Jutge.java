/////////////////////////////////////
//
//  Rol Jutge --
//  El Jutge, quan realitza la seva acció de rol, obté totes les monedes del Palau de Justicia
//  per sumar-les a la seva quantitat
//
/////////////////////////////////////

package projecteprogramaciolmp;

/**
 *
 * @author aerop
 */
public class Jutge extends Rol{
    
     // ============================================================
    // Mètodes CONSTRUCTORS
    // ============================================================
    
    public Jutge() {
        
        _nomRol="Jutge";
    }
    @Override
    public void accioDeRol(Partida p){
        Moneda aux= p.buidaPalauJusticia();
        p.afegirMonedesJugador(p.obtIndexJugadorExecutador(), aux.retornaQuantitat());
    }
    
}
