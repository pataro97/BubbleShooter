/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package albertomateos.BubbleShooter.logica;

import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;

/**
 *
 * @author PC07
 */
class TableroView {
      GridPane gridTablero = new GridPane();
    
    public GridPane getGridTablero() {
        return gridTablero;
    }
 public void ponerBola(int x, int y, char bola) {
        switch(bola){
            case 'r':
                Circle circleBola = new Circle(20, Color.BLUE);
                gridTablero.add(circleBola, x, y);
            break;
        }
    }
    
    public void rellenarCasilla(int x, int y) {
        Rectangle r = new Rectangle(60, 140, Color.BLACK);
        gridTablero.add(r, x, y);
    }    

    
 }

    

