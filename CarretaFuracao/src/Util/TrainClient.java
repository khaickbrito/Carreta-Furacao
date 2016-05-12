/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Util;

import Controller.TrainController;
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
public class TrainClient extends JFrame {

    private static Registry reg1 = null;
    private static Registry reg2 = null;
    private static Registry selfReg;
    private static Registry serverReg;
//    private static TrainController controller = TrainController.getInstance();
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
        myID = CaixaDeTexto.pedirIP();
        TrainController controller = TrainController.getInstance();
        controller.setMyid(myID);
        while (continua) {
            try {
                int contador = 0;
                if (myport == 0) {
                    selfReg = LocateRegistry.createRegistry(porta);
                    myport = porta;
                    RmiServerInterface meuObjeto = new RmiServer(myID);
                    controller.addRmi(myID, meuObjeto);
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
                }
                if (porta == 10100) {
                    porta = 10101;
                } else if (porta == 10101) {
                    porta = 10102;
                } else if (porta == 10102) {
                    porta = 10100;
                }

                if (myport == porta) {
                    continue;
                }

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

        try {

            RmiServerInterface trem1 = (RmiServerInterface) reg1.lookup("RmiServer");
            RmiServerInterface trem2 = (RmiServerInterface) reg2.lookup("RmiServer");
            controller.addRmi(trem1.getId(), trem1);
            controller.addRmi(trem2.getId(), trem2);
        } catch (RemoteException ex) {
            Logger.getLogger(TrainClient.class.getName()).log(Level.SEVERE, null, ex);
        } catch (NotBoundException ex) {
            Logger.getLogger(TrainClient.class.getName()).log(Level.SEVERE, null, ex);
        }

        controller.changeSpeed(myID, 10);
        controller.changeTrainInfoRMI(myID, 10);
        
//        if (myID != 0) {
//            controller.changeSpeedRMI(0, myID, 10);
//        }
//        if (myID != 1) {
//            controller.changeTrainInfoRMI(1, myID, 10);
//        }
//        if (myID != 2) {
//            controller.changeSpeedRMI(2, myID, 10);
//        }

        for (int i = 0; i < 20; i++) {
            System.out.print("Digite a velocidade: ");
            int sp = scan2.nextInt();

            controller.changeSpeed(myID, sp);
            controller.changeTrainInfoRMI(myID, sp);
//            if (myID != 0) {
//                controller.changeSpeedRMI(0, myID, sp);
//            }
//            if (myID != 1) {
//                controller.changeSpeedRMI(1, myID, sp);
//            }
//            if (myID != 2) {
//                controller.changeSpeedRMI(2, myID, sp);
//            }
            System.out.println("\n\n\n\n\n\n\n");
        }
    }
}
