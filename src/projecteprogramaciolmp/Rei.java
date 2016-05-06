/////////////////////////////////////
//
//  Rol Rei --
//  El rei, quan realitza la seva acció de rol, obté 3 monedes del Banc Nacional i la suma a la seva
//  quantitat de monedes
//
/////////////////////////////////////

package projecteprogramaciolmp;

public class Rei extends Rol{
    
////// ================================================================================================================= //////
//////                                                                                                                   //////
//////                                              CONSTRUCTORS                                                         //////
//////                                                                                                                   //////
////// ================================================================================================================= //////
    
    public Rei() {
    // Pre: --
    // Post: L'identificador del Rol ara és REI
        _nomRol="Rei";
    }
    
////// ================================================================================================================= //////
//////                                                                                                                   //////
//////                                              MÈTODES CONSULTORS                                                   //////
//////                                                                                                                   //////
////// ================================================================================================================= //////
    

////// ================================================================================================================= //////
//////                                                                                                                   //////
//////                                              MÈTODES MODIFICADORS                                                 //////
//////                                                                                                                   //////
////// ================================================================================================================= //////
    @Override
    public void accioDeRol(Partida p){
    // Pre: p setejat
    // Post: Es resten 3 monedes del Banc Nacional i s'afegeix la mateixa quantitat al compte corrent del jugador executador
        p.treureMonedesBanc(3);
        p.afegirMonedesJugador(p.getIndexJugadorExecutador(), 3);
        
    }
}
