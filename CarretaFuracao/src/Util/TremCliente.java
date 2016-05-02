/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Util;

import Controller.TremController;
import Util.RmiServerInterface;
import java.rmi.NotBoundException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

/**
 *
 * @author victor
 */
public class TremCliente extends JFrame{

    private static Registry reg1;
    private static Registry reg2;
    private static Registry selfReg;

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        try {
            selfReg = LocateRegistry.createRegistry(1345);
            JPanel panel = new JPanel(null);
            panel.setSize(300, 100);
            
            JLabel pergunta = new JLabel("Digite o IP do trem 1");
            pergunta.setBounds(0, 0, 300, 100);
            
            JTextField caixaDeTexto = new JTextField();
            
            JFrame frame = new JFrame("Trem 1");
            
            panel.add(pergunta);
            panel.add(caixaDeTexto);
            
            frame.add(panel);
            frame.setSize(330, 110);
            frame.setVisible(true);
            RmiServerInterface meuObjeto = new RmiServer();
            selfReg.rebind("RmiServer", meuObjeto);
            
            
            
            reg1 = LocateRegistry.getRegistry("localhost", 12345);
            RmiServerInterface trem1 = (RmiServerInterface) reg1.lookup("RmiServer");
            
            reg2 = LocateRegistry.getRegistry("localhost", 12345);
            
            RmiServerInterface trem2 = (RmiServerInterface) reg2.lookup("RmiServer");
    
            
            

        } catch (Exception ex) {
            System.out.println(ex);
        }
    }

}
