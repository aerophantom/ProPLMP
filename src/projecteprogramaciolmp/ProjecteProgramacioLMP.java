///////////////////////////////////////
//
// Projecte de Programació
// 
//
////////////////////////////////////////


package projecteprogramaciolmp;

import java.util.Scanner;

/**
 *
 * @author aerop
 */
public class ProjecteProgramacioLMP {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        System.out.println("Quants jugadors jugaràn?");
        Scanner teclat = new Scanner (System.in);
        int numJug = teclat.nextInt();
        Partida nova = new Partida(numJug);
        
        nova.dinamicaDelJoc();
    }
    
}



/*
* Introduir monedesperjugador, monedesperguanyar, cartesperjugador, per consola més instruccions
* Per la setmana que ve IA
*
*
*
*
*/