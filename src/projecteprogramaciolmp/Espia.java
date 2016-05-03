/////////////////////////////////////
//
//  Rol Espia --
//  El Espia, quan realitza la seva acció de rol, pot mirar la seva carta i escollir si intercanviarla
//  amb algun altre jugador (o amb la taula)(que tambe podrà veure) o simular
//  la acció com si la realitzés per tal de despistar el contrari.
//  
/////////////////////////////////////

package projecteprogramaciolmp;
import java.util.ArrayList;
/**
 *
 * @author aerop
 */
public class Espia extends Rol{
    
     // ============================================================
    // Mètodes CONSTRUCTORS
    // ============================================================
    
    public Espia() {
        
        _nomRol="Espia";
    }
    @Override
    public void accioDeRol(Partida p){
        ArrayList<Integer> aux= new ArrayList<>();
        aux= p.escollirJugadors(1);//de moment fico la opcio de nomes poder escollir jugadors,
        //mes endavant, podra escollir de la taula.
        int nCarta= p.escollirCarta(p.obtIndexJugadorExecutador());
        p.descobrirCarta(aux.get(0), nCarta);
        System.out.print("Una vegada vista la carta del jugador, vols fer intercanvi? (si dius no es fara intercanvi fals)");
        if(p.preguntarJugador(p.obtIndexJugadorExecutador())){
            //fer intercanvi
        }
        System.out.print("Intercanvi fet (o no, MUAJAJA");
    }
}
