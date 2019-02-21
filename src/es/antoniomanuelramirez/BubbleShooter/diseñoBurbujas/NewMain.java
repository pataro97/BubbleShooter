package es.antoniomanuelramirez.BubbleShooter.diseñoBurbujas;

public class NewMain {
    
    public static void main(String[] args){
        Burbujas burbujas = new Burbujas();
        burbujas.mostrarTablero();
        System.out.println("");
        
        burbujas.ponerBurbuja(0, 0, 'B');
        burbujas.ponerBurbuja(1, 0, 'R');
        burbujas.ponerBurbuja(2, 0, 'Y');
        burbujas.ponerBurbuja(3, 0, 'P');
        burbujas.mostrarTablero();
    }
}
