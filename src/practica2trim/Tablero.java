
package practica2trim;

import java.util.ArrayList;
import java.util.Scanner;

public class Tablero {
   // Tablero tablero = new Tablero();
    
    String[][] coordenadas = new String[10][10];
    
    int pasap1 = (int) (Math.floor(Math.random()*10));                          // PASAPORTE
    int pasap2 = (int) (Math.floor(Math.random()*10));
    Posicion posPasap = new Posicion(pasap1, pasap2); 
    Herramienta pasaporte = new Herramienta("P ", posPasap);
    
    int ali1 = (int) (Math.floor(Math.random()*9));                             // ALICATES
    int ali2 = (int) (Math.floor(Math.random()*9));
    Posicion posAli = new Posicion(ali1, ali2);    
    Herramienta alicates = new Herramienta ("A ", posAli);
    
    int uni1 = (int) (Math.floor(Math.random()*8));                             // UNIFORME
    int uni2 = (int) (Math.floor(Math.random()*8));
    Posicion posUni = new Posicion(uni1, uni2);
    Herramienta uniforme = new Herramienta ("U ", posUni);
    
    ArrayList<Guardia> guardias = new ArrayList<Guardia>();
    int posGuard1 = (int) (Math.floor(Math.random()*10));       
    int posGuard2 = (int) (Math.floor(Math.random()*10));
    
    int posJug1 = (int) (Math.floor(Math.random()*10));       
    int posJug2 = (int) (Math.floor(Math.random()*10));
    Posicion posJugador = new Posicion(posJug1, posJug2);
    Jugador jug = new Jugador(posJugador);
    
    
    private int dificultad;
    Scanner teclado = new Scanner(System.in);
    
    int posJug1Aux;
    int posJug2Aux;
    
    
    
    public void crearTablero(){
        for ( int i = 0; i < coordenadas.length; i++){                          // Inicializo el tablero vacío, metiendo los valores en el arrayList y mostrándolos
            for (int k = 0; k <coordenadas[i].length; k++){
                coordenadas[k][i] = "x ";
            }
        }
    }
    
    
    public void actualizarTablero(Tablero tab){
        comprobarPasaporte();
        comprobarAlicates();      
        comprobarUniforme();
        comprobarJugador();
        desplegarGuardias(tab);
    }
    
    
    public void mostrarTablero(){
        System.out.println("--------------------");
        
        for ( int i = 0; i < coordenadas.length; i++){                          
            for (int k = 0; k <coordenadas[i].length; k++){
                System.out.print(coordenadas[k][i]);
            }
            System.out.println("");
        }
        
        System.out.println("--------------------");
    }
    
    
    
    
    public void comprobarPasaporte(){
        int cont = 0;
        while(cont == 0){ 
            if (casillaVacia(pasap1, pasap2)){                                
                
                pasaporte.posicion.add(posPasap);
                aniadirPasaporte();
                cont++;
            }      
            else{
                    pasap1 = (int) (Math.floor(Math.random()*10));                
                    pasap2 = (int) (Math.floor(Math.random()*10));
            }
        } 
    }
    
    
    
    public void aniadirPasaporte(){
        for (int i = 0; i < coordenadas.length; i++){
            for (int k = 0; k <coordenadas[i].length; k++){

                if (k == pasap1 && i == pasap2){                            
                    coordenadas[k][i] = pasaporte.tipo;
                    i = (coordenadas.length)-1;                              
                }
            }
        }
    }
    
    
    
    public void comprobarAlicates(){            
        int cont = 0;                                                           
        while(cont == 0){       
            
            if (casillaVacia(ali1, ali2) && casillaVacia(ali1+1, ali2)){       
                aniadirAlicates();
                cont++;
            }  

            else{
                ali1 = (int) (Math.floor(Math.random()*9));                
                ali2 = (int) (Math.floor(Math.random()*9));
            }
        } 
    }
    
    
    public void aniadirAlicates(){
        for (int i = 0; i < coordenadas.length; i++){
            for (int k = 0; k <coordenadas[i].length; k++){

                if (k == ali1 && i == ali2){
                        coordenadas[k][i] = alicates.tipo;
                        coordenadas[k+1][i] = alicates.tipo;
                        i = (coordenadas.length)-1;
                }
            }
        }
        
    }
    
    
    
    
    public void comprobarUniforme(){
        int cont = 0;                                                           
        while(cont == 0){                            
            
            if (casillaVacia(uni1, uni2) && casillaVacia(uni1+1, uni2) && casillaVacia(uni1+2, uni2)){       
                aniadirUniforme();
                cont++;
            }  

            else{
                uni1 = (int) (Math.floor(Math.random()*10));                
                uni2 = (int) (Math.floor(Math.random()*10));
            }
        } 
    }
    
    
    public void aniadirUniforme(){
        
        for (int i = 0; i < coordenadas.length; i++){
            for (int k = 0; k <coordenadas[i].length; k++){

                if (k == uni1 && i == uni2){
                        coordenadas[k][i] = uniforme.tipo;
                        coordenadas[k+1][i] = uniforme.tipo;
                        coordenadas[k+2][i] = uniforme.tipo;
                        i = (coordenadas.length)-1;
                }
            }
        }
    }
    
    
    
    public void desplegarGuardias(Tablero tab){
        
       switch (dificultad){
            case 1:
                Guardia pepe = new Guardia(posGuard1, posGuard2, tab);          // Creamos un nuevo guardia, que pasamos por parámetro al método nuevoGuardia
                nuevoGuardia(pepe);
                guardias.add(pepe);
                
            break;

            
            case 2:
                Guardia manolo = new Guardia(posGuard1, posGuard2, tab);        // Introduzco todos los guardias con las mismas posiciones, pero al entrar en el método nuevoGuardia
                nuevoGuardia(manolo);                                           // se verá que ya están ocupadas y se generarán otras nuevas
                guardias.add (manolo);
                
                Guardia lorena = new Guardia(posGuard1, posGuard2, tab);
                nuevoGuardia(lorena);
                guardias.add (lorena);
                
            break;
            
            case 3:
                Guardia julia = new Guardia(posGuard1, posGuard2, tab);
                nuevoGuardia(julia);
                guardias.add(julia);
                
                Guardia celia = new Guardia(posGuard1, posGuard2, tab);
                nuevoGuardia(celia);
                guardias.add(celia);
                
                Guardia samu = new Guardia(posGuard1, posGuard2, tab);
                nuevoGuardia(samu);
                guardias.add(samu);
            break;
       }
    }
    
    
   
    public void nuevoGuardia(Guardia guardia){
        int i = 0;
        while(i == 0){                                                          // Comprobamos que las casillas en las que se quiere introducir al guardia están vacías
            if (casillaVacia(posGuard1, posGuard2)){                            // Si no lo están, se crean nuevas posiciones y se mantiene en el while, haciendo de nuevo la comprobación
                guardias.add(guardia);                                          // Si lo están, se añade al guardia (pasado por parámetro) en el array y en el tablero

                introducirGuardiaTablero(guardia);
                
                i++;
            }
            else{
                posGuard1 = (int) (Math.floor(Math.random()*10));       
                posGuard2 = (int) (Math.floor(Math.random()*10));
            }
        }
    }
    
    
    public void introducirGuardiaTablero(Guardia guardia){
        for (int i = 0; i < coordenadas.length; i++){
            for (int k = 0; k <coordenadas[i].length; k++){

                if (k == posGuard1 && i == posGuard2){                            
                    coordenadas[k][i] = "G ";
                  //  guardia.run();
                    i = (coordenadas.length)-1;                              
                }
            }
        }
        
    }
    
    
    
    public void comprobarJugador(){
        int cont = 0;
        while(cont == 0){ 
            if (casillaVacia(posJug1, posJug2)){    
                
                desplegarJugador();
                cont++;
            }      
            else{
                posJug1 = (int) (Math.floor(Math.random()*10));                
                posJug2 = (int) (Math.floor(Math.random()*10));
            }
        } 
    }
    
    
    
    public void desplegarJugador(){
        
        for (int i = 0; i < coordenadas.length; i++){
            for (int k = 0; k <coordenadas[i].length; k++){
                
                    if (k == posJug1 && i == posJug2){                            
                        coordenadas[k][i] = "O ";
                        i = (coordenadas.length)-1;                              
                    }
            }
        }
        
    }
    
    
    public boolean casillaVacia(int x, int y){       
        boolean vacia = false;
        if ("x ".equals(coordenadas[x][y])){
            vacia = true;
        }
        
        return vacia;
    }
    
    
    
    
    
    
    public void moverJugador(){                                                 
        String mov = teclado.next();
        
        switch (mov){
            case "w": 
                posJug2 = posJug2-1;
                if (pisaHerramienta()){
                    posJug1Aux = posJug1;
                    posJug2Aux = posJug2+1;
                    piedraPapelTijeras();
                }
                else{
                    coordenadas[posJug1][posJug2] = "O ";
                    coordenadas[posJug1][posJug2+1] = "x ";
                    
                    mostrarTablero();
                }
                
                if (chocaGuardia()){
                    System.out.println("GAME OVER. Te ha pillado un guardia");
                    System.exit(0);
                }

                System.out.println("");
            break;
            
            case "a":
                posJug1 = posJug1-1;
                if (pisaHerramienta()){
                    posJug1Aux = posJug1+1;
                    posJug2Aux = posJug2;
                    piedraPapelTijeras();
                    
                }
                else{
                    coordenadas[posJug1][posJug2] = "O ";
                    coordenadas[posJug1+1][posJug2] = "x ";
                    
                    mostrarTablero();
                }
                
                if (chocaGuardia()){
                    System.out.println("GAME OVER. Te ha pillado un guardia");
                    System.exit(0);
                }
     
                System.out.println("");
            break;
            
            case "s":
                posJug2 = posJug2+1;
                if (pisaHerramienta()){
                    posJug1Aux = posJug1;
                    posJug2Aux = posJug2-1;
                    piedraPapelTijeras();
                }
                else{
                    coordenadas[posJug1][posJug2] = "O ";
                    coordenadas[posJug1][posJug2-1] = "x ";
                    
                    mostrarTablero();
                }
                
                if (chocaGuardia()){
                    System.out.println("GAME OVER. Te ha pillado un guardia");
                    System.exit(0);
                }
                 
                System.out.println("");
            break;
            
            case "d": 
                posJug1 = posJug1+1;
                if (pisaHerramienta()){
                    posJug1Aux = posJug1-1;
                    posJug2Aux = posJug2;
                    piedraPapelTijeras();
                }
                else{
                    coordenadas[posJug1][posJug2] = "O ";
                    coordenadas[posJug1-1][posJug2] = "x ";
                    
                    mostrarTablero();
                }
                
                if (chocaGuardia()){
                    System.out.println("GAME OVER. Te ha pillado un guardia");
                    System.exit(0);
                }
                                 
                System.out.println("");
            break;
        }
    }
    
    
    
    
    
    public void piedraPapelTijeras(){
        System.out.println("¡Piedra, papel o tijeras! ¿Qué eliges?\n1. Piedra\n2. Papel\n3. Tijeras");
        int eleccJug = teclado.nextInt();
        int eleccIA = (int) (Math.floor((Math.random()*2))+1);                  // 1: piedra, 2: papel, 3: tijeras
                                                                                // (0, 1 y 2 IA)
        System.out.println(eleccIA);
        if (eleccJug == 1 && eleccIA == 1){
            while (eleccJug == eleccIA){
                System.out.println("Eliges PIEDRA. La IA elige PIEDRA");         
                System.out.println("¡Empate! Elige de nuevo");
                
                eleccIA = (int) (Math.floor((Math.random()*2))+1);
                System.out.println(eleccIA);
                eleccJug = teclado.nextInt();
            }
        }
        
        if (eleccJug == 1 && eleccIA == 2){
            System.out.println("Eliges PIEDRA. La IA elige PAPEL");
            System.out.println("¡Has perdido! Se te transportará a una casilla cercana");   
            jugadorPierde();
            
        }
        
        else if (eleccJug == 1 && eleccIA == 3){
            System.out.println("Eliges PIEDRA. La IA elige TIJERAS");
            System.out.println("¡Has ganado! La herramienta es tuya");
            
            if (esPasaporte()){
                jug.pasaporte = true;
                
                coordenadas[pasap1][pasap2] = "x ";
                coordenadas[posJug1Aux][posJug2Aux] = "x ";
                coordenadas[posJug1][posJug2] = "O ";
                mostrarTablero();
            }
            
            else if (esUniforme()){
                jug.uniforme = true;
                
                coordenadas[uni1][uni2] = "x ";
                coordenadas[uni1+1][uni2] = "x ";
                coordenadas[uni1+2][uni2] = "x ";
                
                coordenadas[posJug1Aux][posJug2Aux] = "x ";
                coordenadas[posJug1][posJug2] = "O ";
                mostrarTablero();
            }
            
            else if (esAlicate()){
                jug.alicates = true;
                
                coordenadas[ali1][ali2] = "x ";
                coordenadas[ali1+1][ali2] = "x ";
                
                coordenadas[posJug1Aux][posJug2Aux] = "x ";
                coordenadas[posJug1][posJug2] = "O ";
                mostrarTablero();
            }
             
            if (jug.alicates && jug.uniforme && jug.pasaporte){
                System.out.println("¡VICTORIA! ¡Tienes todas las herramientas y consigues escapar!");
                System.exit(0);
            }
            
        }
        
        else if (eleccJug == 2 && eleccIA == 2){
            while (eleccJug == eleccIA){
                System.out.println("Eliges PAPEL. La IA elige PAPEL");
                System.out.println("¡Empate! Elige de nuevo");
                
                eleccIA = (int) (Math.floor((Math.random()*2))+1);
                System.out.println(eleccIA);
                eleccJug = teclado.nextInt();
            }
        }
        
        if (eleccJug == 2 && eleccIA == 1){
            System.out.println("Eliges PAPEL. La IA elige PIEDRA");
            System.out.println("¡Has ganado! La herramienta es tuya");
            
            if (esPasaporte()){
                jug.pasaporte = true;
                
                coordenadas[pasap1][pasap2] = "x ";
                coordenadas[posJug1Aux][posJug2Aux] = "x ";
                coordenadas[posJug1][posJug2] = "O ";
                mostrarTablero();
            }
            
            else if (esUniforme()){
                jug.uniforme = true;
                
                coordenadas[uni1][uni2] = "x ";
                coordenadas[uni1+1][uni2] = "x ";
                coordenadas[uni1+2][uni2] = "x ";
                
                coordenadas[posJug1Aux][posJug2Aux] = "x ";
                coordenadas[posJug1][posJug2] = "O ";
                mostrarTablero();
            }
            
            else if (esAlicate()){
                jug.alicates = true;
                
                coordenadas[ali1][ali2] = "x ";
                coordenadas[ali1+1][ali2] = "x ";
                
                coordenadas[posJug1Aux][posJug2Aux] = "x ";
                coordenadas[posJug1][posJug2] = "O ";
                mostrarTablero();
            }
            
            if (jug.alicates && jug.uniforme && jug.pasaporte){
                System.out.println("¡VICTORIA! ¡Tienes todas las herramientas y consigues escapar!");
                System.exit(0);
            }
        }
        
        else if (eleccJug == 2 && eleccIA == 3){
            System.out.println("Eliges PAPEL. La IA elige TIJERAS");
            System.out.println("¡Has perdido! Se te transportará a una casilla cercana");
            jugadorPierde();
            
        }
        
        else if (eleccJug == 3 && eleccIA == 3){
            while (eleccJug == eleccIA){
                System.out.println("Eliges TIJERAS. La IA elige TIJERAS");
                System.out.println("¡Empate! Elige de nuevo");
                
                eleccIA = (int) (Math.floor(Math.random()*3));
                eleccIA = (int) (Math.floor((Math.random()*2))+1);
                eleccJug = teclado.nextInt();
            }
        }
        
        if (eleccJug == 3 && eleccIA == 1){
            System.out.println("Eliges TIJERAS. La IA elige PIEDRA");
            System.out.println("¡Has perdido! Se te transportará a una casilla cercana");
            jugadorPierde();
        }
        
        else if (eleccJug == 3 && eleccIA == 2){
            System.out.println("Eliges TIJERAS. La IA elige PAPEL");
            System.out.println("¡Has ganado! La herramienta es tuya");
            
            if (esPasaporte()){
                jug.pasaporte = true;
                
                coordenadas[pasap1][pasap2] = "x ";
                coordenadas[posJug1Aux][posJug2Aux] = "x ";
                coordenadas[posJug1][posJug2] = "O ";
                mostrarTablero();
                
            }
            
            else if (esUniforme()){
                jug.uniforme = true;
                
                coordenadas[uni1][uni2] = "x ";
                coordenadas[uni1+1][uni2] = "x ";
                coordenadas[uni1+2][uni2] = "x ";
                
                coordenadas[posJug1Aux][posJug2Aux] = "x ";
                coordenadas[posJug1][posJug2] = "O ";
                mostrarTablero();
            }
            
            else if (esAlicate()){
                jug.alicates = true;
                
                coordenadas[ali1][ali2] = "x ";
                coordenadas[ali1+1][ali2] = "x ";
                
                coordenadas[posJug1Aux][posJug2Aux] = "x ";
                coordenadas[posJug1][posJug2] = "O ";
                mostrarTablero();
            }
            
            if (jug.alicates && jug.uniforme && jug.pasaporte){
                System.out.println("¡VICTORIA! ¡Tienes todas las herramientas y consigues escapar!");
                System.exit(0);
            }
        }
    }
    
    
    
    public boolean esPasaporte(){
        boolean pasap = false;
        if ((coordenadas[posJug1][posJug2]) == pasaporte.tipo){
            pasap = true;
        }
        return pasap;
    }
    
    
    public boolean esUniforme(){
        boolean uni = false;
        if (coordenadas[posJug1][posJug2] == uniforme.tipo){
            uni = true;
        }
        return uni;
    }
    
    
    public boolean esAlicate(){
        boolean ali = false;
        if (coordenadas[posJug1][posJug2] == alicates.tipo){
            ali = true;
        }
        return ali;
    }
    
    
    
    public void jugadorPierde(){
        int contador = 0;
        
        while (contador == 0){
            int ale = (int) (Math.floor(Math.random()*3));                      // 0. Arriba, 1. Derecha, 2. Abajo, 3. Izquierda

            switch (ale){
                case 0: 
                    if (casillaVacia(posJug1, posJug2-1)){
                        coordenadas[posJug1Aux][posJug2Aux] = "x ";
                        posJug2 = posJug2-1;
                        coordenadas[posJug1][posJug2] = "O ";
                    //   coordenadas[posJug1][posJug2+2] = "x ";
                        mostrarTablero();
                        contador++;
                        break;
                    }
                    

                case 1:
                    if (casillaVacia(posJug1+1, posJug2)){
                        coordenadas[posJug1Aux][posJug2Aux] = "x ";
                        posJug1 = posJug1+1;
                        coordenadas[posJug1][posJug2] = "O ";
                    //    coordenadas[posJug1-2][posJug2] = "x ";
                        mostrarTablero();
                        contador++;
                        break;
                    }
                    

                case 2: 
                    if (casillaVacia(posJug1, posJug2+1)){
                        coordenadas[posJug1Aux][posJug2Aux] = "x ";
                        posJug2 = posJug2+1;
                        coordenadas[posJug1][posJug2] = "O ";
                    //    coordenadas[posGuard1][posGuard2-1] = "x ";
                        mostrarTablero();
                        contador++;
                        break;
                    }
                    

                case 3:
                    if (casillaVacia(posJug1-1, posJug2)){
                        coordenadas[posJug1Aux][posJug2Aux] = "x ";
                        posJug1 = posJug1-1;
                        coordenadas[posJug1][posJug2] = "O ";
                    //    coordenadas[posGuard1+1][posGuard2] = "x ";
                        mostrarTablero();
                        contador++;
                        break;
                    }
                    
            }
        }
        
    }
    
    
    
    
    public boolean pisaHerramienta(){
        boolean pisa = false;
        if ((coordenadas[posJug1][posJug2] == "P ") || (coordenadas[posJug1][posJug2] == "U ") ||
                    (coordenadas[posJug1][posJug2] == "A ")){
            pisa = true;
        }
        return pisa;
    }
    
    
    
    public void moverGuardia(){
        int ale = (int) (Math.floor(Math.random()*3));                          // 0. Arriba, 1. Derecha, 2. Abajo, 3. Izquierda

        switch (ale){
            case 0: 
                posGuard2 = posGuard2-1;
                coordenadas[posGuard1][posGuard2] = "G ";
                coordenadas[posGuard1][posGuard2+1] = "x ";
                mostrarTablero();
                break;

            case 1:
                posGuard1 = posGuard1+1;
                coordenadas[posGuard1][posGuard2] = "G ";
                coordenadas[posGuard1-1][posGuard2] = "x ";
                mostrarTablero();
                break;

            case 2: 
                posGuard2 = posGuard2+1;
                coordenadas[posGuard1][posGuard2] = "G ";
                coordenadas[posGuard1][posGuard2-1] = "x ";
                mostrarTablero();
                break;

            case 3:
                posGuard1 = posGuard1-1;
                coordenadas[posGuard1][posGuard2] = "G ";
                coordenadas[posGuard1+1][posGuard2] = "x ";
                mostrarTablero();
                break;
        }
            
    }
    
    // CONTROLAR QUE SÓLO SE META WASD EN MOVERJUGADOR() Y NÚMEROS DEL 1 AL 3 EN LA DIFICULTAD DEL JUEGO
    // CONTROLAR QUE NO TE PUEDDAS MOVER MÁS ALLÁ DE LOS LÍMITES DEL TABLERO
    
    
    
    
    /*
    public String posicion(String herr){
        String posicion = "";
        switch(herr){
            case "pasaporte":
                if ((pasap1 == 9 && pasap2 == 9)){
                    posicion = "esquinaDerInf";
                }
        }
        return posicion;
    }
    
    
    */
    
  /*  
    
    LAS HERRAMIENTAS NO PUEDEN SER ADYACENTES A NINGUNA OTRA, ARREGLAR
    
    public boolean nadaAdyacente(Herramienta herr){
        boolean ady = false;
        if (herr == pasaporte){
            if (!isLateral(pasaporte)){
                if ("x ".equals(coordenadas[pasap1+1][pasap2]) &&
                    "x ".equals(coordenadas[pasap1-1][pasap2]) &&
                    "x ".equals(coordenadas[pasap1][pasap2+1]) &&
                    "x ".equals(coordenadas[pasap1][pasap2-1])){
                    ady = true;
                }
                    
                }
            else{
                
            }
            
        }
        
        
        return ady;
    }

    
    public boolean isLateral(Herramienta herr){                                 // Compruebo si la herramienta está situada en algún extremo del tablero
        boolean lateral = false;
        if (herr == pasaporte){
            if (pasap1 == 0 || pasap1 == coordenadas.length || pasap2 == 0 ||
                    pasap2 == coordenadas.length ){
                lateral = true;
            }
        }
        
        return lateral;
    }

*/
    
    public int getDificultad(){
        return dificultad;
    }
    
    public void setDificultad(int dif){
        this.dificultad = dif;
    }
        
}
