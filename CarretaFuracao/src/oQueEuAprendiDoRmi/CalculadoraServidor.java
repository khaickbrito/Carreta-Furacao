/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package oQueEuAprendiDoRmi;

import java.rmi.registry.*;
/**
 *
 * @author victor
 */
public class CalculadoraServidor {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        try {
            
            Registry registry = LocateRegistry.createRegistry(12345);
            CalculadoraServerInterface csi = new CalculadoraServerInterfaceImpl(registry);
            registry.rebind("CalculadoraServerInterfaceImpl", csi);
            System.out.println("Servidor Calculadora " + csi
                    + " registrado e pronto para aceitar solicitações.");
//            registry.unbind("CalculadoraServerInterfaceImpl");
            
        } catch (Exception ex) {
            System.out.println("Houve um erro: " + ex.getMessage());
        }
    }

}
