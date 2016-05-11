/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Util;

import Controller.TremController;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.Scanner;
import javax.swing.JFrame;

/**
 *
 * @author victor
 */
public class TremCliente extends JFrame {

    private static Registry reg1 = null;
    private static Registry reg2 = null;
    private static Registry selfReg;
    private static Registry serverReg;
    private static TremController controller = TremController.getInstance();
//    private static int porta = 10100;

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        int porta = 10100;
        int myport = 0, port1 = 0, port2 = 0;
        boolean continua = true;
        Scanner scan1 = new Scanner(System.in);
        Scanner scan2 = new Scanner(System.in);
        while (continua) {
            try {
                if (myport == 0) {
                    selfReg = LocateRegistry.createRegistry(porta);
                    myport = porta;
                    RmiServerInterface meuObjeto = new RmiServer();
                    selfReg.rebind("RmiServer", meuObjeto);
                } else if (porta == 10100) {
                    porta = 10101;
                } else if (porta == 10101) {
                    porta = 10102;
                } else {
                    porta = 10100;
                }

                if (myport == porta) {
                    continue;
                }
                if (port1 == 0) {
                    reg1 = LocateRegistry.getRegistry(porta);
                    RmiServerInterface trem1 = (RmiServerInterface) reg1.lookup("RmiServer");
                    port1 = porta;
                    
                }
                if (port2 == 0 && porta != port1) {
                    reg2 = LocateRegistry.getRegistry(porta);
                    RmiServerInterface trem2 = (RmiServerInterface) reg2.lookup("RmiServer");
                    continua = false;
                }
                
            } catch (Exception ex) {
                if (!continua) {
                    break;
                }
                if (porta == 10100) {
                    porta = 10101;
                } else if (porta == 10101) {
                    porta = 10102;
                } else {
                    porta = 10100;
                }
            }
        }
        
        
        controller.changeSpeed(0, 10);
        controller.changeSpeed(1, 10);
        controller.changeSpeed(2, 10);
        
        
        
        for(int i=0; i<20;i++){
            System.out.print("Digite o numero do trem: ");
            int index = scan1.nextInt();
            System.out.print("Digite a velocidade: ");
            int sp = scan2.nextInt();
            controller.changeSpeed(index, sp);
//            System.out.println(controller.firstToEnter(0));
            System.out.println("\n\n\n\n\n\n\n");
        }    
       
    }
}
