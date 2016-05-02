/////////////////////////////////////
//
//  Rol Bisbe --
//  El bisbe, quan realitza la seva acció de rol, pot robar dos monedes del jugador més ric de la partida.
//  En cas que es produeixi el cas que hi hagi dos o més jugador amb la mateixa quanitat de monedes,
//  el bisbe escullirà de quin jugador obtindrà les dos monedes.
//
/////////////////////////////////////
package projecteprogramaciolmp;
import java.util.ArrayList;

public class Bisbe extends Rol {
    
    // ============================================================
    // Mètodes CONSTRUCTORS
    // ============================================================
    
    public Bisbe() {
        
        _nomRol="Bisbe";
    
    }
    
    @Override
    public void accioDeRol(Partida p){
        ArrayList<Integer> aux= p.buscarJugadorMesRic();
        if(aux.size()>1){//hi han dos jugadors rics
            boolean escollit= false;
            while(!escollit){
                System.out.print("Vols desplumar a aquest jugador?");
                
            }
            
        }
    }
}
