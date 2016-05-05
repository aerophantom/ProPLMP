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
///////////////////////////////ATRIBUTS\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\
    Rol _accioRol;
    
///////////////////////////////CONSTRUCTORS\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\
    public Accio(){
    }
    public Accio(Rol r){/**
     * PRE:--
     * POST: Accio ara te com a rol <r>
     */
        _accioRol= r;
    }
///////////////////////////////CONSULTORS\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\
    public Rol getRol(){/**
     * PRE:--
     * POST: Retorna el rol de l'accio
     */
        return _accioRol;
    }
    
    public void consultaCarta(Jugador j) {
        
        System.out.println("Cartes a consultar: "); 
        for (int i=0;i<j.nCartes();i++){
            System.out.println("Carta "+i);   
        }
        System.out.println("Quina carta vols consular?"); 
        Scanner teclat= new Scanner(System.in);
        int carta = teclat.nextInt();
        while (carta<0 || carta>j.nCartes()-1){
                 System.out.println();
                 System.out.println("Has entrat un número de carta invàlida. Torna a escollir siusplau");
                 carta = teclat.nextInt();
            }
        String rol=j.getCarta(carta).getRolCarta().getRol();
        System.out.println("La carta "+carta+ " té el rol de "+rol);
        
        
    }
    
    public boolean decidir() {/**
     * PRE: --
     * POST: Es retorna cert o fals en funcio de la decisió escrita per consola
     */
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
    public void consultaCarta(Partida p){
        p.escollirCarta(p.obtIndexJugadorExecutador());
        //per acabar crec
    }
///////////////////////////////MODIFICADORS\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\
    public void nouRol(Rol r){/**
     * PRE: <r> instanciat.
     * POST: Accio ara té un nou rol.
     */
        _accioRol= r;
    }
    
    public void intercanviarCartes(Partida p){
        System.out.println("Selecciona una carta del mazo");
        p.mostraCartesMazo();
        //per acabar
    }
        
    public void accioDeRol(Partida p){/**
     * PRE: <p> setejat
     * POST: Executa l'accio de rol que te actualment Accio.
     */
        _accioRol.accioDeRol(p);
    }
}
