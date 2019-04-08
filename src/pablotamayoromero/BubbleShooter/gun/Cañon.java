/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pablotamayoromero.BubbleShooter.gun;

import java.util.Random;

/**
 *
 * @author usuario
 */

public class Cañon {
    public double sumAncho;
    //Constantes alto y ancho de pantalla
    public static final int ANCHO_PANTALLA = 400;
    public static final int ALTO_PANTALLA = 400;
    //Angulo de disparo
    public double anguloDisparo = 45;
    //Calculo Altura Triangulo
    double radian;
    double resultadoX;
    double resultadoFinalX;
    // Resultado mitad pantalla
    public float mitadAnchoPantalla = ANCHO_PANTALLA/2;
     
    public double calAngulo(){
        radian = Math.toRadians(anguloDisparo);
        resultadoX = Math.tan(radian)*(mitadAnchoPantalla);
        resultadoFinalX = ANCHO_PANTALLA - resultadoX;
        return resultadoFinalX;
    }
    public char colorBurbujas(){
        Random r = new Random();
        String alphabet = "rgby";
        
        return alphabet.charAt(r.nextInt(alphabet.length()));
        
    }
}
