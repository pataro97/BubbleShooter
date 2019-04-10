/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pablotamayoromero.BubbleShooter.gun;

import albertomateos.BubbleShooter.logica.BubbleShooter;
import java.util.Random;
/**
 *
 * @author usuario
 */

public class Cañon {
    public int sumFila = 1;
    public boolean numPartida = false;
    //Estado altual de la burbuja
    public char estadoColorBurbuja = '0';
    //FXMainPablo fxMainPablo = new FXMainPablo();
    //Creo objeto de la clase bubbleShooter
    BubbleShooter bubbleShooter = new BubbleShooter();
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
        String alphabet = "rgbyp";
        
        return alphabet.charAt(r.nextInt(alphabet.length()));
        
    }
    //metodo que devuelve la posición en la que se colocará la burbuja disparada
    public void comprobarCasilla(int columna, int fila){
            if (bubbleShooter.matrizTablero[columna][fila] == '0'){
                if (bubbleShooter.matrizTablero[columna][fila-1] == '0'){
                    if(bubbleShooter.matrizTablero[columna][fila-2] == '0'){
                        if(bubbleShooter.matrizTablero[columna][fila-3] == '0'){
                            if(bubbleShooter.matrizTablero[columna][fila-4] == '0'){
                                if(bubbleShooter.matrizTablero[columna][fila-5] == '0'){
                                    bubbleShooter.ponerBola(columna, fila-5, estadoColorBurbuja);
                                }else{
                                    if(estadoColorBurbuja == bubbleShooter.matrizTablero[columna][fila-5]){
                                        bubbleShooter.ponerBola(columna, fila-5, '0');
                        
                                    }else{
                                        bubbleShooter.ponerBola(columna, fila-4, estadoColorBurbuja);
                                    }
                                }
                            }else{
                                if(estadoColorBurbuja == bubbleShooter.matrizTablero[columna][fila-4]){
                                    bubbleShooter.ponerBola(columna, fila-4, '0');
                        
                                }else{
                                    bubbleShooter.ponerBola(columna, fila-3, estadoColorBurbuja);
                                }
                            }
                        }else{
                            if(estadoColorBurbuja == bubbleShooter.matrizTablero[columna][fila-3]){
                                bubbleShooter.ponerBola(columna, fila-3, '0');
                        
                            }else{
                                bubbleShooter.ponerBola(columna, fila-2, estadoColorBurbuja);
                            }
                        }
                    }else{
                        if(estadoColorBurbuja == bubbleShooter.matrizTablero[columna][fila-2]){
                        bubbleShooter.ponerBola(columna, fila-2, '0');
                        
                        }else{
                            bubbleShooter.ponerBola(columna, fila-1, estadoColorBurbuja);
                        }
                    }
                }else{
                    if(estadoColorBurbuja == bubbleShooter.matrizTablero[columna][fila-1]){
                        bubbleShooter.ponerBola(columna, fila-1, '0');
                        
                    }else{
                        bubbleShooter.ponerBola(columna, fila, estadoColorBurbuja);
                    }
                    
                    
                }
            }else{
                
                if(estadoColorBurbuja == bubbleShooter.matrizTablero[columna][fila]){
                        bubbleShooter.ponerBola(columna, fila, '0');
                        
                    }else{
                        sumFila = fila+1;
                        bubbleShooter.ponerBola(columna, sumFila, estadoColorBurbuja);
                }
            }
            estadoColorBurbuja = '0';
            System.out.println("Matriz:");
            bubbleShooter.mostrarTablero();
        }
    //Genera una fila de burbujas de colores aleatorios
    public void generarPartida(){
    if (numPartida == false){
        //-----------------------Modificar matriz
        //Limite
        bubbleShooter.ponerBola(0, 0, '1');
        bubbleShooter.ponerBola(1, 0, '1');
        bubbleShooter.ponerBola(2, 0, '1');
        bubbleShooter.ponerBola(3, 0, '1');
        bubbleShooter.ponerBola(4, 0, '1');
        bubbleShooter.ponerBola(5, 0, '1');
        bubbleShooter.ponerBola(6, 0, '1');
        //Primera Fila
        bubbleShooter.ponerBola(0, 1, colorBurbujas());
        bubbleShooter.ponerBola(1, 1, colorBurbujas());
        bubbleShooter.ponerBola(2, 1, colorBurbujas());
        bubbleShooter.ponerBola(3, 1, colorBurbujas());
        bubbleShooter.ponerBola(4, 1, colorBurbujas());
        bubbleShooter.ponerBola(5, 1, colorBurbujas());
        bubbleShooter.ponerBola(6, 1, colorBurbujas());
        bubbleShooter.mostrarTablero();
        numPartida = true;
    }
}
}
