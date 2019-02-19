package pablotamayoromero.BubbleShooter.gun;

/**
 *
 * @author pablo
 */

public class Gun {
    float anguloDisparo = 20;
    float anchoX = 10;
    double resultadoY;
    public void handle(long now){
        
        resultadoY = Math.tan(anguloDisparo)* anchoX;
        
    };
        
    
}
