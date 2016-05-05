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
    
    public Bisbe() {/**
     * PRE:--
     * POST: l'identificador del rol ara es "Bisbe"
     */        
        _nomRol="Bisbe";
    
    }
    
   @Override
    public void accioDeRol(Partida p){/**
     * PRE: <p> setejat
     * POST: Es roba dos monedes al jugador mes ric i s'afegeixen al executador.
     * En cas d'haver-n'hi dos de rics, l'executador selecciona la victima.
     */ 
        //RECOLLIDA DADES
        ArrayList<Integer> aux= p.buscarJugadorMesRic();                        //Es guarda al array els indexos dels jugadors rics
        
        //TRACTAMENT DADES
        if(aux.size()>1){                                                       //Si hi ha més d'un jugador ric
            boolean escollit= false;                
            int i= 0;
            
            while(i<aux.size() && !escollit){                                   //Recorre els jugadors rics
                System.out.print("Vols desplumar a aquest jugador? - ");        //Es pregunta per cada iteracio
                p.mostrarInfoJugador(aux.get(i));                               //si es vol escullir aquest jugador
                escollit= p.preguntarJugadorActual();                           //com a victima
                if (!escollit)
                    i++;
                if(i==aux.size() && !escollit)
                    i= 0;
            }
            
            p.afegirMonedesJugador(aux.get(i), -2);                             //Es resten les 2 monedes al jugador victima seleccionat pel executador              
        }
        else{
            p.afegirMonedesJugador(aux.get(0), -2);                             //Es resten les 2 monedes al jugador victima seleccionat per partida
        }
        p.afegirMonedesJugador(p.obtIndexJugadorExecutador(), 2);               //S'afegeixen dos monedes al executador
    }
}
