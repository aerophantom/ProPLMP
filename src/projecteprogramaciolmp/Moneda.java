/*
 * Com va dir en Castro, faig la classe monedes que sera comuna a totes les
classes que implementin monedes. 
 */
package projecteprogramaciolmp;

/**
 *
 * @author aerop
 */
public class Moneda {
    int _numeroMonedes;
    
    public Moneda(){
        _numeroMonedes= 0;
    }
    public Moneda(int n){
        _numeroMonedes= n;
    }
    public int retornaQuantitat(){
        return _numeroMonedes;
    }
    public void afegirMonedes(int n){
        _numeroMonedes+= n;
    }
    public void actualitzarMonedes(Moneda n){
        _numeroMonedes= n._numeroMonedes;
    }
    
    @Override
    public boolean equals(Object o){
        Moneda m= (Moneda)o;
        return compareTo(m)==0;
    }
    public int compareTo(Moneda in){
        int retorn= 0;
        if(_numeroMonedes>in._numeroMonedes)
           retorn = 1;
        else if(_numeroMonedes<in._numeroMonedes)
           retorn = -1;
        return retorn;
    }
    
}
