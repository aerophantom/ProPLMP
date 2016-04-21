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
public abstract class Rol {
    String _nomRol;//identificatiu i per tant unic per cada rol diferent.
    
    public Rol(){
        _nomRol="none";
    }
    public int compareTo(Rol in){
        return _nomRol.compareTo(in._nomRol);
    }
    
    @Override
    public boolean equals(Object o){
       Rol r= (Rol)o;
       return compareTo(r)==0;
    }
}
