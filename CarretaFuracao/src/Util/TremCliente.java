/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Util;

import Controller.TremController;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
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
        int porta = 10100, myID;
        boolean porta1 = false, porta2 = false, porta3 = false;
        int myport = 0, port1 = 0, port2 = 0;
        boolean continua = true;
        Scanner scan1 = new Scanner(System.in);
        Scanner scan2 = new Scanner(System.in);
        myID = scan1.nextInt();
        controller.setMyid(myID);
        while (continua) {
            try {
                int contador = 0;
                if (myport == 0) {
                    selfReg = LocateRegistry.createRegistry(porta);
                    myport = porta;
                    RmiServerInterface meuObjeto = new RmiServer(myID);
                    selfReg.rebind("RmiServer", meuObjeto);
                    if (myID == 0) {
                        controller.addTrem(0, 520, 270, 295, 170, 270, 294, 520, 295, 270, 295, 499);
                    } else if (myID == 1) {
                        controller.addTrem(1, 395, 145, 545, 295, 145, 545, 270, 295, 395, 545, 375);
                    } else if (myID == 2) {
                        controller.addTrem(2, 645, 395, 545, 295, 645, 545, 395, 545, 520, 295, 250);
                    } else {
                        System.out.println("Id inválido.");
                    }
                }if (porta == 10100) {
                        porta = 10101;
                    } else if (porta == 10101) {
                        porta = 10102;
                    } else if (porta == 10102) {
                        porta = 10100;
                    }

            
         
         
                if (myport == porta) {
                    continue;
                }
              
//                System.out.println("port1"+port1);
//                System.out.println("porta" + porta);
//                if (myport != 0) {
                if (port1 == 0) {
                    reg1 = LocateRegistry.getRegistry(porta);
                    RmiServerInterface trem1 = (RmiServerInterface) reg1.lookup("RmiServer");
                    System.out.println("pegou porta 1");
                    port1 = porta;
                    trem1.imHere(myID);
                    System.out.println("enviei meu id");
                }
                if (port2 == 0 && porta != port1) {
                    reg2 = LocateRegistry.getRegistry(porta);
                    RmiServerInterface trem2 = (RmiServerInterface) reg2.lookup("RmiServer");
                    trem2.imHere(myID);
                    continua = false;
                }
//                }

            } catch (Exception ex) {
                if (!continua) {
                    break;
                }
                if (myport == 0) {
                    if (porta == 10100) {
                        porta = 10101;
                    } else if (porta == 10101) {
                        porta = 10102;
                    } else if (porta == 10102) {
                        porta = 10100;
                    }
                }
            }
        }

        System.out.println("passou aqui");
        try {
            RmiServerInterface trem1 = (RmiServerInterface) reg1.lookup("RmiServer");
            RmiServerInterface trem2 = (RmiServerInterface) reg2.lookup("RmiServer");

        } catch (RemoteException ex) {
            Logger.getLogger(TremCliente.class.getName()).log(Level.SEVERE, null, ex);
        } catch (NotBoundException ex) {
            Logger.getLogger(TremCliente.class.getName()).log(Level.SEVERE, null, ex);
        }
        

        
//        for(int i=0; i<20;i++){
//            System.out.print("Digite o numero do trem: ");
//            int index = scan1.nextInt();
//            System.out.print("Digite a velocidade: ");
//            int sp = scan2.nextInt();
//            controller.changeSpeed(index, sp);
////            System.out.println(controller.firstToEnter(0));
//            System.out.println("\n\n\n\n\n\n\n");
//        }    
    }
}
