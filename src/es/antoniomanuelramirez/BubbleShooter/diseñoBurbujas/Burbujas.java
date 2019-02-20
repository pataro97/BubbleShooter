package es.antoniomanuelramirez.BubbleShooter.diseñoBurbujas;

public class Burbujas {
    public char[][] matrizTablero = new char[7][7];
    
    public Burbujas() {
        for(int y=0; y<7; y++) {
            for(int x=0; x<7; x++) {
                matrizTablero[x][y] = '0';
            }
        }
    }
    
    public void mostrarTablero() {
        for(int y=0; y<7; y++) {
            for(int x=0; x<7; x++) {
                System.out.print(matrizTablero[x][y]);
            }
            System.out.println();
        }       
    }
    
    public void ponerBurbuja(int x, int y, char burbuja) {
        matrizTablero[x][y]= burbuja;
    }
}   

