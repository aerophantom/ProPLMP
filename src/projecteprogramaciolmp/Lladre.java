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
    
    @Override
    public void accioDeRol(Partida p){
        //int posicioActual= p.obtIndexJugadorExecutador();//lladre
        int nJugadors= p.getNumJugadors();
        int indexCorregit= p.getIndexExecutadorOrdre();
        
            if(indexCorregit==0){
                p.afegirMonedesJugador(p.obtIndexCorregit(1),-1);
                p.afegirMonedesJugador(p.obtIndexCorregit(nJugadors-1),-1);
            }
            else if(indexCorregit==nJugadors-1){
                p.afegirMonedesJugador(p.obtIndexCorregit(0),-1);
                p.afegirMonedesJugador(p.obtIndexCorregit(indexCorregit-1),-1);
            }
            else{
                p.afegirMonedesJugador(p.obtIndexCorregit(indexCorregit-1),-1);
                p.afegirMonedesJugador(p.obtIndexCorregit(indexCorregit+1),-1);
            }
            p.afegirMonedesJugador(p.obtIndexCorregit(indexCorregit),2);
        }
    
}
