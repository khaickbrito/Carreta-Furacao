/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.Map;
import Model.Train;
import Util.Operations;

/**
 *
 * @author victor
 */
public class TremController {

    private static TremController instance = new TremController();
    private Train[] trem = new Train[3];
    private Map map;
    private Operations calculador;

    public TremController() {
        map = Map.getInstance();
        calculador = new Operations(trem);
        addTrem(0, 520, 270, 295, 170, map, 270, 294, 520, 295, 270, 295, 499);
        addTrem(1, 395, 145, 545, 295, map, 145, 545, 270, 295, 395, 545, 375);
        addTrem(2, 645, 395, 545, 295, map, 645, 545, 395, 545, 520, 295, 250);
    }

    public static TremController getInstance() {
        return instance;
    }

    public void addTrem(int id, int maxX, int minX, int maxY, int minY, Map mapa, int x, int y, int zoneInX, int zoneInY, int zoneOutX, int zoneOutY, int distanceToZone) {
        for (int i = 0; i < 3; i++) {
            if (trem[i] == null) {
                trem[i] = new Train(id, maxX, minX, maxY, minY, mapa, x, y, zoneInX, zoneInY, zoneOutX, zoneOutY, distanceToZone, calculador);
                map.addTrain(trem[i]);
                break;
            }
        }
    }

    public void printFuncionou() {
        System.out.println("Funcionou");
    }

    /*
        Muda a velocidade de um determinado trem que está no mapa.
    */
    public boolean changeSpeed(int id, int speed) {
        return trem[id].setSpeed(speed);
    }
    
    /*
        Muda a velocidade máxima permitida para um determinado trem que está no 
    mapa.
    */
    public boolean changeMaxSpeed(int id, int newMaxSpeed){
        return trem[id].setMaxSpeed(newMaxSpeed);
    }
    
    /*
        Muda a posição do X e Y de um determinado trem do mapa.
    */
    public void changePosition(int id, int x, int y){
        trem[id].setX(x);
        trem[id].setY(y);
    }

}
