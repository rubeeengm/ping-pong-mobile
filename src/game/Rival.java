package game;

import java.util.Random;

public class Rival {
    Tablero t;
    public boolean terminar = true;
    public boolean mitiro = false;
    
    public Rival(Tablero tablero){
        this.t = tablero;
    }
    
    public void pensando(){
        for(int i = 0; i<10000000; i++);
    }
    
    //para ver si ya se jugo en el centro, y si no, tirar ahi
    public int comprobarCentro() {
        if (t.getPosicionTablero(1,1) == 'n' && mitiro == false) {
            pensando();
            //t.asignarPosicion(1,1,'o');
            mitiro = true;
            
            return 5;
        }
        
        else
            return 0;
    }
    
    //Genera un numero para tirar de forma aleatoria
    public int aleatorio() {
        int jugada = 0;
        Random rnd = new Random();
        boolean salir = false;
        
        if(mitiro == false){
            do{
                int casilla = (int) (rnd.nextDouble()*10);
            
                if(casilla > 0 && casilla < 10){
                    switch(casilla){
                        case 1:
                            if(t.getPosicionTablero(0,0) == 'n'){
                                salir = true;
                                jugada = casilla;
                            }
                        break;  
                        
                        case 2:
                            if(t.getPosicionTablero(0,1) == 'n'){
                                salir = true;
                                jugada = casilla;
                            }
                        break;
                        
                        case 3:
                            if(t.getPosicionTablero(0,2) == 'n'){
                                salir = true;
                                jugada = casilla;
                            }
                        break;
                           
                        case 4:
                            if(t.getPosicionTablero(1,0) == 'n'){
                                salir = true;
                                jugada = casilla;
                            }
                        break;
                        
                        case 5:
                            if(t.getPosicionTablero(1,1) == 'n'){
                                salir = true;
                                jugada = casilla;
                            }  
                        break;
                            
                        case 6:
                            if(t.getPosicionTablero(1,2) == 'n'){
                                salir = true;
                             jugada = casilla;
                            }
                      break;
                        
                        case 7:
                            if(t.getPosicionTablero(2,0) == 'n'){
                                salir = true;
                                jugada = casilla;
                            }
                        break;
                        
                        case 8:
                            if(t.getPosicionTablero(2,1) == 'n'){
                                salir = true;
                                jugada = casilla;
                            }
                        break;
                        
                        case 9:
                            if(t.getPosicionTablero(2,2) == 'n'){
                                salir = true;
                                jugada = casilla;
                            }
                        break;
                    }
                }
            }while(salir == false);
            
            mitiro = true;
        }

        return jugada;
    }
    

        //para ver si el jugador tiene alguna jugada de gane en horizontal
        private int comprobarPeligroH() {
            //primera fila
            if (t.tablero[0][0] == 'x' && t.tablero[0][1] == 'x' && mitiro == false && t.tablero[0][2] == 'n') {
                pensando();
                t.asignarPosicion(0, 2, 'o');
                mitiro = true;
                
                return 3;
            }

            if (t.tablero[0][0] == 'x' && t.tablero[0][2] == 'x' && mitiro == false && t.tablero[0][1] == 'n') {
                pensando();
                t.asignarPosicion(0, 1, 'o');
                mitiro = true;
                
                return 2;
            }

            if (t.tablero[0][1] == 'x' && t.tablero[0][2] == 'x' && mitiro == false && t.tablero[0][0] == 'n') {
                pensando();
                t.asignarPosicion(0, 0, 'o');
                mitiro = true;
                
                return 1;
            }

            //segunda fila
            if (t.tablero[1][0] == 'x' && t.tablero[1][1] == 'x' && mitiro == false && t.tablero[1][2] == 'n') {
                pensando();
                t.asignarPosicion(1, 2, 'o');
                mitiro = true;
                
                return 6;
            }

            if (t.tablero[1][0] == 'x' && t.tablero[1][2] == 'x' && mitiro == false && t.tablero[1][1] == 'n') {
                pensando();
                t.asignarPosicion(1, 1, 'o');
                mitiro = true;
                
                return 5;
            }

            if (t.tablero[1][1] == 'x' && t.tablero[1][2] == 'x' && mitiro == false && t.tablero[1][0] == 'n') {
                pensando();
                t.asignarPosicion(1, 0, 'o');
                mitiro = true;
                
                return 4;
            }

            //tercera fila
            if (t.tablero[2][0] == 'x' && t.tablero[2][1] == 'x' && mitiro == false && t.tablero[2][2] == 'n') {
                pensando();
                t.asignarPosicion(2, 2, 'o');
                mitiro = true;
                //System.out.println("Comprobar peligro h");
                return 9;
            }

            if (t.tablero[2][0] == 'x' && t.tablero[2][2] == 'x' && mitiro == false && t.tablero[2][1] == 'n') {
                pensando();
                t.asignarPosicion(2, 1, 'o');
                mitiro = true;
                
                return 8;
            }

            if (t.tablero[2][1] == 'x' && t.tablero[2][2] == 'x' && mitiro == false && t.tablero[2][0] == 'n') {
                pensando();
                t.asignarPosicion(2, 0, 'o');
                mitiro = true;
                
                return 7;
            }
            
            else
                return 0;
        }

        private int comprobarPeligroV() {
            //primera columna
            if (t.tablero[0][0] == 'x' && t.tablero[1][0] == 'x' && mitiro == false && t.tablero[2][0] == 'n') {
                pensando();
                t.asignarPosicion(2, 0, 'o');
                mitiro = true;
                
                return 7;
            }

            if (t.tablero[0][0] == 'x' && t.tablero[2][0] == 'x' && mitiro == false && t.tablero[1][0] == 'n') {
                pensando();
                t.asignarPosicion(1, 0, 'o');
                mitiro = true;
                
                return 4;
            }

            if (t.tablero[1][0] == 'x' && t.tablero[2][0] == 'x' && mitiro == false && t.tablero[0][0] == 'n') {
                pensando();
                t.asignarPosicion(0, 0, 'o');
                mitiro = true;
                
                return 1;
            }

            //segunda columna
            if (t.tablero[0][1] == 'x' && t.tablero[1][1] == 'x' && mitiro == false && t.tablero[2][1] == 'n') {
                pensando();
                t.asignarPosicion(2, 1, 'o');
                mitiro = true;
                
                return 8;
            }

            if (t.tablero[0][1] == 'x' && t.tablero[2][1] == 'x' && mitiro == false && t.tablero[1][1] == 'n') {
                pensando();
                t.asignarPosicion(1, 1, 'o');
                mitiro = true;
                
                return 5;
            }

            if (t.tablero[1][1] == 'x' && t.tablero[2][1] == 'x' && mitiro == false && t.tablero[0][1] == 'n') {
                pensando();
                t.asignarPosicion(0, 1, 'o');
                mitiro = true;
                
                return 2;
            }

            //tercera columna
            if (t.tablero[0][2] == 'x' && t.tablero[1][2] == 'x' && mitiro == false && t.tablero[2][2] == 'n') {
                pensando();
                t.asignarPosicion(2, 2, 'o');
                mitiro = true;
                //System.out.println("Comprobar peligro v");
                return 9;
            }

            if (t.tablero[0][2] == 'x' && t.tablero[2][2] == 'x' && mitiro == false && t.tablero[1][2] == 'n') {
                pensando();
                t.asignarPosicion(1, 2, 'o');
                mitiro = true;
                
                return 6;
            }

            if (t.tablero[1][2] == 'x' && t.tablero[2][2] == 'x' && mitiro == false && t.tablero[0][2] == 'n') {
                pensando();
                t.asignarPosicion(0, 2, 'o');
                mitiro = true;
                
                return 3;
            }
            
            else
                return 0;
        }

        //para ver si el jugador tiene alguna jugada de gane en vertical
        //suele estar demas porque en realidad siempre se evita este peligro...
        ///pero por si acaso D:
        private int comprobarPeligroD() {
            //primera diagonal: \
            if (t.tablero[0][0] == 'x' && t.tablero[1][1] == 'x' && mitiro == false && t.tablero[2][2] == 'n') {
                pensando();
                t.asignarPosicion(2, 2, 'o');
                mitiro = true;
                //System.out.println("Comprobar peligro d");
                
                return 9;
            }

            if (t.tablero[0][0] == 'x' && t.tablero[2][2] == 'x' && mitiro == false && t.tablero[1][1] == 'n') {
                pensando();
                t.asignarPosicion(1, 1, 'o');
                mitiro = true;
                
                return 5;
            }

            if (t.tablero[1][1] == 'x' && t.tablero[2][2] == 'x' && mitiro == false && t.tablero[0][0] == 'n') {
                pensando();
                t.asignarPosicion(0, 0, 'o');
                mitiro = true;
                
                return 1;
            }

            //segunda diagonal /
            if (t.tablero[0][2] == 'x' && t.tablero[1][1] == 'x' && mitiro == false && t.tablero[2][0] == 'n') {
                pensando();
                t.asignarPosicion(2, 0, 'o');
                mitiro = true;
                
                return 7;
            }

            if (t.tablero[0][2] == 'x' && t.tablero[2][0] == 'x' && mitiro == false && t.tablero[1][1] == 'n') {
                pensando();
                t.asignarPosicion(1, 1, 'o');
                mitiro = true;
                
                return 5;
            }

            if (t.tablero[1][1] == 'x' && t.tablero[2][0] == 'x' && mitiro == false && t.tablero[0][2] == 'n') {
                pensando();
                t.asignarPosicion(0, 2, 'o');
                mitiro = true;
                
                return 3;
            }
            
            else
                return 0;
        }

        public int comprobarPeligro() {
            int jugada = 0;
            
            jugada = comprobarPeligroH();
           
            if(jugada == 0){
                jugada = comprobarPeligroV();
               
                if(jugada == 0){
                    jugada = comprobarPeligroD();
                }
            }
            
            return jugada;
        }

        private int puedoGanarH() {
            //primera fila
            if (t.tablero[0][0] == 'o' && t.tablero[0][1] == 'o' && mitiro == false && t.tablero[0][2] == 'n') {
                pensando();
                t.asignarPosicion(0, 2, 'o');
                mitiro = true;
                
                return 3;
            }

            if (t.tablero[0][0] == 'o' && t.tablero[0][2] == 'o' && mitiro == false && t.tablero[0][1] == 'n') {
                pensando();
                t.asignarPosicion(0, 1, 'o');
                mitiro = true;
                
                return 2;
            }

            if (t.tablero[0][1] == 'o' && t.tablero[0][2] == 'o' && mitiro == false && t.tablero[0][0] == 'n') {
                pensando();
                t.asignarPosicion(0, 0, 'o');
                mitiro = true;
                
                return 1;
            }

            //segunda fila
            if (t.tablero[1][0] == 'o' && t.tablero[1][1] == 'o' && mitiro == false && t.tablero[1][2] == 'n') {
                pensando();
                t.asignarPosicion(1, 2, 'o');
                mitiro = true;
                
                return 6;
            }

            if (t.tablero[1][0] == 'o' && t.tablero[1][2] == 'o' && mitiro == false && t.tablero[1][1] == 'n') {
                pensando();
                t.asignarPosicion(1, 1, 'o');
                mitiro = true;
                
                return 5;
            }

            if (t.tablero[1][1] == 'o' && t.tablero[1][2] == 'o' && mitiro == false && t.tablero[1][0] == 'n') {
                pensando();
                t.asignarPosicion(1, 0, 'o');
                mitiro = true;
                
                return 4;
            }
            
            //tercera fila
            if (t.tablero[2][0] == 'o' && t.tablero[2][1] == 'o' && mitiro == false && t.tablero[2][2] == 'n') {
                pensando();
                t.asignarPosicion(2, 2, 'o');
                mitiro = true;
                //System.out.println("ganar h");
                return 9;
            }

            if (t.tablero[2][0] == 'o' && t.tablero[2][2] == 'o' && mitiro == false && t.tablero[2][1] == 'n') {
                pensando();
                t.asignarPosicion(2, 1, 'o');
                mitiro = true;
                
                return 8;
            }

            if (t.tablero[2][1] == 'o' && t.tablero[2][2] == 'o' && mitiro == false && t.tablero[2][0] == 'n') {
                pensando();
                t.asignarPosicion(2, 0, 'o');
                mitiro = true;
                
                return 7;
            }
            
            else
                return 0;
        }

        private int puedoGanarV() {
            //primera columna
            if (t.tablero[0][0] == 'o' && t.tablero[1][0] == 'o' && mitiro == false && t.tablero[2][0] == 'n') {
                pensando();
                t.asignarPosicion(2, 0, 'o');
                mitiro = true;
                
                return 7;
            }

            if (t.tablero[0][0] == 'o' && t.tablero[2][0] == 'o' && mitiro == false && t.tablero[1][0] == 'n') {
                pensando();
                t.asignarPosicion(1, 0, 'o');
                mitiro = true;
                
                return 4;
            }

            if (t.tablero[1][0] == 'o' && t.tablero[2][0] == 'o' && mitiro == false && t.tablero[0][0] == 'n') {
                pensando();
                t.asignarPosicion(0, 0, 'o');
                mitiro = true;
                
                return 1;
            }

            //segunda columna
            if (t.tablero[0][1] == 'o' && t.tablero[1][1] == 'o' && mitiro == false && t.tablero[2][1] == 'n') {
                pensando();
                t.asignarPosicion(2, 1, 'o');
                mitiro = true;
                
                return 8;
            }

            if (t.tablero[0][1] == 'o' && t.tablero[2][1] == 'o' && mitiro == false && t.tablero[1][1] == 'n') {
                pensando();
                t.asignarPosicion(1, 1, 'o');
                mitiro = true;
                
                return 5;
            }

            if (t.tablero[1][1] == 'o' && t.tablero[2][1] == 'o' && mitiro == false && t.tablero[0][1] == 'n') {
                pensando();
                t.asignarPosicion(0, 1, 'o');
                mitiro = true;
                
                return 2;
            }

            //tercera columna
            if (t.tablero[0][2] == 'o' && t.tablero[1][2] == 'o' && mitiro == false && t.tablero[2][2] == 'n') {
                pensando();
                t.asignarPosicion(2, 2, 'o');
                mitiro = true;
                //System.out.println("ganar v");
                return 9;
            }

            if (t.tablero[0][2] == 'o' && t.tablero[2][2] == 'o' && mitiro == false && t.tablero[1][2] == 'n') {
                pensando();
                t.asignarPosicion(1, 2, 'o');
                mitiro = true;
                
                return 6;
            }

            if (t.tablero[1][2] == 'o' && t.tablero[2][2] == 'o' && mitiro == false && t.tablero[0][2] == 'n') {
                pensando();
                t.asignarPosicion(0, 2, 'o');
                mitiro = true;
                
                return 3;
            }
            
            else
                return 0;
        }

        private int puedoGanarD() {
            //primera diagonal: \
            if (t.tablero[0][0] == 'o' && t.tablero[1][1] == 'o' && mitiro == false && t.tablero[2][2] == 'n') {
                pensando();
                t.asignarPosicion(2, 2, 'o');
                mitiro = true;
                //System.out.println("ganar d");
                return 9;
            }

            if (t.tablero[0][0] == 'o' && t.tablero[2][2] == 'o' && mitiro == false && t.tablero[1][1] == 'n') {
                pensando();
                t.asignarPosicion(1, 1, 'o');
                mitiro = true;
                
                return 5;
            }

            if (t.tablero[1][1] == 'o' && t.tablero[2][2] == 'o' && mitiro == false && t.tablero[0][0] == 'n') {
                pensando();
                t.asignarPosicion(0, 0, 'o');
                mitiro = true;
                
                return 1;
            }

            //segunda diagonal /
            if (t.tablero[0][2] == 'o' && t.tablero[1][1] == 'o' && mitiro == false && t.tablero[2][0] == 'n') {
                pensando();
                t.asignarPosicion(2, 0, 'o');
                mitiro = true;
                
                return 7;
            }

            if (t.tablero[0][2] == 'o' && t.tablero[2][0] == 'o' && mitiro == false && t.tablero[1][1] == 'n') {
                pensando();
                t.asignarPosicion(1, 1, 'o');
                mitiro = true;
                
                return 5;
            }

            if (t.tablero[1][1] == 'o' && t.tablero[2][0] == 'o' && mitiro == false && t.tablero[0][2] == 'n') {
                pensando();
                t.asignarPosicion(0, 2, 'o');
                mitiro = true;
                
                return 3;
            }
            
            else
                return 0;
        }

    //Metodo que comprueba si puede ganar de forma vertical, horizontal o diagonal,
    //acompleta la jugada cuando le hace falta una casilla por elegir
    public int puedoGanar() {
        int jugada = 0;
            
        jugada = puedoGanarH();
           
        if(jugada == 0){
            jugada = puedoGanarV();
               
            if(jugada == 0){
                jugada = puedoGanarD();
            }
        }
            
        return jugada;
    }
}