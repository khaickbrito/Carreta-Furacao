/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import Controller.TremController;
import Util.Operations;

/**
 *
 * @author victor
 */
public class SharedZoneObserver implements Runnable{
        
        private Train myTrain;
        private Operations operations;
        private TremController controller;
        public SharedZoneObserver(Train t){
            this.myTrain = t;
            operations = new Operations(new Train[3]);
            controller = TremController.getInstance();
        }
        
        
    @Override
    public void run() {
        while(true){
            if(operations.isEntryingZone(myTrain)){
                System.out.println("AHAHAHHAHAHHAHA");
            }
        }
    }
    
}
