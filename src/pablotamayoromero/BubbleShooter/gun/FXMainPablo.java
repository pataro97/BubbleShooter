/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pablotamayoromero.BubbleShooter.gun;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;
import javafx.scene.shape.Polygon;
import javafx.stage.Stage;

/**
 *
 * @author usuario
 */

public class FXMainPablo extends Application {
    final int ANCHO_PANTALLA = 200;
    final int ALTO_PANTALLA = 200;
    float anguloDisparo = 45;
    float anchoX = 200;
    double resultadoY;
    
    
    @Override
    public void start(Stage primaryStage) {
        Pane root = new Pane();
        Scene scene = new Scene(root, ANCHO_PANTALLA, ALTO_PANTALLA);
        primaryStage.setTitle("Main Pablo");
        primaryStage.setScene(scene);
        primaryStage.show();
        double radian = Math.toRadians(anguloDisparo);
        resultadoY = Math.tan(radian)*anchoX;
        
        System.out.println(resultadoY);
        float resulAncho = ANCHO_PANTALLA/2;
        Line line = new Line(resulAncho, ALTO_PANTALLA, ANCHO_PANTALLA, resultadoY);
//        Polygon triangulo = new Polygon(new double[]{
//            resulAncho,ALTO_PANTALLA,
//            ANCHO_PANTALLA,0,
//            ANCHO_PANTALLA, resultadoY
//            
//        });
//        triangulo.setVisible(false);
//        triangulo.setFill(Color.BLACK);
        root.getChildren().addAll(line);
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
