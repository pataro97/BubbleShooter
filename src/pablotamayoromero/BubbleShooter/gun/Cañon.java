/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pablotamayoromero.BubbleShooter.gun;


/**
 *
 * @author usuario
 */

public class Cañon {
    //Constantes alto y ancho de pantalla
    public static final int ANCHO_PANTALLA = 400;
    public static final int ALTO_PANTALLA = 400;
    //Angulo de disparo
    public double anguloDisparo = 50.0;
    //Calculo Altura Triangulo Y
    double radian;
    double resultadoY;
    double resultadoFinalY;
    // Resultado mitad pantalla
    public float mitadAnchoPantalla = ANCHO_PANTALLA/2;
     
    public double calAngulo(){
        // Si el angulo de disparo es mayor que 89.99, le resta al angulo 90 y realiza el calculo
        if (anguloDisparo > 89.99){
            anguloDisparo -= 90;
            radian = Math.toRadians(anguloDisparo);
            resultadoY = Math.tan(radian)*(ANCHO_PANTALLA/2);
            resultadoFinalY = ALTO_PANTALLA - resultadoY;
        
        }else{
            radian = Math.toRadians(anguloDisparo);
            resultadoY = Math.tan(radian)*(ANCHO_PANTALLA/2);
            resultadoFinalY = ALTO_PANTALLA - resultadoY;
        }
        
        return resultadoFinalY;
    }
    
}
