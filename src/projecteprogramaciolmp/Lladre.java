/////////////////////////////////////
//
//  Rol Lladre --
//  El Lladre, quan realitza la seva acció de rol, obté una moneda del jugador que té 
//  a l'esquerra i una altre del jugador que té a la dreta
//
/////////////////////////////////////

package projecteprogramaciolmp;

public class Lladre extends Rol {
    
////// ================================================================================================================= //////
//////                                                                                                                   //////
//////                                             CONSTRUCTORS                                                          //////
//////                                                                                                                   //////
////// ================================================================================================================= //////
    
    public Lladre() {
    // Pre: --
    // Post: L'identificador del Rol ara és "lladre"
        _nomRol="Lladre";
    }
    
////// ================================================================================================================= //////
//////                                                                                                                   //////
//////                                             MÈTODES MODIFICADORS                                                  //////
//////                                                                                                                   //////
////// ================================================================================================================= //////
    
    @Override
    public void accioDeRol(Partida p){
    // Pre: p setejat
    // Post: El jugador executador afegeix al seu compte de monedes dues monedes extretes
    // dels jugadors de la seva esquerra i dreta
    // NOTA: No esta del testejat del tot i segurament no funciona.
    
        //int posicioActual= p.getIndexJugadorExecutador();//lladre
        int nJugadors= p.getNumJugadors();
        int indexCorregit= p.getIndexExecutadorOrdre();
        
        if(indexCorregit==0){                                                       // Si es troba en la posicio 0 del vector d'ordre dels jugadors
            p.afegirMonedesJugador(p.getIndexCorregit(1),-1);                       // Extreu del seguent 
            p.afegirMonedesJugador(p.getIndexCorregit(nJugadors-1),-1);             // i de l'últim
        }
        else if(indexCorregit==nJugadors-1){                                       // Cas es troba al final
            p.afegirMonedesJugador(p.getIndexCorregit(0),-1);                       // Extreu del primer
            p.afegirMonedesJugador(p.getIndexCorregit(indexCorregit-1),-1);         // i de l'anterior
        }
        else{                                                                       // Altrament extreu de l'anterior i del seguent
            p.afegirMonedesJugador(p.getIndexCorregit(indexCorregit-1),-1);
            p.afegirMonedesJugador(p.getIndexCorregit(indexCorregit+1),-1);
        }
        p.afegirMonedesJugador(p.getIndexJugadorExecutador(),2);                 // Suma dues monedes al lladre
    }
    
} // END OF CLASS LLADRE
