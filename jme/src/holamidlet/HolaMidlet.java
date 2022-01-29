package holamidlet;

import javax.microedition.lcdui.Display;
import javax.microedition.lcdui.Form;
import javax.microedition.midlet.*;

/**
 * @author ramon
 */
public class HolaMidlet extends MIDlet {
    private Display pantalla;
    private Form formulario;
    
    public void startApp() {
        pantalla = Display.getDisplay(this);
        formulario = new Form("Hola mundo midlet");
        pantalla.setCurrent(formulario);
    }
    
    public void pauseApp() {
    }
    
    public void destroyApp(boolean unconditional) {
    }
}
