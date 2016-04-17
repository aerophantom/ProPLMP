/////////////////////////////////////
//
//  Enmagatzema el rol de una carta.
//  Serveix per verificar si un jugador pot fer realment un rol
//  ATRIBUTS: un rol especific.
//
/////////////////////////////////////
package projecteprogramaciolmp;

/**
 *
 * @author aerop
 */
public class Carta {
    Rol _rolCarta;
    
    public Carta(Rol rolCarta){
        _rolCarta= rolCarta;
    }
    
    @Override
    public boolean equals(Object o){
        Carta c= (Carta)o;
        return compareTo(c)==0;
    }
    
    public int compareTo(Carta in){
        return _rolCarta.compareTo(in._rolCarta);
    }
}
