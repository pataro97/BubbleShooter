package pablotamayoromero.BubbleShooter.gun;

//Importar clase cañon
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
    //Creo objeto de la clase cañon
    Cañon cañon = new Cañon();
    int ejeYBurbuja = cañon.ALTO_PANTALLA;
    double ejeXBurbuja = cañon.mitadAnchoPantalla;
    public char estadoColorBurbuja = '0';
    public void start(Stage primaryStage) {
        Pane root = new Pane();
        Scene scene = new Scene(root, cañon.ANCHO_PANTALLA, cañon.ALTO_PANTALLA);
        primaryStage.setTitle("Main Pablo");
        primaryStage.setScene(scene);
        primaryStage.show();
                
        // -------------------------Linea
        Line line = new Line(cañon.mitadAnchoPantalla, cañon.ALTO_PANTALLA, cañon.calAngulo(), 0);
        line.setVisible(true);
        // -------------------------Burbuja
        Circle burbuja = new Circle(cañon.mitadAnchoPantalla,cañon.ALTO_PANTALLA, 5);
        
        //------------------------------------------------- Animacion linea
        Timeline animationLine = new Timeline(
            new KeyFrame(Duration.seconds(0.017), new EventHandler<ActionEvent>() {
               public void handle(ActionEvent ae) {
                line.setEndX(cañon.calAngulo());
                System.out.println(cañon.calAngulo());
                   
               }
               
               })
        );
        //-----------------------------------------------------Animacion Burbuja
        Timeline animationBurbuja = new Timeline(
            new KeyFrame(Duration.seconds(0.017), new EventHandler<ActionEvent>() {
               
               public void handle(ActionEvent ae) {
                   ejeYBurbuja--;
                   if (ejeXBurbuja < cañon.calAngulo()){
                       ejeXBurbuja++;
                   }else{
                       ejeXBurbuja--;
                   }
                   
                   burbuja.setCenterY(ejeYBurbuja);
                   burbuja.setCenterX(ejeXBurbuja);
                   System.out.println(estadoColorBurbuja);
               }
               })
        );
        
        //-------------------------Controles
        scene.setOnKeyPressed((KeyEvent pulsatecla) -> {
           switch(pulsatecla.getCode()) {
               case LEFT:
                   cañon.anguloDisparo++;
               break;
               case RIGHT:
                   cañon.anguloDisparo--;
                break;
               case SPACE:
                   animationBurbuja.play();
                break;
           }
        });
        if (estadoColorBurbuja == '0'){
            // Color Burbuja
            switch(cañon.colorBurbujas()){
                case 'r':
                   burbuja.setFill(javafx.scene.paint.Color.RED);
                   estadoColorBurbuja = 'r';
                break;
                case 'b':
                    burbuja.setFill(javafx.scene.paint.Color.BLUE);
                    estadoColorBurbuja = 'b';
                break;
                case 'g':
                    burbuja.setFill(javafx.scene.paint.Color.GREEN);
                    estadoColorBurbuja = 'g';
                break;
                case 'y':
                    burbuja.setFill(javafx.scene.paint.Color.YELLOW);
                    estadoColorBurbuja = 'y';
                break;
           }
            System.out.println(estadoColorBurbuja);
        }
        
        
        //Animacion linea
        animationLine.setCycleCount(Timeline.INDEFINITE);
        animationLine.play();
        //Animacion Burbuja
        animationBurbuja.setCycleCount(Timeline.INDEFINITE);
        
        
        root.getChildren().addAll(line, burbuja);
    }

    /*
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
