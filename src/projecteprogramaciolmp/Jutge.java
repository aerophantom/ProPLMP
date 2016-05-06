/////////////////////////////////////
//
//  Rol Jutge --
//  El Jutge, quan realitza la seva acció de rol, obté totes les monedes del Palau de Justicia
//  per sumar-les a la seva quantitat
//
/////////////////////////////////////

package projecteprogramaciolmp;


public class Jutge extends Rol{

    // CONSTRUCTORS
    
    public Jutge() {
    // Pre: --
    // Post: L'identificador del rol ara es Jutge
        _nomRol="Jutge";
    }
    
    // MODIFICADORS
    @Override
    public void accioDeRol(Partida p){
    // Pre: p setejat
    // Post: L'executador ha tret les monedes del palau de justicia per afegir-les a la seva quantitat
        Moneda aux= p.buidarPalauJusticia();
        p.afegirMonedesJugador(p.getIndexJugadorExecutador(), aux.retornaQuantitat());
    }
    
} // END OF CLASS JUTGE
