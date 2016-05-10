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
        Interficie aux= new Interficie();
        System.out.println("Quants jugadors jugaràn?");
        Scanner teclat = new Scanner (System.in);
        int numJug = teclat.nextInt();
        
        System.out.println("Amb quantes monedes es guanya la partida?");
        int numMG= teclat.nextInt();
        
        System.out.println("Quantes monedes per jugador?");
        int numMJ= teclat.nextInt();
        
        Partida nova = new Partida(numJug,numMG,numMJ);
        
       
        nova.dinamicaDelJoc();
        
        
    }
    
}



/*
* cartesperjugador, per consola més instruccions
* Per la setmana que ve IA
*
*
*
*
*/