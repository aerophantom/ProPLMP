/////////////////////////////////////
//
//  Rol Widow --
//  La viuda, quan realitza la seva acció de rol, obté 10 monedes que li proporciona el Banc Nacional.
//  Si es dona el cas que el personatge amb aquest rol, ja té 10 monedes o més, llavors no rebrà cap moneda més.
//
/////////////////////////////////////

package projecteprogramaciolmp;

public class Viuda extends Rol {
    
     // ============================================================
    // Mètodes CONSTRUCTORS
    // ============================================================
    public Viuda() {/**
     * PRE:--
     * POST: L'identificatiu de Rol ara es "Viuda".
     */ 
       _nomRol="Viuda"; 
    }
    
    @Override
    public void accioDeRol(Partida p){/**
     * PRE: <p> setejat.
     * POST: L'executador obte una certa quantitat de monedes del banc el qual
     * la suma amb les monedes actuals no passarà de 10.
     */
        //NOTA: SHA DE PODER CAMBIAR EL LIMIT PER OBTENIR (DE 10 A 8 O A 14, JOKESE)
        int monedesExecutador= p.obtMonedesJugador(p.obtIndexJugadorExecutador());
        if(monedesExecutador>=10){
            System.out.print("No reps cap moneda ja que en tens el limit");
        }
        else{
            p.afegirMonedesJugador(p.obtIndexJugadorExecutador(), 10-monedesExecutador);
            p.treureMonedesBanc(10-monedesExecutador);
        }
    }
    
}
