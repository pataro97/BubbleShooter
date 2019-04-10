/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.antoniomanuelramirez.BubbleShooter.diseñoBurbujas;

import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;

/**
 *
 * @author Antonio Manuel
 */
public class TableroView {
    GridPane gridTablero = new GridPane();
    Burbujas burbujas = new Burbujas();
    int tamBurbuja = 30; 
    
    public GridPane getGridTablero(){
        return gridTablero;
    }
    // Creamos los siguientes metodos para hacer el tablero y mostrarlo en pantalla, es decir, acompañandonos de la 
    //matriz rellenamos todos los huecos con un rectangulo
    private void rellenarCasilla(int x, int y) {
        // Dibujamos las casillas del tablero con rectangulos 
        Rectangle casilla = new Rectangle(60, 60, Color.LIGHTGREY);
        casilla.setStroke(Color.BLACK);
        gridTablero.add(casilla, x, y);
    }
    // Este metodo recorre toda la matriz rellenando cada una de las casillas con un rectangulo para formar el tablero
    public void mostrarCasillas() {
        for(int y=0; y<4; y++) {
            for(int x=0; x<5; x++) {
                rellenarCasilla(x, y);
            }
        }
    }
    // Metodo que se crea para establecer la burbuja en una determinada casilla del tablero, que dependiendo del valor 
    //que se encuentre en la matriz colocará una burbuja de un determinado color
    public void seleccionarBurbuja() {
        for(int y=0; y<4; y++) {
            for(int x=0; x<5; x++) {
                Circle circleBurbuja = new Circle (tamBurbuja);
                switch(burbujas.matrizTablero [x] [y]) {
                    case 'B':
                        circleBurbuja.setFill(Color.BLUE);
                    break;
                    case 'R':
                        circleBurbuja.setFill(Color.RED);
                    break;
                    case 'Y':
                        circleBurbuja.setFill(Color.YELLOW);
                    break;
                    case 'P':
                        circleBurbuja.setFill(Color.PURPLE);
                    break;
                }
                // Añadimos la burbuja a la pantalla para que se muestre
                gridTablero.add(circleBurbuja, x, y);
            }
        }
    }
}