/////////////////////////////////////
//
//  Rol Inquisidor --
//  El Inquisidor, quan realitza la seva acció de rol, obliga a un jugador a escollir a dir un rol dels que té.
//  Si el jugador escollit falla, aquest dóna 4 monedes al jugador Inquisidor. En cas contrari no passa res.
//  (nCartesPerJugador=1)
/////////////////////////////////////

package projecteprogramaciolmp;
import java.util.ArrayList;
/**
 *
 * @author aerop
 */
public class Inquisidor extends Rol {
    
     // ============================================================
    // Mètodes CONSTRUCTORS
    // ============================================================
    
    public Inquisidor() {
        
        _nomRol="Inquisidor";
    }
    @Override
    public void accioDeRol(Partida p){
        ArrayList<Integer> aux= new ArrayList<>();
        aux= p.escollirJugadors(1);
        System.out.print("Jugador "+ aux.get(0)+" t'han obligat a escollir un rol dels que tens. Si menteixes hauras de pagar 4 monedes al jugador executador");
        p.setRolJugador(p.escollirRol(), aux.get(0)); //actualitza el rol de la victima
        p.escollirCarta(aux.get(0));
        if(!p.checkPlayerRolCards(aux.get(0))){//SI no te el rol escollit a la carta seleccionada per ell
            System.out.println("Mentideeeeer, hauras de sofrir i pagar 4 monedes al cabron del inquisidor!");
            p.afegirMonedesJugador(aux.get(0), -4);
            p.afegirMonedesJugador(p.obtIndexJugadorExecutador(), 4);
        }
        else{
            System.out.println("Ufffff, has dit la veritat, aquest cop t'has lliurat d'una bona");
        }
    }
}
