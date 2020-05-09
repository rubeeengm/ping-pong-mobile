package game;

import javax.microedition.lcdui.Display;
import javax.microedition.midlet.*;

public class Principal extends MIDlet{
    private Display display;
    private Juego screen;
    
    public Principal(){
        display = Display.getDisplay(this);
        screen = new Juego();
        display.setCurrent(screen);
    }
    
    public void startApp(){
        
    }
    
    public void pauseApp() {
    }
    
    public void destroyApp(boolean unconditional) {
    }
}