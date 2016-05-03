/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projecteprogramaciolmp;
import java.util.*;
/**
 *
 * @author aerop
 */
public class Accio {
    Rol accioRol;
    public Accio(){
        
    }
    public Accio(Rol r){
        accioRol= r;
    }
    public void nouRol(Rol r){
        accioRol= r;
    }
    public void intercanviarCartes(){
        
    }
    public void consultaCarta(){
        
    }
    public void accioDeRol(Partida p){
        accioRol.accioDeRol(p);
    }
    public boolean decidir() {
        Scanner teclat= new Scanner(System.in);
        System.out.println("Escriu 'Y' per dir SI o 'N' per dir NO");
        String decisio = teclat.nextLine();
        while (!decisio.equals("Y") && !decisio.equals("N")){
            System.out.println("Escriu 'Y' per dir SI o 'N' per dir NO");
            decisio = teclat.nextLine();
        }
        return decisio.equals("Y");
        //return signal;
    }
}
