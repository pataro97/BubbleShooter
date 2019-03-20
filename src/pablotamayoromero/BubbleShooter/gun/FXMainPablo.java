package pablotamayoromero.BubbleShooter.gun;

import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import javafx.stage.Stage;
import javafx.animation.KeyFrame;
import javafx.event.EventHandler;
import javafx.scene.input.KeyEvent;
import javafx.util.Duration;

/**
 *
 * @author usuario
 */

public class FXMainPablo extends Application {
    final int ANCHO_PANTALLA = 400;
    final int ALTO_PANTALLA = 400;
    double anguloDisparo = 109.9;
    double anguloDisparoRegis = anguloDisparo;
    double resultadoY;
    double resultadoFinalY;
    double radian;
    float mitadAnchoPantalla;
    double xPelota;
    double yPelota = ALTO_PANTALLA;
    double radianCircle;
    double resultadoYCircle;
    double resultadoFinalYCircle;
    double sumHcircle;
    double resXcircle;
    double resultadoXCircle;
    double sumLine;
    double resLine;
    double puntoLine;
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
        mitadAnchoPantalla = ANCHO_PANTALLA/2;
        
        // -------------------------Linea
        Line line = new Line(mitadAnchoPantalla, ALTO_PANTALLA, ANCHO_PANTALLA, resultadoFinalY);
        line.setVisible(false);
        // -------------------------Linea 2
        Line line2 = new Line(0, resultadoFinalY, mitadAnchoPantalla, ALTO_PANTALLA);
        line2.setVisible(false);
        
        // Animacion linea
        Timeline animationLine = new Timeline(
            new KeyFrame(Duration.seconds(0.017), new EventHandler<ActionEvent>() {
               public void handle(ActionEvent ae) {
                line.setEndX(100);
                line.setEndY(90.10);
                System.out.println(resultadoFinalY);
                line2.setStartY(puntoLine = resultadoFinalY + sumLine);
            
                // Mirar si el angulo introducido inicialmente es mayor de 90 y dependiendo de este dato poner visible una linea u otra
                if (anguloDisparoRegis > 89.99){
                    line2.setVisible(true);
                }else{
                    line.setVisible(true);
                }
               }
               })
        );
            
        //Escribe x pelota
        xPelota = mitadAnchoPantalla;
        //pelota
        Circle pelota = new Circle(xPelota, yPelota, 4);
        //TimeLine Generar triangulo movimiento pelota
         Timeline animationCircle = new Timeline(
            new KeyFrame(Duration.seconds(0.017), new EventHandler<ActionEvent>() {
               public void handle(ActionEvent ae) {
                if(resultadoFinalY < yPelota){
                    sumHcircle += 1;
                    radianCircle = Math.toRadians(anguloDisparo);
                    resultadoYCircle = Math.sin(radianCircle)*(sumHcircle);
                    resultadoXCircle = Math.cos(radianCircle)*(sumHcircle);
                    yPelota = ALTO_PANTALLA - resultadoYCircle;
                    resXcircle = (ANCHO_PANTALLA/2)-resultadoXCircle;
                    System.out.println(resXcircle);
                }
                
                pelota.setCenterX(resXcircle);
                pelota.setCenterY(yPelota);
             }
            })                
        );
        
        
        // Control del cañon
        scene.setOnKeyPressed((KeyEvent pulsatecla) -> {
           switch(pulsatecla.getCode()) {
               case LEFT:
                   //Pulsa tecla izquierda
                   anguloDisparo--;
                   sumLine++;
               break;
               case RIGHT:
                   //Pulsa tecla derecha
                   anguloDisparo++;
                   resLine--;
                break;
               case SPACE:
                // Disparar pelota al pulsar
                // Iniciar animacion pelota
                animationCircle.setCycleCount(Timeline.INDEFINITE);
                animationCircle.play(); 
                break;
           }
        });
        animationLine.setCycleCount(Timeline.INDEFINITE);
        animationLine.play();
        root.getChildren().addAll(line, line2, pelota);
    }

    /*
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}