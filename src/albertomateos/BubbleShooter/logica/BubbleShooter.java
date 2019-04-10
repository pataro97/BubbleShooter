/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package albertomateos.BubbleShooter.logica;




/**
 *
 * @author PC07
 */
public class BubbleShooter {
    //BubbleShooter bubbleshooter = new BubbleShooter();
   
    public char[][] matrizTablero = new char[7][7];
    
    /**
     *
     */
    public BubbleShooter() {
        for(int y=0; y<7; y++) {
            for(int x=0; x<7; x++) {
                matrizTablero[x][y] = '0';
    
            }
        }
    }

public void ponerBola(int x, int y, char bola) {
       matrizTablero[x][y] = bola;  
    
    }
// 


    /**
     *
     */
    public void mostrarTablero() {
        for(int y=0; y<7; y++) {
            for(int x=0; x<7; x++) {
                System.out.print(matrizTablero[x][y]);
            }
            System.out.println();
        }       
    }   
}
    
