/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projecteprogramaciolmp;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author aerop
 */
public class JugadorPersona extends Jugador {
    
     public JugadorPersona(Moneda monedes){
        
        _monedes=monedes;
        
    }
    
    @Override
    public Rol escollirRol(ArrayList<Carta> cartes){
    // Pre: --
    // Post: Retorna el rol determinat per un string entrat.
        System.out.print("Elecció: ");
        Scanner teclat= new Scanner(System.in);
        String rol = teclat.nextLine();
        int posC = buscaCarta(rol, cartes);
        while (posC == -1){
            System.out.println("El rol entrat no existeix. Elecció: ");
            rol = teclat.nextLine();
            posC = buscaCarta(rol,cartes);
        }
        Rol juga = cartes.get(posC).getRolCarta();
        return juga;
    }
    
    public int buscaCarta(String rol, ArrayList<Carta> r){
        
        boolean trobada = false;                                            // Boolean per retornar 
        int pos = 0;
        while (!trobada && pos < r.size()){                          // Mentres no s'hagi trobat la carta i no s'hagi recorregut tot l'array de cartes disponibles
            if (r.get(pos).getNom().equals(rol)) trobada=true;       // Si l'has trobada, retornaràs TRUE
            else pos++;                                                      // Altrament incrementa l'índex de posicio
        }
        if (!trobada) pos = -1;
        return pos;
    }
}
