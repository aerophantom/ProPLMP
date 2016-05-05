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
//////////////////////////////////ATRIBUTS\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\
    Rol _rolCarta;
    boolean _descoberta;                                                        //true quan esta descoberta, false quan és boca baix.
    
//////////////////////////////////CONSTRUCTORS\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\
    public Carta(Rol rolCarta){/**
     * PRE: <rolCarta> instanciat.
     * POST: Carta ara te un nou rol. La carta esta descoberta.
     */
        _rolCarta= rolCarta;
        _descoberta=true;
    }
   
//////////////////////////////////CONSULTORS\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\ 
    public Rol getRolCarta() {/**
     * PRE:--
     * POST: Retorna el rol de la carta.
     */
        return _rolCarta;
    }
    
    @Override
    public boolean equals(Object o){/**
     * PRE: <o> castejable a Carta
     * POST: Retorna cert en cas que el rol sigui el mateix.
     */
        Carta c= (Carta)o;
        return compareTo(c)==0;
    }
    
    public String getNom(){/**
     * PRE:--
     * POST: Retorna el nom de la carta, es a dir, el nom del rol.
     */
        return _rolCarta.getRol();
    }
    
    public int compareTo(Carta in){/**
     * PRE: <in> instanciat
     * POST: Retorna nomes si tenen el mateix Rol o no (0 en cas de ser iguals).
     */
        return _rolCarta.compareTo(in._rolCarta);
    }
    
    
    //////////////////////////Metodes quasi redundants//////////////////////////
    public void ensenya(){
        System.out.println("El rol de la carta correspon a "+_rolCarta.getRol());
    }
    public void mostrarCarta(){
        descobrir();
        _rolCarta.mostrarRol();
        cobrir();
    }
    ////////////////////////////////////////////////////////////////////////////
//////////////////////////////////MODIFICADORS\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\
    public void cobrir(){/**
     * PRE:--
     * POST: fixa l'estat de la carta com a coberta
     */
        _descoberta= false;
    }
    public void descobrir(){/**
     * PRE:--
     * POST: fixa l'estat de la carta com a descoberta
     */
        _descoberta= true;        
    }
}
