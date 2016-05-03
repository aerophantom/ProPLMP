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
    
   // @Override
    public void accioDeRol(Partida p){
    /**
     * PRE: --
     * POST: 
     */
        ArrayList<Integer> aux= p.buscarJugadorMesRic();
        if(aux.size()>1){//hi ha dos jugadors rics
            boolean escollit= false;
            int i= 0;
            
            while(i<aux.size() && !escollit){
                System.out.print("Vols desplumar a aquest jugador?");
                p.mostrarInfoJugador(aux.get(i));
                escollit= p.preguntarJugadorActual();
                if (!escollit)
                    i++;
            }
            if(i==aux.size())
                i--;
            p.afegirMonedesJugador(aux.get(i), -2);//restar monedes al jugador escollit
            //afegir monedes al jugador executador
            //DE MOMENT SI NO S'ECULL A CAP JUGADOR, ES DESPLUMARA AL ULTIM, O FER QUE EL WHILE NO PLEGUI FINS UNA ELECCIO.
            
        }
        else{
            p.afegirMonedesJugador(aux.get(0), -2);
        }
        p.afegirMonedesJugador(p.obtIndexJugadorExecutador(), 2);
    }
}
