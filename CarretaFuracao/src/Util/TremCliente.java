/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Util;

import Controller.TremController;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import javax.swing.JFrame;

/**
 *
 * @author victor
 */
public class TremCliente extends JFrame {

    private static Registry reg1;
    private static Registry reg2;
    private static Registry selfReg;
    private static Registry serverReg;
    private static int porta = 10100;

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        int myport = 0;
        boolean continua = true;
        while (continua) {
            try {
                TremController controller = TremController.getInstance();
                if (myport == 0) {
                    selfReg = LocateRegistry.createRegistry(porta);
                    myport = porta;
                }else{
                    if (porta == 10100) {
                    System.out.println("2");
                    porta = 10101;
                } else if (porta == 10101) {
                    System.out.println("3");
                    porta = 10102;
                } else {
                    System.out.println("4");
                    porta = 10100;
                }
                }
//            String ipServidor = CaixaDeTexto.pedirIP();
//            
//            System.out.println(ipServidor);
                RmiServerInterface meuObjeto = new RmiServer();
                selfReg.rebind("RmiServer", meuObjeto);
                if (myport == porta) {
                    continue;
                }
                reg1 = LocateRegistry.getRegistry(porta);

                if (myport == porta) {
                    continue;
                }
                reg2 = LocateRegistry.getRegistry(porta);

                RmiServerInterface trem1 = (RmiServerInterface) reg1.lookup("RmiServer");

                RmiServerInterface trem2 = (RmiServerInterface) reg2.lookup("RmiServer");

                continua = false;

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
                System.out.println("1");
                if (porta == 10100) {
                    System.out.println("2");
                    porta = 10101;
                } else if (porta == 10101) {
                    System.out.println("3");
                    porta = 10102;
                } else {
                    System.out.println("4");
                    porta = 10100;
                }

            }
        }
        
        
        
    
    }

}
