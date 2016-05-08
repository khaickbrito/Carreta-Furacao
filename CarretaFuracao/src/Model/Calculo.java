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

    public boolean isInZone(Trem trem) {
        int x = trem.getX();
        int y = trem.getY();
        int id = trem.getId();
        int zoneInX = trem.getZoneInX();
        int zoneInY = trem.getZoneInY();
        int zoneOutX = trem.getZoneOutX();
        int zoneOutY = trem.getZoneOutY();
        int speed = trem.getSpeed();
        
        if(id == 0){
            
        }else if(id == 1){
            
        }else if(id == 2){
            
        }else{
            System.out.println("O id está inválido");
        }
        

//        if (zoneInX > zoneOutX) {
//            if (zoneInY > zoneOutY) {
//                if (x < zoneInX && y > zoneOutY) {
//                    System.out.println("Zona1.1");
//                    return true;
//                } else {
//                    return false;
//                }
//            } else if (zoneInY < zoneOutY) {
//                if (x <= zoneInX && y < zoneOutY) {
//                    System.out.println("Zona1.2");
//                    return true;
//                } else {
//                    return false;
//                }
//            } else {
//                if (x <= zoneInX) {
//                    System.out.println("Zona1.3");
//                    return true;
//                } else {
//                    return false;
//                }
//            }
//        } else if (zoneInX < zoneOutX) {
//            if (zoneInY > zoneOutY) {
//                if (x < zoneOutX && y < zoneOutY) {
//                    System.out.println("Zona2.1");
//                    return true;
//                } else {
//                    return false;
//                }
//            } else if (zoneInY < zoneOutY) {
//                if (x >= zoneInX && y < zoneOutY) {
//                    System.out.println("Zona2.2");
//                    return true;
//                } else {
//                    return false;
//                }
//            } else {
//                if (x >= zoneInX) {
//                    System.out.println("Zona2.3");
//                    return true;
//                } else {
//                    return false;
//                }
//            }
//        } else {
//            return false;
//        }
    }

    public boolean isEntryingZone(Trem trem) {
        int x = trem.getX();
        int y = trem.getY();
        int zoneInX = trem.getZoneInX();
        int zoneInY = trem.getZoneInY();
        int zoneOutX = trem.getZoneOutX();
        int zoneOutY = trem.getZoneOutY();
        int speed = trem.getSpeed();

        if (x == zoneInX && y == zoneInY) {
            System.out.println("ENTROU");
            return true;
        } else {
            return false;
        }
    }

    public boolean isLeavingZone(Trem trem) {
        int x = trem.getX();
        int y = trem.getY();
        int zoneInX = trem.getZoneInX();
        int zoneInY = trem.getZoneInY();
        int zoneOutX = trem.getZoneOutX();
            int zoneOutY = trem.getZoneOutY();
        int speed = trem.getSpeed();

        if (x == zoneOutX && y == zoneOutY) {
            System.out.println("SAIU");
            return true;
        } else {
            return false;
        }
    }

}
