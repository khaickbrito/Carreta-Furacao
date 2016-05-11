/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.Cliente;
import Model.Map;
import Model.Train;
import Util.Operations;
import Util.RmiServerInterface;
import java.rmi.RemoteException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author victor
 */
public class TrainController {

    private Train[] trains = new Train[3];
    private Map map;
    private Operations operator;
    private int myid;
    private RmiServerInterface[] clientes = new RmiServerInterface[3];
    private static TrainController instance = new TrainController();

    public int getMyid() {
        return myid;
    }

    public void setMyid(int myid) {
        this.myid = myid;
        Map.setId(myid);
    }

    public TrainController() {
        map = new Map(this);
        operator = new Operations(trains, this);
//        addTrem(0, 520, 270, 295, 170, map, 270, 294, 520, 295, 270, 295, 499);
//        addTrem(1, 395, 145, 545, 295, map, 145, 545, 270, 295, 395, 545, 375);
//        addTrem(2, 645, 395, 545, 295, map, 645, 545, 395, 545, 520, 295, 250);
//        new Thread(new SharedZoneObserver(trains[0])).start();
    }

    public static TrainController getInstance() {
        return instance;
    }

    public void addRmi(int id, RmiServerInterface rmi) {
        clientes[id] = rmi;
    }

    public void addTrem(int id, int maxX, int minX, int maxY, int minY, int x, int y, int zoneInX, int zoneInY, int zoneOutX, int zoneOutY, int distanceToZone) {
        trains[id] = new Train(id, maxX, minX, maxY, minY, map, x, y, zoneInX, zoneInY, zoneOutX, zoneOutY, distanceToZone, operator);
        map.addTrain(trains[id]);
        System.out.println("Adicionou trem");
        map.repaint();
    }

    public void printFuncionou() {
        System.out.println("Funcionou");
    }

    /*
        Muda a velocidade de um determinado trem que está no mapa.
     */
    public boolean changeSpeed(int id, int speed) {
//        if(id == myid){
//            for(Train t : trains){
//                if(t.getId() != myid)
//                    try {
//                        clientes[id].sendNewSpeed(id, speed);
//                } catch (RemoteException ex) {
//                    Logger.getLogger(TremController.class.getName()).log(Level.SEVERE, null, ex);
//                }
//            }
//        }
        return trains[id].setSpeed(speed);

    }

    /*
        Muda a velocidade de um trem pelo RMI.
     */
    public boolean changeSpeedRMI(int idDestinatario, int id, int speed) {
        try {
            return clientes[idDestinatario].sendNewSpeed(id, speed);

        } catch (RemoteException ex) {
            Logger.getLogger(TrainController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    /*
        Muda a velocidade máxima permitida para um determinado trem que está no 
    mapa.
     */
    public boolean changeMaxSpeed(int id, int newMaxSpeed) {
        return trains[id].setMaxSpeed(newMaxSpeed);
    }

    public boolean changeMaxSpeedRMI(int idDestinatario, int id, int newMaxSpeed) {
        try {
            return clientes[idDestinatario].sendMaxSpeed(id, newMaxSpeed);
        } catch (RemoteException ex) {
            Logger.getLogger(TrainController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    /*
        Muda a posição do X e Y de um determinado trem do mapa.
     */
    public void changePosition(int id, int x, int y) {
        trains[id].setX(x);
        trains[id].setY(y);
    }

    public int firstToEnter(int id) {
        Train aux = operator.firstToEnter(trains[id]);
        return (aux.getId());
    }
    

//    public void returnOldSpeed(int id, int speed) {
//        
//        trains[0].returnOldSpeeds();
//        trains[1].returnOldSpeeds();
//        trains[2].returnOldSpeeds();
//    }
}
