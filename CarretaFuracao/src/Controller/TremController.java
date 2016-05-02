/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.Mapa;
import Model.Trem;

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
        addTrem(520, 270, 295, 170, map, 270, 170);
        addTrem(395, 145, 545, 295, map, 145, 545);
        addTrem(645, 395, 545, 295, map, 645, 545);

    }

    public void addTrem(int maxX, int minX, int maxY, int minY, Mapa mapa, int x, int y) {
        for (int i = 0; i < 3; i++) {
            if (trem[i] == null) {
                trem[i] = new Trem(maxX, minX, maxY, minY, mapa, x, y);
                map.addTrain(trem[i]);
                break;
            }
        }

    }
    
    public void changeSpeed(int i, int speed){
        trem[i].setSpeed(speed);
    }

    public static TremController getInstance() {
        return instance;
    }

}
