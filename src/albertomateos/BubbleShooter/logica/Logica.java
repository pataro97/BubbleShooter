/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package albertomateos.BubbleShooter.logica;

import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.scene.Scene;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;





/**
 *
 * @author PC07
 */
public class Logica extends Application {
    public void start(Stage primaryStage) {
        
        TableroView tableroView = new TableroView();
        
        BubbleShooter bubbleshooter = new BubbleShooter();
        bubbleshooter.ponerBola(0, 1, '1');
        
        
        for(int y=0; y<7; y++) {
            for(int x=0; x<7
                    ; x++) {
                switch(bubbleshooter.matrizTablero[x][y]) {
                    
                    case '0':
                        tableroView.rellenarCasilla(x,y);
                        break;
                    case '1':
                        tableroView.ponerBola(x, y, '1');
                        break;
                    case '2':
                        tableroView.ponerBola(x, y, '2');
                        break;
                    case '3':
                        tableroView.ponerBola(x, y, '3');
                        break;
                       
                }
            }            
        }  
        
        StackPane root = new StackPane();
        root.getChildren().add(tableroView.getGridTablero());
         
        Scene scene = new Scene(root, 400, 400);
        
        
        primaryStage.setTitle("Bubble Shooter");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
   
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
}
    

   
