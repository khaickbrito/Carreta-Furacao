/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Util;

/**
 *
 * @author victor
 */
public class facade {
    
    private RmiServer[] classeTrens = new RmiServer[3];
    private static int myId;
    
    public facade(int id){
        myId = id;
    }
    
    public static int getMyId(){
        return myId;
    }
    
    public void addRmi(RmiServer r){
        for (int i = 0; i < 3; i++) {
            if (classeTrens[i] == null) {
                classeTrens[i] = r;   
                break;
            }
            
        }
    }
    
    
    
    
    
    
    
}
