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
    
    
    public void preguntarInterrupcio(Partida p) {
        
        boolean volInterrompre=false;
        for (int i=0;i<p.getNumJugadors();i++) {
            
            if (i!=p.getIndexOrdre()){
                
               System.out.println("vols interrompre?");
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
        return !vectorInterrupcions.isEmpty();
    }
    
    
    
    
}
