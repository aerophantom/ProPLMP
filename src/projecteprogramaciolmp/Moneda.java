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
        
    }
    public void afegirMonedes(int n){
        _numeroMonedes+= n;
    }
    
}
