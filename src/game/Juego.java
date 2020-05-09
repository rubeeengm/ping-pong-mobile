package game;

import java.io.IOException;
import javax.microedition.lcdui.Canvas;
import javax.microedition.lcdui.Font;
import javax.microedition.lcdui.Graphics;
import javax.microedition.lcdui.Image;

public class Juego extends Canvas{
    //Recuperamos las dimensiones de la pantalla del celular
    int x = getWidth();
    int y = getHeight();
    
    int x1 = x/3;
    int x2 = x1*2;
    
    int y1 = x/3;
    int y2 = x1*2;
    
    //Calcular como centrar la imagen
    int rejillaX = (int) x1 /10;
    int rejillaY = (int) y1 /10;
        
    int posicionX = rejillaX+x1;
    int posicionY = rejillaY+y1;
    
    String tecla = "";
    boolean inicio = true;
    
    String casilla;
    int contador = 1;
    int seleccion;
    Tablero tablero = new Tablero();
    int decision = 0;
    int jugadaGanadora = 0;
    boolean terminar = true;
    boolean mitiro = false;
    boolean turno = false;
    Rival r = new Rival(tablero);
    boolean pintar = false;
    int y8 = (int) x1/2;
    int y9 = x1+y8;
    Font fuente = Font.getFont (Font.FACE_PROPORTIONAL, Font.STYLE_BOLD, Font.SIZE_LARGE);
    Font fuente2 = Font.getFont (Font.FACE_PROPORTIONAL, Font.STYLE_BOLD, Font.SIZE_SMALL);
    
    public void paint(Graphics g){  
        //Pintamos el tablero, solo se pinta al iniciar el juego
        if(inicio){
            //Se define el color blanco
            g.setColor(255,255,255);
            //Se pinta un rectangulo blanco para pintar la pantalla
            g.fillRect (0,0,x,y);
            //Se define un color verde
            g.setColor(10,200,100);
            //Se dibuja el par de lineas verticales
            g.drawLine (x1,0,x1,y);
            g.drawLine (x2,0,x2,y);
            //Se dibuja el par de lineas horizontales
            g.drawLine(0,y1,y,y1);
            g.drawLine(0,y2,y,y2);
            
            g.setColor(0,0,0);
            //Font fuente = Font.getFont (Font.FACE_PROPORTIONAL, Font.STYLE_BOLD, Font.SIZE_LARGE);

            g.setFont(fuente);
            g.drawString("Bienvenido!", getWidth()/2, getHeight()/2,Graphics.BASELINE|Graphics.HCENTER);
            //Cambia de valor para que la proxima vez que se llame el metodo, no se vuelva a pintar el tablero
            inicio = false;
            //Se inicia el arreglo del tablero
            tablero.inicializarTablero();
        }
        
        if(pintar){
            //Se define el color blanco
            g.setColor(255,255,255);
            //Se pinta un rectangulo blanco para pintar la pantalla
            g.fillRect (0,0,x,y);
            //Se define un color verde
            g.setColor(10,200,100);
            //Se dibuja el par de lineas verticales
            g.drawLine (x1,0,x1,y);
            g.drawLine (x2,0,x2,y);
            //Se dibuja el par de lineas horizontales
            g.drawLine(0,y1,y,y1);
            g.drawLine(0,y2,y,y2);
            pintar = false;
        }
        
        Image img = null;
        Image logo = null;
        try {
            //Se elije la imagen del tiro dependiendo del turno del jugador
            if(turno)
                img = Image.createImage("/imagen/x.PNG");
            
            else    
                img = Image.createImage("/imagen/o.PNG");
                
            //Se pinta el tiro del jugador de acuerdo a la tecla selecciondad
            switch(seleccion){
                case 1:
                    g.drawImage (img, rejillaX+10, rejillaY+5, Graphics.LEFT|Graphics.TOP);
                break;
                    
                case 2:
                    g.drawImage (img, posicionX+7, rejillaY+5, Graphics.LEFT|Graphics.TOP);
                break;
                    
                case 3:
                    g.drawImage (img, posicionX*2+3, rejillaY+5, Graphics.LEFT|Graphics.TOP);
                break;
                    
                case 4:
                    g.drawImage (img, rejillaX+10, posicionY+5, Graphics.LEFT|Graphics.TOP);
                break;
                    
                case 5:
                    g.drawImage (img, posicionX+7, posicionY+5, Graphics.LEFT|Graphics.TOP);
                break;
                    
                case 6:
                    g.drawImage (img, posicionX*2+3, posicionY+5, Graphics.LEFT|Graphics.TOP);
                break;
                    
                case 7:
                    g.drawImage (img, rejillaX+10, posicionY*2, Graphics.LEFT|Graphics.TOP);
                break;
                    
                case 8:
                    g.drawImage (img, posicionX+7, posicionY*2, Graphics.LEFT|Graphics.TOP);
                break;
                                    
                case 9:
                    g.drawImage (img, posicionX*2+3, posicionY*2, Graphics.LEFT|Graphics.TOP);
                break;
                    
            }
            
            //Si el juego ha terminado entonces se muestra el resultado
            //Victoria
            if(decision == 1){
                //logo = Image.createImage("/imagen/victoria.PNG");
                //g.drawImage (logo, 0, 0, Graphics.LEFT|Graphics.TOP);
                    
                //Pinta la linea dependiendo de la jugada que haya ganado
                switch(jugadaGanadora){
                    case 1:
                        g.drawLine(0, y8, getWidth(), y8);
                    break;
                            
                    case 2:
                        g.drawLine(0, y9, getWidth(), y9);
                    break;
                            
                    case 3:
                        g.drawLine(0,y8*5, getWidth(),y9*5);
                    break;
                            
                    case 4:
                        g.drawLine(x1/2,0, x1/2, getHeight());
                    break;
                            
                    case 5:
                        g.drawLine(getWidth()/2,0, getWidth()/2,getHeight());
                    break;
                            
                    case 6:
                        g.drawLine(x1+getWidth()/2, 0, x1+getWidth()/2, getHeight());
                    break;
                        
                    case 7:
                        g.drawLine(0, 0, getWidth(), getHeight());
                    break;
                            
                    case 8:
                        g.drawLine(getWidth(), 0, 0, getHeight());
                    break;
                    }
                //Font fuente = Font.getFont (Font.FACE_PROPORTIONAL, Font.STYLE_BOLD, Font.SIZE_LARGE);
        
                g.setFont(fuente);
                g.drawString("HAS GANADO!", getWidth()/2, getHeight()/2+5,Graphics.BASELINE|Graphics.HCENTER);
                g.setFont(fuente2);
                g.drawString("# - REINICIAR", getWidth()/2, getHeight()-10,Graphics.BASELINE|Graphics.HCENTER);
                }
                //Derrota
            else{
                    if(decision == 2){
                        //logo = Image.createImage("/imagen/derrota.PNG");
                        //g.drawImage (logo, 0, 0, Graphics.LEFT|Graphics.TOP);
                        
                        //Pinta la linea dependiendo de la jugada que haya ganado
                        System.out.println(jugadaGanadora);
                        System.out.println(decision);
                        switch(jugadaGanadora){
                            case 1:
                        g.drawLine(0, y8, getWidth(), y8);
                    break;
                            
                    case 2:
                        g.drawLine(0, y9, getWidth(), y9);
                        System.out.println(y9);
                    break;
                            
                    case 3:
                        g.drawLine(0,y8*5, getWidth(),y9*5);
                    break;
                            
                    case 4:
                        g.drawLine(x1/2,0, x1/2, getHeight());
                    break;
                            
                    case 5:
                        g.drawLine(getWidth()/2,0, getWidth()/2,getHeight());
                    break;
                            
                    case 6:
                        g.drawLine(x1+getWidth()/2, 0, x1+getWidth()/2, getHeight());
                    break;
                        
                    case 7:
                        g.drawLine(0, 0, getWidth(), getHeight());
                    break;
                            
                    case 8:
                        g.drawLine(getWidth(), 0, 0, getHeight());
                    break;
                                }
                        
                         //Font fuente = Font.getFont (Font.FACE_PROPORTIONAL, Font.STYLE_BOLD, Font.SIZE_LARGE);
        
                         g.setFont(fuente);
                         g.drawString("HAS PERDIDO!", getWidth()/2, getHeight()/2,Graphics.BASELINE|Graphics.HCENTER);
                    }
                    //Empate
                    else
                        if(decision == 3){
                            //logo = Image.createImage("/imagen/empate.PNG");
                            //g.drawImage (logo, 0, 0, Graphics.LEFT|Graphics.TOP);
                            //Font fuente = Font.getFont (Font.FACE_PROPORTIONAL, Font.STYLE_BOLD, Font.SIZE_LARGE);
        
                         g.setFont(fuente);
                         g.drawString("HAS EMPATADO!", getWidth()/2, getHeight()/2-25,Graphics.BASELINE|Graphics.HCENTER);
                         g.setFont(fuente2);
                        g.drawString("# - REINICIAR", getWidth()/2, getHeight()-5,Graphics.BASELINE|Graphics.HCENTER);
                        }
            }
        } catch (IOException e) {
            System.err.println("error: " + e);
        }
    }
    
    //Metodo para detectar la tecla presionada
    public void keyPressed(int keyCode) {
        boolean ok = false;
        boolean m = true;
        if(contador == 1)
            pintar = true;
        
        tecla  = this.getKeyName(keyCode);      //Recupera la tecla presionada
        
        if(tecla.equals("ASTERISK") == false && tecla.equals("POUND") == false){
            ok = true;
            seleccion = Integer.parseInt(tecla);    //Hace la transformacion para poder usarla en el switch
        }
        
        if (tecla.equals("POUND")) {
            ok = false;
            //pintar = true;
            contador = 1;
            inicio = true;
            decision = 0;
            jugadaGanadora = 0;
            turno = false;
            seleccion = 0;
            m = false;
            repaint();
        }
        
        //Ejecuta las sentencias dependiendo de la teclas seleccionadas
        if(contador %2 == 1 && ok == true){//Comprueba de quien es el turno
            switch(seleccion){
                case 1:
                    if(tablero.getPosicionTablero(0,0) == 'x' || tablero.getPosicionTablero(0,0) == 'o')
                        System.out.println("La casilla elegida ya está ocupada, elige otra por favor");
                    
                    else{
                        turno = true;
                        repaint();
                        contador++;
                        tablero.asignarPosicion(0,0,'x');
                    }
                break;
                    
                case 2:
                    if(tablero.getPosicionTablero(0,1) == 'x' || tablero.getPosicionTablero(0,1) == 'o')
                        System.out.println("La casilla elegida ya está ocupada, elige otra por favor");
                    
                    else{
                        turno = true;
                        repaint();
                        contador++;
                        tablero.asignarPosicion(0,1,'x');
                    }
                break;
                
                case 3:
                    if(tablero.getPosicionTablero(0,2) == 'x' || tablero.getPosicionTablero(0,2) == 'o')
                        System.out.println("La casilla elegida ya está ocupada, elige otra por favor");
                    
                    else{
                        turno = true;
                        repaint();
                        contador++;
                        tablero.asignarPosicion(0,2,'x');
                    }
                break;
                                
                case 4:
                    if(tablero.getPosicionTablero(1,0) == 'x' || tablero.getPosicionTablero(1,0) == 'o')
                        System.out.println("La casilla elegida ya está ocupada, elige otra por favor");
                    
                    else{
                        turno = true;
                        repaint();
                        contador++;
                        tablero.asignarPosicion(1,0,'x');
                    }
                break;
                
                case 5:
                    if(tablero.getPosicionTablero(1,1) == 'x' || tablero.getPosicionTablero(1,1) == 'o')
                        System.out.println("La casilla elegida ya está ocupada, elige otra por favor");
                    
                    else{
                        turno = true;
                        repaint();
                        contador++;
                        tablero.asignarPosicion(1,1,'x');
                    }
                break;
                                        
                case 6:
                    if(tablero.getPosicionTablero(1,2) == 'x' || tablero.getPosicionTablero(1,2) == 'o')
                        System.out.println("La casilla elegida ya está ocupada, elige otra por favor");
                    
                    else{
                        turno = true;
                        repaint();
                        contador++;
                        tablero.asignarPosicion(1,2,'x');
                    }
                break;
                                            
                case 7:
                    if(tablero.getPosicionTablero(2,0) == 'x' || tablero.getPosicionTablero(2,0) == 'o')
                        System.out.println("La casilla elegida ya está ocupada, elige otra por favor");
                    
                    else{
                        turno = true;
                        repaint();
                        contador++;
                        tablero.asignarPosicion(2,0,'x');
                    }
                break;
                                                
                case 8:
                    if(tablero.getPosicionTablero(2,1) == 'x'|| tablero.getPosicionTablero(2,1) == 'o')
                        System.out.println("La casilla elegida ya está ocupada, elige otra por favor");
                    
                    else{
                        turno = true;
                        repaint();
                        contador++;
                        tablero.asignarPosicion(2,1,'x');
                    }
                break;
                                                    
                case 9:
                    if(tablero.getPosicionTablero(2,2) == 'x' || tablero.getPosicionTablero(2,2) == 'o')
                        System.out.println("La casilla elegida ya está ocupada, elige otra por favor");
                    
                    else{
                        turno = true;
                        repaint();
                        contador++;
                        tablero.asignarPosicion(2,2,'x');
                    }
                break;
            }
        }
        
        else{
            if(ok)
            switch(seleccion){
                case 0:
                    turno = false;
                    rival();
                    repaint();
                    contador++;
                break;
            }
        }

        //Si la jugada no es valida no se efectua el cambio
        //Comprueba si alguien ha ganado o si las oportunidades ya se han acabado
        if((buscarGanador() || contador == 10)&& m == true ){
            //Recupera el resultado del juego, la victoria, derrota o el empate
            decision = decidirGanador(contador);
            repaint();  //Se pinta la pantalla correspondiente al resultado
            //pintar = true;
        }
    }
    
    public void rival(){
        int jugada;  
            
        jugada = r.puedoGanar();
           
        if(jugada == 0){
            jugada = r.comprobarPeligro();
               
            if(jugada == 0){
                jugada = r.comprobarCentro();
                    
                if(jugada == 0)
                    jugada = r.aleatorio();
            }
        }
            seleccion = jugada;
            r.mitiro = false;     
            
                switch(seleccion){
                    case 1:
                        tablero.asignarPosicion(0,0,'o');
                break;
                    
                case 2:
                    tablero.asignarPosicion(0,1,'o');
                break;
                
                case 3:
                    tablero.asignarPosicion(0,2,'o');
                break;
                                
                case 4:
                    tablero.asignarPosicion(1,0,'o');
                break;
                    
                case 5:
                    tablero.asignarPosicion(1,1,'o');
                break;
                                        
                case 6:
                    tablero.asignarPosicion(1,2,'o');
                break;
                                            
                case 7:
                    tablero.asignarPosicion(2,0,'o');
                break;
                                                
                case 8:
                    tablero.asignarPosicion(2,1,'o');
                break;
                                                    
                case 9:
                    tablero.asignarPosicion(2,2,'o');
                break;
            }
    }
    
    //METODO QUE COMPRUEBA SI ALGUNO DE LOS JUGADORES YA GANÓ
    public boolean buscarGanador(){
        boolean ganador = false;
        
        //Comprueba las 3 posibilidades de ganar de forma horizontal
        if(((tablero.getPosicionTablero(0,0) == 'x') && (tablero.getPosicionTablero(0,1) == 'x') && (tablero.getPosicionTablero(0,2) == 'x')) || ((tablero.getPosicionTablero(0,0) == 'o') && (tablero.getPosicionTablero(0,1) == 'o') && (tablero.getPosicionTablero(0,2) == 'o'))){
            ganador = true;
            jugadaGanadora = 1;
        }
        
        if(((tablero.getPosicionTablero(1,0) == 'x') && (tablero.getPosicionTablero(1,1) == 'x') && (tablero.getPosicionTablero(1,2) == 'x')) || ((tablero.getPosicionTablero(1,0) == 'o') && (tablero.getPosicionTablero(1,1) == 'o') && (tablero.getPosicionTablero(1,2) == 'o'))){
            ganador = true;
            jugadaGanadora = 2;
        }
        
        if(((tablero.getPosicionTablero(2,0) == 'x') && (tablero.getPosicionTablero(2,1) == 'x') && (tablero.getPosicionTablero(2,2) == 'x')) || ((tablero.getPosicionTablero(2,0) == 'o') && (tablero.getPosicionTablero(2,1) == 'o') && (tablero.getPosicionTablero(2,2) == 'o'))){
            ganador = true;
            jugadaGanadora = 3;
        }
        
        //Comprueba las 3 posiblidades de ganar de forma vertical
        if(((tablero.getPosicionTablero(0,0) == 'x') && (tablero.getPosicionTablero(1,0) == 'x') && (tablero.getPosicionTablero(2,0) == 'x')) || ((tablero.getPosicionTablero(0,0) == 'o') && (tablero.getPosicionTablero(1,0) == 'o') && (tablero.getPosicionTablero(2,0) == 'o'))){
            ganador = true;
            jugadaGanadora = 4;
        }
        
        if(((tablero.getPosicionTablero(0,1) == 'x') && (tablero.getPosicionTablero(1,1) == 'x') && (tablero.getPosicionTablero(2,1) == 'x')) || ((tablero.getPosicionTablero(0,1) == 'o') && (tablero.getPosicionTablero(1,1) == 'o') && (tablero.getPosicionTablero(2,1) == 'o'))){
            ganador = true;
            jugadaGanadora = 5;
        }
        
        if(((tablero.getPosicionTablero(0,2) == 'x') && (tablero.getPosicionTablero(1,2) == 'x') && (tablero.getPosicionTablero(2,2) == 'x')) || ((tablero.getPosicionTablero(0,2) == 'o') && (tablero.getPosicionTablero(1,2) == 'o') && (tablero.getPosicionTablero(2,2) == 'o'))){
            ganador = true;
            jugadaGanadora = 6;
        }
        
        //LOS DOS SIGUIENTES COMPRUEBAN LAS 2 POSIBILIDADES DE GANAR DE FORMA DIAGONAL
        if(((tablero.getPosicionTablero(0,0) == 'x') && (tablero.getPosicionTablero(1,1) == 'x') && (tablero.getPosicionTablero(2,2) == 'x')) || ((tablero.getPosicionTablero(0,0)=='o') && (tablero.getPosicionTablero(1,1) == 'o') && (tablero.getPosicionTablero(2,2)=='o'))){
            ganador = true;
            jugadaGanadora = 7;
        }
            
        if(((tablero.getPosicionTablero(2,0) == 'x') && (tablero.getPosicionTablero(1,1) == 'x') && (tablero.getPosicionTablero(0,2) == 'x')) || ((tablero.getPosicionTablero(2,0) == 'o') && (tablero.getPosicionTablero(1,1) == 'o') && (tablero.getPosicionTablero(0,2) == 'o'))){
            ganador = true;
            jugadaGanadora = 8;
        }
        
        return ganador;
    }
    
    public int decidirGanador(int turnoJugador){
        //Comprueba si ganó alguien y en el caso de que no, determina empare
        if(buscarGanador() == true)
            //Determina por medio del contador cual jugador fué el que ganó
            if(turno)
                return 1;
            
            else
                return 2;
        //Si no ganó nadie entonces se determina empate
        else
            return 3;
        
        //Los numeros que retorna son usados en el metodo paint() para imprimir
        //la pantalla correspondiente
    }
}