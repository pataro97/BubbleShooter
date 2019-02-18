/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package albertomateos.BubbleShooter.logica;

import bubbleshooter.BubbleShooter;

/**
 *
 * @author PC07
 */
public class Logica {
    
    public static void main(String[] args) {
        BubbleShooter bubbleshooter= new BubbleShooter();
        bubbleshooter.mostrarTablero();
        bubbleshooter.ponerBola();
         System.out.println("");
         
         bubbleshooter.ponerbola(1,1,1,1,1,1,1,1,1);
         bubbleshooter.ponerbola(1,0,1,0,1,0,1,0,1);
         bubbleshooter.ponerbola(1,1,1,0,0,0,1,1,1);
         bubbleshooter.mostrarTablero();
    }
    int[][] matrizTablero = new int[9][9];
    public void mostrarTablero() {
        for(int i=0; i<9; i++) {
            for(int j=0; j<9; j++) {
                System.out.print(matrizTablero[i][j]);
        for(int y=0; y<9; y++) {
            for(int x=0; x<9; x++) {
                System.out.print(matrizTablero[x][y]);
                }
            System.out.println();
            }
        }
    }
}
     public void ponerFicha() {
        matrizTablero[9][9] = 1;
        matrizTablero[9][8] = 2;
     }
        
     public void ponerFicha(int x, int y, int jugador) {
        matrizTablero [x][y] = jugador;
     }
     }  


     

