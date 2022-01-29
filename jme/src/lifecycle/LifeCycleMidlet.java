package lifecycle;

import javax.microedition.lcdui.Command;
import javax.microedition.lcdui.CommandListener;
import javax.microedition.lcdui.Display;
import javax.microedition.lcdui.Displayable;
import javax.microedition.lcdui.Form;
import javax.microedition.lcdui.StringItem;
import javax.microedition.midlet.*;

/**
 * @author ramon
 */
public class LifeCycleMidlet extends MIDlet implements CommandListener {
    private Form formulario;
    private Display pantalla;
    private Command cmdExit;
    private StringItem message;

    public LifeCycleMidlet() {
        System.out.println("Llamamos a la incializacion del midlet");
        formulario = new Form("Midlet lifecycle");
        message = new StringItem(null, "Construyendo el midlet");
        formulario.append(message);
        cmdExit = new Command("Salir", Command.EXIT, 1);
        formulario.addCommand(cmdExit);
        formulario.setCommandListener(this);
        pantalla = Display.getDisplay(this);
        pantalla.setCurrent(formulario);
    }
    public void startApp() {
        System.out.println("StartApp() is called");
        message.setText("StartApp es llamado...");
    }
    
    public void pauseApp() {
        System.out.println("PauseApp() is called");
        message.setText("PauseApp es llamado...");
    }
    
    public void destroyApp(boolean unconditional) {
        System.out.println("DestroyApp() is called");
        message.setText("DestroyApp es llamado...");
    }

    public void commandAction(Command c, Displayable d) {
        if(c == cmdExit){
            destroyApp(true);
            notifyDestroyed();
        }
    }
}
