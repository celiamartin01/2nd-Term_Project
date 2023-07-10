
package practica2trim;

import java.util.Scanner;

public class Practica2Trim {

    public static void main(String[] args) {
        Tablero tablero = new Tablero();
        
        Scanner teclado = new Scanner (System.in);
        System.out.println("Elija un nivel de dificultad:\n1. Fácil\n2. Intermedio"
                + "\n3. Difícil");
        tablero.setDificultad(teclado.nextInt());
        System.out.println("");
        
        tablero.crearTablero();
        tablero.actualizarTablero(tablero);
        tablero.mostrarTablero();
        System.out.println("");
        
        
        int contador = 0;
        do{
            tablero.moverJugador();
            contador++;
            
        }
        while(contador < 30);
        if (contador == 30){
                System.out.println("¡GAME OVER! Demasiados movimientos. Has perdido");
            }
    }
    
}
