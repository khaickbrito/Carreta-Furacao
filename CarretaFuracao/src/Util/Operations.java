/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Util;

import Controller.TrainController;
import Model.Train;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 *
 * @author victor
 */
public class Operations {

    private Train[] trains;
    private TrainController controller;
    
    public Operations(Train[] trains, TrainController c) {
        this.trains = trains;
        controller = c;
    }

    public boolean isInZone(Train train) {
        int x = train.getX();
        int y = train.getY();
        int id = train.getId();
        int zoneInX = train.getZoneInX();
        int zoneInY = train.getZoneInY();
        int zoneOutX = train.getZoneOutX();
        int zoneOutY = train.getZoneOutY();

        if (id == 0) {
            if (y <= zoneOutY && y >= zoneInY) {
                if (y < zoneOutY && x == zoneOutX) {
                    return false;
                } else {
                    return true;
                }
            } else {
                return false;
            }
        } else if (id == 1) {
            if (x >= zoneInX && x <= zoneOutX) {
                if (x >= zoneInX && y == zoneOutY) {
                    if (x == zoneOutX && y == zoneOutY) {
                        return true;
                    } else {
                        return false;
                    }
                } else {
                    return true;
                }
            } else {
                return false;
            }
        } else if (id == 2) {
            if (x >= zoneInX && x <= zoneOutX) {
                if (x > zoneInX && y == zoneInY) {
                    return false;
                } else {
                    return true;
                }
            } else {
                return false;
            }
        } else {
            System.out.println("O id está inválido");
            return false;
        }
    }

    public boolean isEntryingZone(Train trem) {
        int x = trem.getX();
        int y = trem.getY();
        int id = trem.getId();
        int zoneInX = trem.getZoneInX();
        int zoneInY = trem.getZoneInY();
        int zoneOutX = trem.getZoneOutX();
        int zoneOutY = trem.getZoneOutY();

        if (id == 0) {
            if (x == zoneInX && y == zoneInY - 1) {
                return true;
            } else {
                return false;
            }
        } else if (id == 1) {
            if (x == zoneInX - 1 && y == zoneInY) {
                return true;
            } else {
                return false;
            }
        } else if (id == 2) {
            if (x == zoneInX + 1 && y == zoneInY) {
                return true;
            } else {
                return false;
            }
        } else {
            System.out.println("Id invalido: " + id);
            return false;
        }
    }

    public boolean isLeavingZone(Train trem) {
        int x = trem.getX();
        int y = trem.getY();
        int id = trem.getId();
        int zoneInX = trem.getZoneInX();
        int zoneInY = trem.getZoneInY();
        int zoneOutX = trem.getZoneOutX();
        int zoneOutY = trem.getZoneOutY();

        if (x == zoneOutX && y == zoneOutY) {
            return true;
        } else {
            return false;
        }
    }

    public Train firstToEnter(Train trem0) {
        Train trem1;
        Train trem2;
        if (trem0.getId() == 0) {
            trem1 = trains[1];
            trem2 = trains[2];
            return auxFirstToEnter(trem1, trem2);
        } else if (trem0.getId() == 1) {
            trem1 = trains[0];
            trem2 = trains[2];
            return auxFirstToEnter(trem1, trem2);
        } else if (trem0.getId() == 2) {
            trem1 = trains[0];
            trem2 = trains[1];
            return auxFirstToEnter(trem1, trem2);
        } else {
            System.out.println("Id inválido");
            return null;
        }
    }

//    private Train auxFirstToEnter(Train trem1, Train trem2) {
//        int speed1 = trem1.getSpeed();
//        int speed2 = trem2.getSpeed();
//        int dist1 = trem1.getDistanceToZone();
//        int dist2 = trem2.getDistanceToZone();
//        float time1 = dist1 / speed1;
//        float time2 = dist2 / speed2;
//
//        if (time1 < time2) {
//            return trem1;
//        } else if (time2 > time1) {
//            return trem2;
//        } else {
//            System.out.println("Random");
//            List random = new ArrayList();
//            random.add(trem1);
//            random.add(trem2);
//            Collections.shuffle(random);
//            return ((Train) random.get(0));
//        }
//    }
    
        private Train auxFirstToEnter(Train trem1, Train trem2) {
        int dist1 = trem1.getDistanceToZone();
        int dist2 = trem2.getDistanceToZone();

        if (dist1 < dist2) {
            return trem1;
        } else if (dist2 < dist1) {
            return trem2;
        } else {
            List random = new ArrayList();
            random.add(trem1);
            random.add(trem2);
            Collections.shuffle(random);
            return ((Train) random.get(0));
        }
    }

    public void putDistance(Train trem) {
        int id = trem.getId();

        if (id == 0) {
            trem.setDistanceToZone(499);
        } else if (id == 1) {
            trem.setDistanceToZone(624);
        } else if (id == 2) {
            trem.setDistanceToZone(624);
        } else {
            System.out.println("Id invalido");
        }
    }

    public int timeInZone(Train t) {
        return t.getMyDistanceInZone() / t.getSpeed();
    }

    public int calculateNewSpeed(Train trem, int time) {
        return (int)((trem.getDistanceToZone() / time)*0.7);
    }

    public void changeSpeedsInByTime(Train train0, int time, Train firstToEnter) {
        Train train1;
        Train train2;
        int speed;
//        System.out.println("ChangeSpeedsInByTime");
        if (train0.getId() == 0) {
            train1 = trains[1];
            train2 = trains[2];
            speed = calculateNewSpeed(firstToEnter, time);
//            System.out.println("VELOCIDADE - " + speed);
            changeSpeedsRMI(train1, train2, speed);
        } else if (train0.getId() == 1) {
            train1 = trains[0];
            train2 = trains[2];
            speed = calculateNewSpeed(firstToEnter, time);
            changeSpeedsRMI(train1, train2, speed);
        } else if (train0.getId() == 2) {
            train1 = trains[0];
            train2 = trains[1];
            speed = calculateNewSpeed(firstToEnter, time);
            changeSpeedsRMI(train1, train2, speed);
        } else {
            System.out.println("Id inválido");
        }
    }

    public void changeSpeedsIn(Train train0, int speed) {
        Train train1;
        Train train2;
        if (train0.getId() == 0) {
            train1 = trains[1];
            train2 = trains[2];
            changeSpeedsRMI(train1, train2, speed);
        } else if (train0.getId() == 1) {
            train1 = trains[0];
            train2 = trains[2];
            changeSpeedsRMI(train1, train2, speed);
        } else if (train0.getId() == 2) {
            train1 = trains[0];
            train2 = trains[1];
            changeSpeedsRMI(train1, train2, speed);
        } else {
            System.out.println("Id inválido");
        }
    }
    
    public void returnOldSpeeds(Train train0, int speed) {
        Train train1;
        Train train2;
        if (train0.getId() == 0) {
            train1 = trains[1];
            train2 = trains[2];
            changeSpeedsRMI(train1, train2, speed);
        } else if (train0.getId() == 1) {
            train1 = trains[0];
            train2 = trains[2];
            changeSpeedsRMI(train1, train2, speed);
        } else if (train0.getId() == 2) {
            train1 = trains[0];
            train2 = trains[1];
            changeSpeedsRMI(train1, train2, speed);
        } else {
            System.out.println("Id inválido");
        }
        trains[0].returnOldSpeeds();
        trains[1].returnOldSpeeds();
        trains[2].returnOldSpeeds();
//        trains[0].setMaxSpeed(trains[0].getMyOldMaxSpeed());
//        trains[0].setSpeed(trains[0].getMyOldSpeed());
//        long trem1OldMaxSpeed = trains[1].getMyOldMaxSpeed();
//        trains[1].setMaxSpeed(trem1OldMaxSpeed);
//        int trem1OldSpeed = trains[1].getMyOldSpeed();
//        System.out.println("TREM 1 NOVA SPEED" + trem1OldSpeed);
//        trains[1].setSpeed(trem1OldSpeed);
//        trains[2].setMaxSpeed(trains[2].getMyOldMaxSpeed());
//        trains[2].setSpeed(trains[2].getMyOldSpeed());
    }
    
    public void changeMyInfoRMI(int id, int speed){
        controller.changeTrainInfoRMI(id, speed);
    }

    public void changeMySpeedRMI(int id, int speed){
        for(Train t : trains){
        if(t.getId() != id)
//            controller.changeSpeedRMI(id, id, speed);
        controller.changeTrainInfoRMI(id, speed);
        }
    }
    
    private void changeSpeedsRMI(Train train1, Train train2, int speed) {
        train1.setMaxSpeed(speed);
        controller.changeMaxSpeedRMI(train1.getId(), train1.getId(), speed);
        train2.setMaxSpeed(speed);
        controller.changeMaxSpeedRMI(train2.getId(), train2.getId(), speed);
        
        train1.setSpeed(speed);
        controller.changeSpeedRMI(train1.getId(), train1.getId(), speed);
        train2.setSpeed(speed);
        controller.changeSpeedRMI(train2.getId(), train2.getId(), speed);
    }

}
