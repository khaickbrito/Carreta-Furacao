/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Util;

import Controller.TremController;
import Util.RmiServerInterface;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.rmi.NotBoundException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import javax.swing.JButton;
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
    private static Registry serverReg;
    

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        try {
            
            TremController controller = TremController.getInstance();
            
            
//            selfReg = LocateRegistry.createRegistry(1345);
//           
//            String ipServidor = CaixaDeTexto.pedirIP();
//            
//            System.out.println(ipServidor);
//            RmiServerInterface meuObjeto = new RmiServer();
//            selfReg.rebind("RmiServer", meuObjeto);
//            
//            serverReg = LocateRegistry.getRegistry(ipServidor, 12345);
//            
//            RmiServerInterface servidor = (RmiServerInterface) serverReg.lookup("RmiServer");
//            
//            String[] trens = servidor.getTrainsIp();
//            
//            
//            
//            reg1 = LocateRegistry.getRegistry(ipServidor, 12345);
//         
//            RmiServerInterface trem1 = (RmiServerInterface) reg1.lookup("RmiServer");
//            
//            reg2 = LocateRegistry.getRegistry("localhost", 12345);
//            
//            RmiServerInterface trem2 = (RmiServerInterface) reg2.lookup("RmiServer");
    
            
            

        } catch (Exception ex) {
            System.out.println(ex);
        }
    }

}
