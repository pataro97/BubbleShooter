package pablotamayoromero.BubbleShooter.gun;

import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import javafx.stage.Stage;

/**
 *
 * @author usuario
 */

public class FXMainPablo extends Application {
    final int ANCHO_PANTALLA = 400;
    final int ALTO_PANTALLA = 400;
    double anguloDisparo = 100.0;
    double anguloDisparoR = anguloDisparo;
    double resultadoY;
    double resultadoFinalY;
    double radian;
    float resulAncho;
    double xPelota;
    double yPelota = ALTO_PANTALLA;
    @Override
    public void start(Stage primaryStage) {
        Pane root = new Pane();
        Scene scene = new Scene(root, ANCHO_PANTALLA, ALTO_PANTALLA);
        primaryStage.setTitle("Main Pablo");
        primaryStage.setScene(scene);
        primaryStage.show();
        
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
        resulAncho = ANCHO_PANTALLA/2;
        // -------------------------Linea
        Line line = new Line(resulAncho, ALTO_PANTALLA, ANCHO_PANTALLA, resultadoFinalY);
        line.setVisible(false);
        // -------------------------Linea 2
        Line line2 = new Line(0, resultadoFinalY, resulAncho, ALTO_PANTALLA);
        line2.setVisible(false);
        //Escribe x pelota
        xPelota = resulAncho;
        //pelota
        Circle pelota = new Circle(xPelota, yPelota, 3);
        //Animation Generar triangulo movimiento pelota
         AnimationTimer pelotaAnimation = new AnimationTimer(){
             @Override
              public void handle(long now){
                if(resultadoFinalY < yPelota){
                    
                }
              }
         };
        // Chapuza  
        if (anguloDisparoR > 89.99){
            line2.setVisible(true);
        }else{
            line.setVisible(true);
        }
        
        
        // Iniciar animacion pelota
        pelotaAnimation.start();
        root.getChildren().addAll(line, line2, pelota);
    }

    /*
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
