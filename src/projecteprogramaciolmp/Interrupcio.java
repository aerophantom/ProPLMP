/* DESCRIPCIO
 * Classe que controla les interrupcions (o protestes) de la classe <Partida>
 */
package projecteprogramaciolmp;

import java.util.ArrayList;
import java.util.Arrays;

public class Interrupcio {
////////////////////////////////ATRIBUTS\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\
    private ArrayList<Integer> _vectorInterrupcions;
    
////////////////////////////////CONSTRUCTORS\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\
    public Interrupcio() {/**
     * PRE:--
     * POST: Crea el array <_vectorInterrupcions>
     */
        _vectorInterrupcions= new ArrayList<> ();
    }
    
////////////////////////////////CONSULTORS\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\    
    public boolean hiHaInterrupcions(){/**
     * PRE: --
     * POST: retorna cert si algu s'ha queixat
     */
        return !_vectorInterrupcions.isEmpty();
    }
    
////////////////////////////////MODIFICADORS\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\
    public int getIndex() {/**
     * PRE: --
     * Post: Retorna l'index del primer jugador que ha interromput, i l'esborra 
     * del vector d'interrupcions.
     */
        int i=_vectorInterrupcions.get(0); 
        _vectorInterrupcions.remove(0);
        return i;
    }       
    public void preguntarInterrupcio(Partida p) {/**
     * PRE: <p> setejat
     * POST: Pregunta a tots els jugadors de <p> si vol interrompre. En cas que 
     * 'i' jugador protesti, es guardarà el seu index al <_vectorInterrupcio>
     * Automaticament es guarda (sense preguntar-li) el jugador que té el torn.
     */
        
        boolean volInterrompre=false;
        for (int i=0;i<p.getNumJugadors();i++) {
            
            if (i!=p.obtIndexJugadorExecutador()){
                
               System.out.println("Vols interrompre?");
               volInterrompre=p.preguntarJugador(i);
                
                if (volInterrompre) {
                    _vectorInterrupcions.add(i);
                }
             }
            else  _vectorInterrupcions.add(i);
        }
        
    }
}
