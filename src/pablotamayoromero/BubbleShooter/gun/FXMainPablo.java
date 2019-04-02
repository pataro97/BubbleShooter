package pablotamayoromero.BubbleShooter.gun;

//Importar clase cañon
import pablotamayoromero.BubbleShooter.gun.Cañon;
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
    //Añado clase cañon
    Cañon cañon = new Cañon();
    public void start(Stage primaryStage) {
        Pane root = new Pane();
        Scene scene = new Scene(root, cañon.ANCHO_PANTALLA, cañon.ALTO_PANTALLA);
        primaryStage.setTitle("Main Pablo");
        primaryStage.setScene(scene);
        primaryStage.show();
        
        
        //Ver dato del metodo calAngulo
        System.out.println(cañon.calAngulo());
        
                
        // -------------------------Linea
        Line line = new Line(cañon.mitadAnchoPantalla, cañon.ALTO_PANTALLA, cañon.ANCHO_PANTALLA, cañon.calAngulo());
        line.setVisible(false);
        // -------------------------Linea 2
        Line line2 = new Line(0, cañon.calAngulo(), cañon.mitadAnchoPantalla, cañon.ALTO_PANTALLA);
        line2.setVisible(false);
        
        
        
        // Animacion linea
        Timeline animationLine = new Timeline(
            new KeyFrame(Duration.seconds(0.017), new EventHandler<ActionEvent>() {
               public void handle(ActionEvent ae) {
                line.setEndY(cañon.calAngulo());
                line2.setStartY(cañon.calAngulo());
                
                //Si el angulo es mayor de 90 pinta linea 1 si no la linea 2
                if (cañon.anguloDisparo > 90)
                    line.setVisible(true);
                else{
                    line2.setVisible(true);
                }
            
               }
               })
        );
        
        
        
        //-------------------------Controles
        scene.setOnKeyPressed((KeyEvent pulsatecla) -> {
           switch(pulsatecla.getCode()) {
               case LEFT:
                   //Pulsa tecla izquierda
                   cañon.anguloDisparo--;
               break;
               case RIGHT:
                   //Pulsa tecla derecha
                   cañon.anguloDisparo++;
                break;
           }
        });
        
        animationLine.setCycleCount(Timeline.INDEFINITE);
        animationLine.play();
        root.getChildren().addAll(line, line2);
    }

    /*
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
