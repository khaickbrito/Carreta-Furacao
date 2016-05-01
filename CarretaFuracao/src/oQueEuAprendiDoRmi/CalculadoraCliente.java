/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package oQueEuAprendiDoRmi;

import oQueEuAprendiDoRmi.CalculadoraServerInterface;
import oQueEuAprendiDoRmi.Carro;
import java.rmi.NotBoundException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

/**
 *
 * @author victor
 */
public class CalculadoraCliente {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
    try {
      Registry registry = LocateRegistry.getRegistry("localhost", 12345);
      CalculadoraServerInterface c = (CalculadoraServerInterface)
        registry.lookup("CalculadoraServerInterfaceImpl");
      System.out.println("O objeto servidor " + c + " foi encontrado com sucesso.\n");

      // vamos efetuar uma soma?
      System.out.println("A soma de 2 + 5 é: " + c.somar(2, 6));
     
      Carro car = new Carro("mustang");
      c.imprimirNomeCarro(car);
    }
    catch(Exception ex){
      System.out.println(ex);
     
    }
  }
    
}
