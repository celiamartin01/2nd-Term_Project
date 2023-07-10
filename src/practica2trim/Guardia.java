
package practica2trim;

import java.util.ArrayList;

public class Guardia extends Thread{
    int x;
    int y;
    
    ArrayList<Guardia> guardias = new ArrayList<Guardia>();
    int posGuard1 = (int) (Math.floor(Math.random()*10));       
    int posGuard2 = (int) (Math.floor(Math.random()*10));
    
    Tablero tablero = new Tablero();
    
    public Guardia(int x, int y, Tablero tab){
        this.x = x;
        this.y = y;
        tablero = tab;
    }
    
    public synchronized void mover(){                         
        
        try{
            
            int i = 1;
            while (i != 0){
                tablero.moverGuardia();
                sleep(1000);
            }
            
            
        } 
        catch (InterruptedException e) {
            System.out.println(e.toString());
        }
        
        
    }
    
    @Override
    public void run(){
        mover();
    }
}
