package guessnumbergame;

import java.util.Random;
import javax.microedition.lcdui.Alert;
import javax.microedition.lcdui.AlertType;
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
public class GuessNumberMidlet extends MIDlet 
implements CommandListener{
    
    private TextBox textbox;
    private Command cmdExit;
    private Command cmdTry;
    private Alert alert;
    private Random rand = new Random();
    private int secretNumber;
    private int numTrial = 0;
    private String msgPrompt = "Adivine el numero (entre 1 - 99):";
    
    public void startApp() {
        textbox  = new TextBox("Adivina el numero", 
                msgPrompt, 60, TextField.PLAIN);
        cmdExit = new Command("Exito", Command.EXIT, 2);
        cmdTry = new Command("Intentar", Command.SCREEN, 1);
        
        textbox.addCommand(cmdTry);
        textbox.addCommand(cmdExit);
        textbox.setCommandListener(this);
        alert = new Alert("Resultado","",null,
                AlertType.CONFIRMATION);
        secretNumber = rand.nextInt(100);
        Display.getDisplay(this)
                .setCurrent(textbox);
    }
    
    public void pauseApp() {
    }
    
    public void destroyApp(boolean unconditional) {
    }

    public void commandAction(Command c, Displayable d) {
        if(c == cmdTry){
            textbox.delete(0, msgPrompt.length());
            alert.setString( 
                    checkNumber(
                        textbox.getString()
                    )
            );
            Display.getDisplay(this)
                    .setCurrent(alert);
            textbox.setString(msgPrompt);
        }
        if(c == cmdExit){
            destroyApp(true);
            notifyDestroyed();
        }
    }
    
    private String checkNumber(String strNumberIn){
        int numberIn = Integer.parseInt(strNumberIn);
        numTrial++;
        if( numberIn == secretNumber){
            int numTrialSaved = numTrial;
            numTrial = 0;
            secretNumber = rand.nextInt(100);
            return "Felicidades\n"+
                    "Lo conseguiste en " +
                    numTrialSaved +
                    " intentos";
        }
        if(numberIn > secretNumber){
            return "Intenta un numero menor";
        }else{
            return "Intenta un numero mayor";
        }
    }
}
