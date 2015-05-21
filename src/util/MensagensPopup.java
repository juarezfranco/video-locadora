package util;

import java.awt.Dimension;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

/**
 *
 * @author juarez
 */
public class MensagensPopup {
   public static void showMensagemErro(String titulo, Exception e){
        JTextArea textArea = new JTextArea();
        //tranformar printStackTrace em String
        try{
                StringWriter sw = new StringWriter();
	        PrintWriter pw = new PrintWriter(sw);
	        e.printStackTrace(pw);
	        pw.close();
	        sw.close();
	        textArea.setText(sw.getBuffer().toString());
        }catch(Exception exc){
        }
        
        JScrollPane scroll = new JScrollPane(textArea);
        scroll.setPreferredSize(new Dimension(750,250));
        JOptionPane.showMessageDialog(null, scroll, titulo, JOptionPane.ERROR_MESSAGE);
    }
}
