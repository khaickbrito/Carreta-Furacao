/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

/**
 *
 * @author victor
 */
public class TremController {
    
    private static TremController instance = new TremController();
    
    
    
    public static TremController getInstance(){
        return instance;
    }
    
}
