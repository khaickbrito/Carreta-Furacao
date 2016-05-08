/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.Mapa;
import Model.Trem;
import Model.Calculo;

/**
 *
 * @author victor
 */
public class TremController {
    private static TremController instance = new TremController();
    private Trem[] trem = new Trem[3];
    private Mapa map;

    public TremController() {
        map = Mapa.getInstance();
        addTrem(0, 520, 270, 295, 170, map, 270, 170, 520, 295, 270, 295);
        addTrem(1, 395, 145, 545, 295, map, 145, 545, 270, 295, 395, 545);
        addTrem(2, 645, 395, 545, 295, map, 645, 545, 395, 545, 520, 295);

    }

    public void addTrem(int id, int maxX, int minX, int maxY, int minY, Mapa mapa, int x, int y, int zoneInX, int zoneInY, int zoneOutX, int zoneOutY) {
        for (int i = 0; i < 3; i++) {
            if (trem[i] == null) {
                trem[i] = new Trem(id, maxX, minX, maxY, minY, mapa, x, y, zoneInX, zoneInY, zoneOutX, zoneOutY);
                map.addTrain(trem[i]);
                break;
            }
        }

    }
    
    public void printFuncionou(){
        System.out.println("Funcionou");
    }
    
    public boolean changeSpeed(int i, int speed){
        return trem[i].setSpeed(speed);
    }

    public static TremController getInstance() {
        return instance;
    }

}
