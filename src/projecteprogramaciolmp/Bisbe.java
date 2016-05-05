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
    
////// ================================================================================================================= //////
//////                                                                                                                   //////
//////                                             CONSULTORS                                                            //////
//////                                                                                                                   //////
////// ================================================================================================================= //////
    
    public Bisbe() {
    // Pre: --
    // Post: L'identificador del rol es Bisbe     
        _nomRol="Bisbe";
    }
    
////// ================================================================================================================= //////
//////                                                                                                                   //////
//////                                             MÈTODES MODIFICADORS                                                  //////
//////                                                                                                                   //////
////// ================================================================================================================= //////
    
   @Override
    public void accioDeRol(Partida p){
    // Pre: p setejat
    // Post: Es roben dos monedes al jugador més ric i s'afegeixen al executador de l'accio de rol
    // En cas d'haver-hi dos d'igual de rics, l'executador en seleccionarà un

        //RECOLLIDA DADES
        ArrayList<Integer> aux= p.buscarJugadorMesRic();                        // Es guarda al array els indexos dels jugadors rics
        
        //TRACTAMENT DADES
        if(aux.size()>1){                                                       // Si hi ha més d'un jugador ric
            boolean escollit= false;                
            int i= 0;
            
            while(i<aux.size() && !escollit){                                   // Recorre els jugadors rics
                System.out.print("Vols desplumar a aquest jugador? - ");        // Es pregunta per cada iteracio
                p.mostrarInfoJugador(aux.get(i));                               // Si es vol escullir aquest jugador
                escollit= p.preguntarJugadorActual();                           // Com a victima
                if (!escollit)
                    i++;
                if(i==aux.size() && !escollit)
                    i= 0;
            }
            
            p.afegirMonedesJugador(aux.get(i), -2);                             // Es resten les 2 monedes al jugador victima seleccionat pel executador              
        }
        else{
            p.afegirMonedesJugador(aux.get(0), -2);                             // Es resten les 2 monedes al jugador victima seleccionat per partida
        }
        p.afegirMonedesJugador(p.obtIndexJugadorExecutador(), 2);               // S'afegeixen dos monedes al executador
    }
}
