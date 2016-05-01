/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Util;

import Util.RmiServerInterface;
import java.rmi.NotBoundException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

/**
 *
 * @author victor
 */
public class TremCliente {
    private static Registry reg1;
    private static Registry reg2;
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
    try {
      reg1 = LocateRegistry.getRegistry("localhost", 12345);
      RmiServerInterface c = (RmiServerInterface)
        reg1.lookup("CalculadoraServerInterfaceImpl");
      System.out.println("O objeto servidor " + c + " foi encontrado com sucesso.\n");

      // vamos efetuar uma soma?
      System.out.println("A soma de 2 + 5 é: " + c.somar(2, 6));

    }
    catch(Exception ex){
      System.out.println(ex);
     
    }
  }
    
}
