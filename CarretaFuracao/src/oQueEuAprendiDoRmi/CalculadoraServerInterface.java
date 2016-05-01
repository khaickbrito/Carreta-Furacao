/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package oQueEuAprendiDoRmi;


import java.rmi.*;
import java.rmi.registry.Registry;

public interface CalculadoraServerInterface extends Remote{
    // método público que recebe dois valores inteiros e
    // retorna sua soma
    public int somar(int a, int b) throws RemoteException;
    
    public void fecharServidor(String s) throws RemoteException;
    
    public void imprimirNomeCarro(Carro car) throws RemoteException;
//    public int pqp();
    
}
