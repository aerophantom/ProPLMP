/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projecteprogramaciolmp;

import java.util.ArrayList;
import java.util.Arrays;

/**
 *
 * @author TOSHIBA
 */
public class Interrupcio {
    private ArrayList<Integer> _vectorInterrupcions;
    
    public Interrupcio() {
        _vectorInterrupcions= new ArrayList<> ();
    }
    
    public int getIndex() {
        // Pre: --
        // Post: Retorna l'index del primer jugador que ha interromput, i l'esborra del vector d'interrupcions.
        int i=_vectorInterrupcions.get(0); 
        _vectorInterrupcions.remove(0);
        return i;
    }
            
            
    public void preguntarInterrupcio(Partida p) {
        
        boolean volInterrompre=false;
        for (int i=0;i<p.getNumJugadors();i++) {
            
            if (i!=p.getIndexOrdre()){
                
               System.out.println("Vols interrompre?");
               volInterrompre=p.preguntarJugador(i);
                
                if (volInterrompre) {
                    _vectorInterrupcions.add(i);
                }
             }
        }
        
    }
    public boolean hiHaInterrupcions(){
    /**
     * PRE: --
     * POST: retorna cert si algu s'ha queixat
     */
        return (!_vectorInterrupcions.isEmpty());
    }

    
    
}
