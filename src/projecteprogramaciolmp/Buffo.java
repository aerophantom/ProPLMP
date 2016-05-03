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
    
    public Buffo() {
        
        _nomRol="Buffo";
    }
    @Override
    public void accioDeRol(Partida p){
        
        //escullo dos jugadors, en forma de index corresponents a _Jugadors
        ArrayList<Integer> aux= new ArrayList<>();
        aux= p.escollirJugadors(2);
        
        //escullo la carta dels dos jugadors per intercanviar
        int carta1= p.escollirCarta(aux.get(0));
        int carta2= p.escollirCarta(aux.get(1));
        
        System.out.print("Vols fer un intercanvi fals (compte, que no vegin els teus contricants si dius si o no)?");
        if(!p.preguntarJugador(p.obtIndexJugadorExecutador())){
            //metode intercanviar cartes ¿Quins parametres li passo?
            p.intercanviarCartes(aux.get(0),carta1,aux.get(1),carta2);
        }
        System.out.print("S'ha fet l'intercanvi de cartes (o no, MUAJAJA) entre els jugadors: "+carta1+" i "+carta2);
        
    }
}
