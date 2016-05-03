/////////////////////////////////////
//
//  Rol Lladre --
//  El Lladre, quan realitza la seva acció de rol, obté una moneda del jugador que té 
//  a l'esquerra i una altre del jugador que té a la dreta
//
/////////////////////////////////////

package projecteprogramaciolmp;

/**
 *
 * @author aerop
 */
public class Lladre extends Rol {
    
     // ============================================================
    // Mètodes CONSTRUCTORS
    // ============================================================
    
    public Lladre() {
        
        _nomRol="Lladre";
    }
    public void accioDeRol(Partida p){
        int posicioActual= p.obtIndexJugadorExecutador();//lladre
        int nJugadors= p.getNumJugadors();
        
        if(nJugadors==2){
            
        }
        else{
            
        }
    }
    
}
