/////////////////////////////////////
//
//  Enmagatzema el rol de una carta.
//  Serveix per verificar si un jugador pot fer realment un rol
//  ATRIBUTS: un rol especific, estat de si podem veure o no el rol.
//
///////////////////////////////////// 
package projecteprogramaciolmp;

/**
 *
 * @author aerop
 */
public class Carta {
    // ATRIBUTS
    // --------------------------------
    Rol _rolCarta;
    boolean _descoberta;                                                        // True quan esta descoberta, false quan és boca baix.
    // --------------------------------

    
        
////// ================================================================================================================= //////
//////                                                                                                                   //////
//////                                              CONSTRUCTORS                                                         //////
//////                                                                                                                   //////
////// ================================================================================================================= //////
    
    public Carta(Rol rolCarta){
    // Pre: rolCarta instanciat
    // Post: Carta ara té un nou rol. La carta està descoberta des de un inici
        _rolCarta= rolCarta;
        _descoberta=true;
    }
   
    
////// ================================================================================================================= //////
//////                                                                                                                   //////
//////                                             MÈTODES CONSULTORS                                                    //////
//////                                                                                                                   //////
////// ================================================================================================================= //////
    
    public Rol getRolCarta() {
    // Pre: --
    // Post Retorna el rol de la carta
    
        return _rolCarta;
    }
    
    @Override
    public boolean equals(Object o){
    // Pre: <o> castejable a Carta
    // Post: Retorna TRUE en cas que el rol sigui el mateix
        Carta c= (Carta)o;
        return compareTo(c)==0;
    }
    
    public String getNom(){
    // Pre: --
    // Post: Retorna el nom de la carta, o sigui, el nom del rol
        return _rolCarta.getRol();
    }
    
    public int compareTo(Carta in){
    // Pre: in instanciat
    // Post: Retorna si tenen el mateix Rol o NO (0 en cas de ser iguals)
        return _rolCarta.compareTo(in._rolCarta);
    }
    
    
    public void ensenya(){
        System.out.println("El rol de la carta correspon a "+_rolCarta.getRol());
    }
    
    public void mostrarCarta(){
        descobrir();
        System.out.print("Té la carta amb rol ");
        _rolCarta.mostrarRol();
        cobrir();
    }
    
////// ================================================================================================================= //////
//////                                                                                                                   //////
//////                                             MÈTODES MODIFICADORS                                                  //////
//////                                                                                                                   //////
////// ================================================================================================================= //////
    
    public void cobrir(){
    // Pre: --
    // Post: Fixa l'estat de la carta com a coberta
        _descoberta= false;
    }
    public void descobrir(){
    // Pre: --
    // Post: Fixa l'estat de la carta com a descoberta
        _descoberta= true;        
    }
    
    
} // END OF CLASS CARTA
