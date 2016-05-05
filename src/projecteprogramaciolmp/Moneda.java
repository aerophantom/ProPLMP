/*
 * Com va dir en Castro, faig la classe monedes que sera comuna a totes les
classes que implementin monedes. 
 */
package projecteprogramaciolmp;

public class Moneda {
    int _numeroMonedes;
    
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
    public int retornaQuantitat(){/**
     * PRE:--
     * POST: Retorna en forma de Integer el numero de monedes del contenidor.
     */
        return _numeroMonedes;
    }
    public void afegirMonedes(int n){/**
     * PRE:--
     * POST: S'afegeixen <n> monedes al contenidor.
     */
        _numeroMonedes+= n;
    }
    public void actualitzarMonedes(Moneda n){/**
     * PRE: <n> instanciat
     * POST: les monedes del contenidor ara son les del contenidor <n>.
     */
        _numeroMonedes= n._numeroMonedes;
    }
    
    @Override
    public boolean equals(Object o){/**
     * PRE: <o> castejable a Moneda
     * POST: Retorna cert en cas que <o> tingui la mateixa quantitat de monedes que
     * <this>.
     */
        Moneda m= (Moneda)o;
        return compareTo(m)==0;
    }
    public int compareTo(Moneda in){/**
     * PRE: <in> instanciat.
     * POST: Retorna -1 si <this> es mes petit (en quantitat de monedes sempre) que 
     * <in>, zero si tenen la mateixa quantitat o 1 si té més.
     */
        int retorn= 0;
        if(_numeroMonedes>in._numeroMonedes)
           retorn = 1;
        else if(_numeroMonedes<in._numeroMonedes)
           retorn = -1;
        return retorn;
    }
    
}
