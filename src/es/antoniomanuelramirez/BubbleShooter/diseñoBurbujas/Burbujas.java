package es.antoniomanuelramirez.BubbleShooter.diseñoBurbujas;



public class Burbujas {
//    TableroView tableroView = new TableroView();
    public char[][] matrizTablero = new char[5][5];
    
    public Burbujas() {
        for(int y=0; y<4; y++) {
            for(int x=0; x<5; x++) {
                matrizTablero[x][y] = '0';
            }
        }
    }
    
    public void mostrarTablero() {
        for(int y=0; y<4; y++) {
            for(int x=0; x<5; x++) {
                System.out.print(matrizTablero[x][y]);
            }
            System.out.println();
        }       
    }
    
    public void ponerBurbuja(int x, int y, char burbuja) {
        matrizTablero[x][y]= burbuja;
    }
}   

