/////////////////////////////////////
//
//  Rol Jutge --
//  El Jutge, quan realitza la seva acció de rol, obté totes les monedes del Palau de Justicia
//  per sumar-les a la seva quantitat
//
/////////////////////////////////////

package projecteprogramaciolmp;


public class Jutge extends Rol{
    
     // ============================================================
    // Mètodes CONSTRUCTORS
    // ============================================================
    
    public Jutge() {/**
     * PRE:--
     * POST: L'identificador del Rol ara es "Jutge".
     */
        _nomRol="Jutge";
    }
    
    @Override
    public void accioDeRol(Partida p){/**
     * PRE: <p> setejat.
     * POST: L'executador ha tret les monedes del palau de justicia per afegir-les
     * al seu compte corrent.
     */
        Moneda aux= p.buidaPalauJusticia();
        p.afegirMonedesJugador(p.obtIndexJugadorExecutador(), aux.retornaQuantitat());
    }
    
}
