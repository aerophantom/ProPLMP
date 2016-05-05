/////////////////////////////////////
//
//  ATRIBUT: nom (string)
//  
//  
//
/////////////////////////////////////
package projecteprogramaciolmp;

public abstract class Rol{
    String _nomRol;//identificatiu i per tant unic per cada rol diferent.
    
    public Rol(){/**
     * PRE:--
     * POST: L'identificatiu del rol es un generic: "none".
     */
        _nomRol="none";
    }
    
    public Rol(String nom){/**
     * PRE:--
     * POST: L'identificatiu del rol es un generic: <nom>.
     */
        _nomRol = nom;
    }
    
    public int compareTo(Rol in){
        return _nomRol.compareTo(in._nomRol);
    }
    
    //Metode per consola
    public void mostrarRol(){
        System.out.print(_nomRol);
    }
    
    
    public void accioDeRol(Partida p){
       /**
        * res
        */ 
    }
    
    @Override
    public boolean equals(Object o){
       Rol r= (Rol)o;
       return compareTo(r) == 0;
    }
    
    public String getRol(){
        return _nomRol;
    }
}
