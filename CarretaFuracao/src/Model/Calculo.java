/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

/**
 *
 * @author victor
 */
public class Calculo {

    private Trem trem[];

    public Calculo(Trem[] trem) {
        this.trem = trem;
    }

    public boolean isInZone(int idTrain) {
        int x = trem[idTrain].getX();
        int y = trem[idTrain].getY();
        int zoneInX = trem[idTrain].getZoneInX();
        int zoneInY = trem[idTrain].getZoneInY();
        int zoneOutX = trem[idTrain].getZoneOutX();
        int zoneOutY = trem[idTrain].getZoneOutY();
        int speed = trem[idTrain].getSpeed();

        if (zoneInX > zoneOutX) {
            if (zoneInY > zoneOutY) {
                if (x < zoneInX && y > zoneOutY) {
                    System.out.println("Zona1.1");
                    return true;
                } else {
                    return false;
                }
            } else if (zoneInY < zoneOutY) {
                if (x <= zoneInX && y < zoneOutY) {
                    System.out.println("Zona1.2");
                    return true;
                } else {
                    return false;
                }
            } else {
                if (x <= zoneInX) {
                    System.out.println("Zona1.3");
                    return true;
                } else {
                    return false;
                }
            }
        } else if (zoneInX < zoneOutX) {
            if (zoneInY > zoneOutY) {
                if (x < zoneOutX && y < zoneOutY) {
                    System.out.println("Zona2.1");
                    return true;
                } else {
                    return false;
                }
            } else if (zoneInY < zoneOutY) {
                if (x >= zoneInX && y < zoneOutY) {
                    System.out.println("Zona2.2");
                    return true;
                } else {
                    return false;
                }
            } else {
                if (x >= zoneInX) {
                    System.out.println("Zona2.3");
                    return true;
                } else {
                    return false;
                }
            }
        } else {
            return false;
        }
    }

    public boolean isEntryingZone(int idTrain) {
        int x = trem[idTrain].getX();
        int y = trem[idTrain].getY();
        int zoneInX = trem[idTrain].getZoneInX();
        int zoneInY = trem[idTrain].getZoneInY();
        int zoneOutX = trem[idTrain].getZoneOutX();
        int zoneOutY = trem[idTrain].getZoneOutY();
        int speed = trem[idTrain].getSpeed();

        if (x == zoneInX && y == zoneInY) {
            System.out.println("ENTROU");
            return true;
        } else {
            return false;
        }
    }

    public boolean isLeavingZone(int idTrain) {
        int x = trem[idTrain].getX();
        int y = trem[idTrain].getY();
        int zoneInX = trem[idTrain].getZoneInX();
        int zoneInY = trem[idTrain].getZoneInY();
        int zoneOutX = trem[idTrain].getZoneOutX();
        int zoneOutY = trem[idTrain].getZoneOutY();
        int speed = trem[idTrain].getSpeed();

        if (x == zoneOutX && y == zoneOutY) {
            System.out.println("SAIU");
            return true;
        } else {
            return false;
        }
    }

}
