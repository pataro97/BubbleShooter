/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pablotamayoromero.BubbleShooter.gun;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Polygon;
import javafx.stage.Stage;

/**
 *
 * @author usuario
 */

public class FXMainPablo extends Application {
    float anguloDisparo = 50;
    float anchoX = 100;
    double resultadoY;
    
    
    @Override
    public void start(Stage primaryStage) {
        StackPane root = new StackPane();
        Scene scene = new Scene(root, 400, 400);
        primaryStage.setTitle("Main Pablo");
        primaryStage.setScene(scene);
        primaryStage.show();
        
        resultadoY = Math.tan(anguloDisparo)* anchoX;
        System.out.println(resultadoY);
        
        Polygon triangulo = new Polygon(new double[]{
            0,resultadoY,
            0,200,
            anchoX,200
        });
        triangulo.setVisible(true);
        triangulo.setFill(Color.BLACK);
        root.getChildren().addAll(triangulo);
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
