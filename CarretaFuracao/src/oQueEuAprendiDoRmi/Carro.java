/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package oQueEuAprendiDoRmi;

import java.io.Serializable;

/**
 *
 * @author victor
 */
public class Carro implements Serializable{
    
    private String modelo;
    
    public Carro(String modelo){
        this.modelo = modelo;
    }

    public String getModelo() {
        return modelo;
    }
    
    
    
}
