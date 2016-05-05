/////////////////////////////////////
//
//  Rol Lladre --
//  El Lladre, quan realitza la seva acció de rol, obté una moneda del jugador que té 
//  a l'esquerra i una altre del jugador que té a la dreta
//
/////////////////////////////////////

package projecteprogramaciolmp;

public class Lladre extends Rol {
    
     // ============================================================
    // Mètodes CONSTRUCTORS
    // ============================================================
    
    public Lladre() {/**
     * PRE:--
     * POST: L'identificador del Rol ara es "Lladre". 
     */
        _nomRol="Lladre";
    }
    
    @Override
    public void accioDeRol(Partida p){/**
     * PRE: <p> setejat.
     * POST: El jugador executador afegeix al seu compte corrent dues monedes
     * extretes dels jugadors de la seva esquerra i seva dreta.
     * 
     * NOTA: No esta del testejat del tot i segurament no funciona.
     */
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
