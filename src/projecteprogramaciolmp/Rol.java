/////////////////////////////////////
//
//  ATRIBUT: nom (string)
//  
//  
//
/////////////////////////////////////
package projecteprogramaciolmp;

/**
 *
 * @author aerop
 */
public abstract class Rol extends Accio{
    String _nomRol;//identificatiu i per tant unic per cada rol diferent.
    
    public Rol(){
        _nomRol="none";
    }
    public int compareTo(Rol in){
        return _nomRol.compareTo(in._nomRol);
    }
    
    //Metode per consola
    public void mostrarRol(){
        System.out.print(_nomRol);
    }
    @Override
    public void accioDeRol(Partida p){
        
    }
    
    @Override
    public boolean equals(Object o){
       Rol r= (Rol)o;
       return compareTo(r)==0;
    }
    
    
}
