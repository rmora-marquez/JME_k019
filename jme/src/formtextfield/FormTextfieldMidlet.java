package formtextfield;

import javax.microedition.lcdui.Command;
import javax.microedition.lcdui.CommandListener;
import javax.microedition.lcdui.Display;
import javax.microedition.lcdui.Displayable;
import javax.microedition.lcdui.Form;
import javax.microedition.lcdui.Item;
import javax.microedition.lcdui.ItemStateListener;
import javax.microedition.lcdui.StringItem;
import javax.microedition.lcdui.TextField;
import javax.microedition.midlet.*;

/**
 * @author ramon
 */
public class FormTextfieldMidlet extends MIDlet 
        implements CommandListener, ItemStateListener {
    private Form mainForm;
    private TextField tfNum1;
    private TextField tfNum2;
    private TextField tfOperador;
    private TextField tfResultado;
    private StringItem msg;
    private double num1, num2, result;
    private String oper;
    private Command cmdExit;
    private Command cmdGo;
     
    public void startApp() {
        mainForm = new Form("Formulario calculadora");
        tfNum1 = new TextField(("Numero 1:"), "", 10,
                TextField.DECIMAL);
        tfNum2 = new TextField(("Numero 2:"), "", 10,
                TextField.DECIMAL);
        tfOperador = new TextField(("Operación:"), "", 1,
                TextField.ANY);
        tfResultado = new TextField(("Resultado:"), "", 10,
                TextField.DECIMAL);
        msg = new StringItem("","Escriba los numeros, asigne "
                + "operacion A para Sumar o M para multiplicar,"
                + "y presionamos GO");
        mainForm.append(tfNum1);
        mainForm.append(tfNum2);
        mainForm.append(tfOperador);
        mainForm.append(tfResultado);
        mainForm.append(msg);
        
        cmdExit = new Command("Exit", Command.EXIT, 2);
        cmdGo = new Command("Go", Command.SCREEN, 1);
        
        mainForm.addCommand(cmdExit);
        mainForm.addCommand(cmdGo);
        
        mainForm.setCommandListener(this);
        mainForm.setItemStateListener(this);
        
        Display.getDisplay(this).setCurrent(mainForm);
    }
    
    public void pauseApp() {
    }
    
    public void destroyApp(boolean unconditional) {
    }

    public void commandAction(Command c, Displayable d) {
        if(c == cmdGo){
            if(oper.equalsIgnoreCase("A")){
                result= num1 + num2;
            }
            if(oper.equalsIgnoreCase("M")){
                result = num1 * num2;
            }
            tfResultado.setString(result + "");
        }
        if(c == cmdExit){
            destroyApp(true);
            notifyDestroyed();
        }
    }

    public void itemStateChanged(Item item) {
        if(item == tfNum1){
            num1 = Double.parseDouble(tfNum1.getString());
        }
        if(item == tfNum2){
            num2 = Double.parseDouble(tfNum2.getString());
        }
        if(item == tfOperador){
            oper = tfOperador.getString();
        }
    }
}
