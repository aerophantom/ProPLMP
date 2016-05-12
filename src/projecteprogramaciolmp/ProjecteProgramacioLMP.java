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
        System.out.println("Quants jugadors humans jugaran?");
        Scanner teclat = new Scanner (System.in);
        int numJug = teclat.nextInt();
        
        System.out.println("Quants jugadors hi hauran de la IA");
        int nIA = teclat.nextInt(); 
        
        System.out.println("Entra la dificultat de la IA (0..3)");
        int dificultat = teclat.nextInt();
        
        System.out.println("Amb quantes monedes es guanya la partida?");
        int numMG= teclat.nextInt();
        
        System.out.println("Quantes monedes per jugador?");
        int numMJ= teclat.nextInt();
        
        Partida nova = new Partida(numJug,numMG,numMJ, nIA,dificultat);
        
       
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