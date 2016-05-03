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
        Scanner scan = new Scanner(System.in);
        TremController controller = TremController.getInstance();
        while (continua) {
            try {
                if (myport == 0) {
                    selfReg = LocateRegistry.createRegistry(porta);
                    myport = porta;
                }else{
                    if (porta == 10100) {
                    porta = 10101;
                    } else if (porta == 10101) {
                        porta = 10102;
                    } else {
                        porta = 10100;
                    }
                }
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
            } catch (Exception ex) {
                if (porta == 10100) {
                    porta = 10101;
                } else if (porta == 10101) {
                    porta = 10102;
                } else {
                    porta = 10100;
                }
            }
        }
        System.out.println("Opa");
        controller.changeSpeed(0, 10);
        controller.changeSpeed(1, 10);
        controller.changeSpeed(2, 10);
        while(true){
            int speed = scan.nextInt();
            controller.changeSpeed(0, speed);
        }
    }
}
