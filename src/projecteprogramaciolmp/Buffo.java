/////////////////////////////////////
//
//  Rol Buffó --
//  El Buffó, quan realitza la seva acció de rol, pot intercanviar dos cartes entre dos jugador a escollir 
//  o simular l'acció per tal de despistar-los.
//
/////////////////////////////////////

package projecteprogramaciolmp;
import java.util.ArrayList;
/**
 *
 * @author aerop
 */
public class Buffo extends Rol {
    
     // ============================================================
    // Mètodes CONSTRUCTORS
    // ============================================================
    
    public Buffo() {/**
     * PRE:--
     * POST: L'identificador de rol ara és "Buffo"
     */        
        _nomRol="Buffo";
    }
    
    @Override
    public void accioDeRol(Partida p){/**
     * PRE: <p> setejat.
     * POST: Es fal el intercandi (o es simula que ho fa) de dues cartes entre dos jugadors seleccionats
     * pel executador. En cap moment es saben quin rol son les cartes intercanviades.
     */
        //RECOLLIDA DADES
        ArrayList<Integer> aux= p.escollirJugadors(2);                          //escullo dos jugadors, en forma de index corresponents a _Jugadors
        
        int carta1= p.escollirCarta(aux.get(0));                                //escullo la carta dels dos jugadors per intercanviar
        int carta2= p.escollirCarta(aux.get(1));
        
        //TRACTAMENT DADES
        System.out.print("Vols fer un intercanvi fals (compte, que no vegin els "
                + "teus contricants si dius si o no)?");
        if(!p.preguntarJugador(p.obtIndexJugadorExecutador())){                 //Si l'executador vol fer realment l'intercanvi
            p.intercanviarCartes(aux.get(0),carta1,aux.get(1),carta2);          //Es procedeix a fer l'intercanvi
        }
        System.out.print("S'ha fet l'intercanvi de cartes (o no, MUAJAJA) entre "
                + "els jugadors: "+carta1+" i "+carta2);
        
    }
}
