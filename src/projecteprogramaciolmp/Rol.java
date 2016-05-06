/////////////////////////////////////
//
//  ATRIBUT: nom (string)
//  
//  
//
/////////////////////////////////////
package projecteprogramaciolmp;

public abstract class Rol{
    
    String _nomRol;                                                         // Identificatiu i per tant unic per cada rol diferent.
    
    
////// ================================================================================================================= //////
//////                                                                                                                   //////
//////                                             CONSULTORS                                                            //////
//////                                                                                                                   //////
////// ================================================================================================================= //////
    
    public Rol(){
    // Pre: --
    // Post: L'identificatiu del rol es un generic none
        _nomRol="none";
    }
    

    public Rol(String nom){
    // Pre: --
    // Post: L'identificatiu del rol es un generic nom
        _nomRol = nom;
    }
    
////// ================================================================================================================= //////
//////                                                                                                                   //////
//////                                             MÈTODES CONSULTORS                                                    //////
//////                                                                                                                   //////
////// ================================================================================================================= //////
    
    public int compareTo(Rol in){
    // Pre: in instanciat
    // Post: Retorna 0 si son iguals
        return _nomRol.compareTo(in._nomRol);
    }
    
    public void mostrarRol(){
    // Pre: --
    // Post: Mostra el nom del rol
        System.out.println(_nomRol);
    }
    
    public String getRol(){
    // Pre: --
    // Post: Retorna el nom del rol
        return _nomRol;
    }
    
        
    @Override
    public boolean equals(Object o){
    // Pre: o instanciat
    // Post: Retorna TRUE si son iguals
       Rol r= (Rol)o;
       return compareTo(r) == 0;
    }
    

    
////// ================================================================================================================= //////
//////                                                                                                                   //////
//////                                             MÈTODES MODIFICADORS                                                  //////
//////                                                                                                                   //////
////// ================================================================================================================= //////
    
    public void accioDeRol(Partida p){
       /**
        * RES
      **/ 
    }
    

}
