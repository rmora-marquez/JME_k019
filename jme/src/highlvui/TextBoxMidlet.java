
package highlvui;

import javax.microedition.lcdui.Command;
import javax.microedition.lcdui.CommandListener;
import javax.microedition.lcdui.Display;
import javax.microedition.lcdui.Displayable;
import javax.microedition.lcdui.TextBox;
import javax.microedition.lcdui.TextField;
import javax.microedition.midlet.*;

/**
 * @author ramon
 */
public class TextBoxMidlet extends MIDlet implements CommandListener {
    private Display currentDisplay;
    private TextBox tbox1;
    private TextBox tbox2;
    private Command cmdExit;
    private Command cmdNext;
    
    public void startApp() {
        tbox1 = new TextBox("Pagina 1","Esta es la pagina no. 1",40,TextField.ANY);
        tbox2 = new TextBox("Pagina 2","Esta es la pagina no. 2",40,TextField.ANY);        
        cmdExit = new Command("Salir", Command.EXIT, 1);
        cmdNext = new Command("Sig. Pag.", Command.SCREEN, 2);        
        tbox1.addCommand(cmdNext);
        tbox2.addCommand(cmdExit);      
        tbox1.setCommandListener(this);
        tbox2.setCommandListener(this);        
        currentDisplay = Display.getDisplay(this);
        currentDisplay.setCurrent(tbox1);
    }
    
    public void pauseApp() {  }
    
    public void destroyApp(boolean unconditional) { }

    public void commandAction(Command c, Displayable d) {
        if( c == cmdNext){
            currentDisplay.setCurrent(tbox2);
        }
        if(c == cmdExit){
            destroyApp(true);
            notifyDestroyed();
        }
    }
}
