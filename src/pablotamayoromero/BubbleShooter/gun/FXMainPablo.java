package pablotamayoromero.BubbleShooter.gun;

//Importar clase cañon
import albertomateos.BubbleShooter.logica.BubbleShooter;
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
    int contadorReinicio;
    //numero de columna realizando la resta y el redondeo
    int numColumna;
    //Creo objeto de la clase cañon
    Cañon cañon = new Cañon();
    //Creo objeto de la clase burbuja
    BubbleShooter bubbleShooter = new BubbleShooter();
    //Division para casillas
    float divCasilla;
    int ejeYBurbuja = cañon.ALTO_PANTALLA;
    double ejeXBurbuja = cañon.mitadAnchoPantalla;
    
    char indicadorFilaLibre = '0';
    // -------------------------Burbuja del cañon
    Circle burbuja = new Circle(cañon.mitadAnchoPantalla,cañon.ALTO_PANTALLA, 5);
    //-----------------------------------------------------Animacion Burbuja
        Timeline animationBurbuja = new Timeline(
            new KeyFrame(Duration.seconds(0.017), new EventHandler<ActionEvent>() {
               
               public void handle(ActionEvent ae) {
                   burbuja.setCenterY(ejeYBurbuja);
                   burbuja.setCenterX(ejeXBurbuja);
                   divCasilla = (float)(cañon.calAngulo()/61);
                   numColumna = Math.round(divCasilla);
                   System.out.print("Lanzamiento a la casilla:");
                   System.out.println(numColumna);
                   //Llamadas a los metodos para colocar las burbujas
                   cañon.comprobarCasilla(numColumna,cañon.sumFila);
                   System.out.print("Se a reiniciado:");
                    System.out.println(contadorReinicio);
                   pararAnimacion();
                   
                                    
               }
               })
        );
    
    public void start(Stage primaryStage) {
        Pane root = new Pane();
        Scene scene = new Scene(root, cañon.ANCHO_PANTALLA, cañon.ALTO_PANTALLA);
        primaryStage.setTitle("Main Pablo");
        primaryStage.setScene(scene);
        primaryStage.show();
                
        // -------------------------Linea
        Line line = new Line(cañon.mitadAnchoPantalla, cañon.ALTO_PANTALLA, cañon.calAngulo(), 0);
        
        //---------------------------------------Lineas para las casillas
        Line lineCasilla1 = new Line(35, 0, 35, cañon.ALTO_PANTALLA/2);
        Line lineCasilla2 = new Line(90, 0, 90, cañon.ALTO_PANTALLA/2);
        Line lineCasilla3 = new Line(150, 0, 150, cañon.ALTO_PANTALLA/2);
        Line lineCasilla4 = new Line(215, 0, 215, cañon.ALTO_PANTALLA/2);
        Line lineCasilla5 = new Line(270, 0, 270, cañon.ALTO_PANTALLA/2);
        Line lineCasilla6 = new Line(335, 0, 335, cañon.ALTO_PANTALLA/2);
        //------------------------------------------------- Animacion linea
        Timeline animationLine = new Timeline(
            new KeyFrame(Duration.seconds(0.017), new EventHandler<ActionEvent>() {
               public void handle(ActionEvent ae) {
                line.setEndX(cañon.calAngulo());
                //Generar burbuja aleatoria
                if (cañon.estadoColorBurbuja == '0'){
                // Color Burbuja
                switch(cañon.colorBurbujas()){
                    case 'r':
                       burbuja.setFill(javafx.scene.paint.Color.RED);
                       cañon.estadoColorBurbuja = 'r';
                    break;
                    case 'b':
                        burbuja.setFill(javafx.scene.paint.Color.BLUE);
                        cañon.estadoColorBurbuja = 'b';
                    break;
                    case 'g':
                        burbuja.setFill(javafx.scene.paint.Color.GREEN);
                        cañon.estadoColorBurbuja = 'g';
                    break;
                    case 'y':
                        burbuja.setFill(javafx.scene.paint.Color.YELLOW);
                        cañon.estadoColorBurbuja = 'y';
                    break;
                    case 'p':
                        burbuja.setFill(javafx.scene.paint.Color.PURPLE);
                        cañon.estadoColorBurbuja = 'p';
                    break;
               }
        }
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
               case R:
                   cañon.numPartida = false;
                   contadorReinicio++;
                   System.out.print("Se a reiniciado:");
                   System.out.println(contadorReinicio);
                   cañon.generarPartida();
                break;
                
           }
        });
        
        
        
        //Animacion linea
        animationLine.setCycleCount(Timeline.INDEFINITE);
        animationLine.play();
        //Animacion Burbuja
        animationBurbuja.setCycleCount(Timeline.INDEFINITE);
        // Mostrar matriz
        bubbleShooter.mostrarTablero();
        root.getChildren().addAll(line, burbuja, lineCasilla1, lineCasilla2, lineCasilla3, lineCasilla4, lineCasilla5, lineCasilla6);
        cañon.generarPartida();

        
    }
    public void pararAnimacion(){
        animationBurbuja.stop();
        
    }
    
    /*
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
