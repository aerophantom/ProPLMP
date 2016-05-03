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
    boolean _descoberta; //true quan esta descoberta, false quan és boca baix.
    
    public Carta(Rol rolCarta){
        _rolCarta= rolCarta;
        _descoberta=true;
    }
    
    public Rol getRolCarta() {
        return _rolCarta;
    }
    
    public void mostrarCarta(){
        _descoberta= true;
        _rolCarta.mostrarRol();
        _descoberta= false;
    }
    @Override
    public boolean equals(Object o){
        Carta c= (Carta)o;
        return compareTo(c)==0;
    }
    
    public String getNom(){
        return _rolCarta.getRol();
    }
    
    public int compareTo(Carta in){
        return _rolCarta.compareTo(in._rolCarta);
    }
    
    public void ensenya(){
        System.out.println("El rol de la carta correspon a "+_rolCarta.getRol());
    }
}
