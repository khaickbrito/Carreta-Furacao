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
            if(y <= zoneOutY && y >= zoneInY)
                if(y < zoneOutY && x == zoneOutX){
                    return false;
                }else
                    return true;
            else
                return false;
        }else if(id == 1){
            if(x <= zoneOutX && x >= zoneInX)
                if(x > zoneInX && y == zoneOutY)
                    return false;
                else
                    return true;
            else
                return false;
        }else if(id == 2){
            if(x >= zoneInX && x <= zoneOutX)
                if(x < zoneOutX && y == zoneOutY)
                    return false;
                else{
                    System.out.println("Posição X: " + x + "  Posição Y: " + y);
                    return true;
                }    
            else
                return false;
        }else{
            System.out.println("O id está inválido");
            return false;
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
        int id = trem.getId();
        int zoneInX = trem.getZoneInX();
        int zoneInY = trem.getZoneInY();
        int zoneOutX = trem.getZoneOutX();
        int zoneOutY = trem.getZoneOutY();
        int speed = trem.getSpeed();

        if (x == zoneInX && y == zoneInY) {
            System.out.println("Trem " + id + " ENTROU");
            return true;
        } else {
            return false;
        }
    }

    public boolean isLeavingZone(Trem trem) {
        int x = trem.getX();
        int y = trem.getY();
        int id = trem.getId();
        int zoneInX = trem.getZoneInX();
        int zoneInY = trem.getZoneInY();
        int zoneOutX = trem.getZoneOutX();
            int zoneOutY = trem.getZoneOutY();
        int speed = trem.getSpeed();

        if (x == zoneOutX && y == zoneOutY) {
            System.out.println("Trem " + id + " SAIU");
            return true;
        } else {
            return false;
        }
    }
    
    public int firstToEnter(Trem trem1, Trem trem2){
        return 0;
    }

}
