
package projecteprogramaciolmp;

public class Moneda {
    // ATRIBUTS
    // ---------------------
    int _numeroMonedes;
    // ---------------------
    
////// ================================================================================================================= //////
//////                                                                                                                   //////
//////                                             CONSTRUCTORS                                                          //////
//////                                                                                                                   //////
////// ================================================================================================================= //////
    
    public Moneda(){/**
     * PRE: --
     * POST: el numero de monedes es 0.
     */
        _numeroMonedes= 0;
    }
    public Moneda(int n){/**
     * PRE: n>= 0
     * POST: el nombre de monedes es <n>.
     */
        _numeroMonedes= n;
    }
    
////// ================================================================================================================= //////
//////                                                                                                                   //////
//////                                             MÈTODES CONSULTORS                                                    //////
//////                                                                                                                   //////
////// ================================================================================================================= //////
    
    public int retornaQuantitat(){
    // Pre: --
    // Post: Retorna enter que correspon al número de monedes de l'objecte
        return _numeroMonedes;
    }
    
    @Override
    public boolean equals(Object o){
    // Pre: o castejable a Moneda
    // Post: Retorna TRUE en cas que o tingui la mateixa quantitat de monedes
        Moneda m= (Moneda)o;
        return compareTo(m)==0;
    }
    
    public int compareTo(Moneda in){
    // Pre: in instanciat
    // Post: Retorna -1 si -->this és més petit (en quantitat de monedes) que
    // in, zero si tenen la mateixa quantitat o 1 si en té més
        int retorn= 0;
        if(_numeroMonedes>in._numeroMonedes)
           retorn = 1;
        else if(_numeroMonedes<in._numeroMonedes)
           retorn = -1;
        return retorn;
    }

////// ================================================================================================================= //////
//////                                                                                                                   //////
//////                                             MÈTODES MODIFICADORS                                                  //////
//////                                                                                                                   //////
////// ================================================================================================================= //////

    public void afegirMonedes(int n){
    // Pre: --
    // Post: S'afegeixen n monedes al num de monedes ja guardat en l'objecte
        _numeroMonedes+= n;
    }
    
    public void actualitzarMonedes(Moneda n){
    // Pre: n instanciat
    // Post: Les monedes de l'objecte ara tenen la mateixa quantitat que la de l'objecte n
        _numeroMonedes= n._numeroMonedes;
    }
    
} // END OF CLASS MONEDA