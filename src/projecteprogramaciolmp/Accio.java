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
    
    // ATRIBUTS
    // ----------------
    Rol _accioRol;
    // ----------------
    
////// ================================================================================================================= //////
//////                                                                                                                   //////
//////                                             CONSTRUCTORS                                                          //////
//////                                                                                                                   //////
////// ================================================================================================================= //////
    
    public Accio()
    {
        
    }
    
    public Accio(Rol r){
    // Pre: --
    // Post: Acció ara té com a rol r
        _accioRol= r;
    }
    
////// ================================================================================================================= //////
//////                                                                                                                   //////
//////                                             MÈTODES CONSULTORS                                                    //////
//////                                                                                                                   //////
////// ================================================================================================================= //////

    public Rol getRol(){
    // Pre: --
    // Post: Retorna el rol de l'acció
        return _accioRol;
    }
    
    public void consultaCarta(Jugador j) {
    // Pre: Jugador j correspon a un jugador de la partida
    // Post: Mostra el rol d'alguna carta del jugador
        if(j.nCartes()!=1){
            System.out.println("Cartes a consultar: "); 
            for (int i=0;i<j.nCartes();i++){                                                                    // Mostra les cartes disponibles
                System.out.println("Carta "+i);   
            }

            System.out.println("Quina carta vols consular?"); 
            Scanner teclat= new Scanner(System.in);
            int carta = teclat.nextInt();                                                                        // Recull un numero de carta de les disponibles
            while (carta<0 || carta>j.nCartes()-1){                                                             // Si el número no es vàlid
                     System.out.println();
                     System.out.println("Has entrat un número de carta invàlida. Torna a escollir siusplau");       
                     carta = teclat.nextInt();
                }
            String rol=j.getCarta(carta).getRolCarta().getRol();
            System.out.println("La carta "+carta+ " té el rol de "+rol);
        }
        else
            System.out.println("La carta "+ 0 + " té el rol de "+j.getCarta(0).getRolCarta().getRol());// Mostra el rol de la carta escollida
        
        
    }
    
    public boolean decidir() {
    // Pre: --
    // Post: Retorna TREU o FALSE en funció de la decisió del jugador
        Scanner teclat= new Scanner(System.in);
        System.out.println("Escriu 'Y' per dir SI o 'N' per dir NO");                                       // Formula pregunta de YES or NOT
        String decisio = teclat.nextLine();
        System.out.println();
        while (!decisio.equals("Y") && !decisio.equals("N")){                                               // Si no s'ha entrar Y o N torna a demanar
            System.out.println("Escriu 'Y' per dir SI o 'N' per dir NO");
            decisio = teclat.nextLine();
            System.out.println();
        }
        return decisio.equals("Y");
    }
    
    public void consultaCarta(Partida p){
        p.escollirCartaVictima(p.getIndexJugadorExecutador(0));
        //per acabar crec
    }
    
////// ================================================================================================================= //////
//////                                                                                                                   //////
//////                                             MÈTODES MODIFICADORS                                                  //////
//////                                                                                                                   //////
////// ================================================================================================================= //////

    public void nouRol(Rol r){
    // Pre: r instanciat
    // Post: Acció ara té un nou rol
        _accioRol= r;
    }
    
    public void intercanviarCartes(Partida p){
    // Pre: p correspon a la partida actual
    // Post: 
        System.out.println("Selecciona una carta del mazo");
        p.mostraCartesMazo();
    }
        
    public void accioDeRol(Partida p){
    // Pre: p setejat
    // Post: Executa l'acció de rol que té actualment acció
        _accioRol.accioDeRol(p);
    }
    
} // END OF CLASS ACCIO
