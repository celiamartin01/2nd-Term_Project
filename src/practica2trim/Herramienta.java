
package practica2trim;

import java.util.ArrayList;

public class Herramienta {
    String tipo;
    ArrayList<Posicion> posicion = new ArrayList<Posicion>();
    
    public Herramienta(String tipo, Posicion posicionHerr){                                                                 // Constructor de herramientas que sólo ocupan 1 posición
        this.tipo = tipo;
        this.posicion.add(posicionHerr);
    }
    
    public Herramienta(String tipo, Posicion posicionHerr, Posicion posicionHerr2){                                         // Constructor de herramientas que ocupan 2 posiciones
        this.tipo = tipo;
        this.posicion.add(posicionHerr);
        this.posicion.add(posicionHerr2);
    }
    
    public Herramienta(String tipo, Posicion posicionHerr, Posicion posicionHerr2, Posicion posicionHerr3){                 // Constructor de herramientas que ocupan 3 posiciones
        this.tipo = tipo;
        this.posicion.add(posicionHerr);
        this.posicion.add(posicionHerr2);
        this.posicion.add(posicionHerr3);
    }
}
