/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Util;

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

    public Operations(Train[] trains) {
        this.trains = trains;
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

    private Train auxFirstToEnter(Train trem1, Train trem2) {
        int speed1 = trem1.getSpeed();
        int speed2 = trem2.getSpeed();
        int dist1 = trem1.getDistanceToZone();
        int dist2 = trem2.getDistanceToZone();
        float time1 = dist1 / speed1;
        float time2 = dist2 / speed2;

        if (time1 < time2) {
            return trem1;
        } else if (time2 > time1) {
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
        System.out.println("Distancia para a zona do trem " + trem.getId() + " = " + trem.getDistanceToZone());

        System.out.println("nova velocidade = " + trem.getDistanceToZone()/time);
        return trem.getDistanceToZone() / time;
    }

    public void changeSpeedsInByTime(Train train0, int time, Train firstToEnter) {
        Train train1;
        Train train2;
        int speed;
        System.out.println("ChangeSpeedsInByTime");
        if (train0.getId() == 0) {
            train1 = trains[1];
            train2 = trains[2];
            speed = calculateNewSpeed(firstToEnter, time);
            System.out.println("VELOCIDADE - " + speed);
            auxChangeSpeedsIn(train1, train2, speed);
        } else if (train0.getId() == 1) {
            train1 = trains[0];
            train2 = trains[2];
            speed = calculateNewSpeed(firstToEnter, time);
            auxChangeSpeedsIn(train1, train2, speed);
        } else if (train0.getId() == 2) {
            train1 = trains[0];
            train2 = trains[1];
            speed = calculateNewSpeed(firstToEnter, time);
            auxChangeSpeedsIn(train1, train2, speed);
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
            auxChangeSpeedsIn(train1, train2, speed);
        } else if (train0.getId() == 1) {
            train1 = trains[0];
            train2 = trains[2];
            auxChangeSpeedsIn(train1, train2, speed);
        } else if (train0.getId() == 2) {
            train1 = trains[0];
            train2 = trains[1];
            auxChangeSpeedsIn(train1, train2, speed);
        } else {
            System.out.println("Id inválido");
        }
    }
    
    public void returnOldSpeeds() {
        trains[0].setMaxSpeed(trains[0].getMyOldMaxSpeed());
        trains[0].setSpeed(trains[0].getMyOldSpeed());
        trains[1].setMaxSpeed(trains[1].getMyOldMaxSpeed());
        trains[1].setSpeed(trains[1].getMyOldSpeed());
        trains[2].setMaxSpeed(trains[2].getMyOldMaxSpeed());
        trains[2].setSpeed(trains[2].getMyOldSpeed());
    }

    private void auxChangeSpeedsIn(Train train1, Train train2, int speed) {
        train1.setMaxSpeed(speed);
        train2.setMaxSpeed(speed);
        train1.setSpeed(speed);
        train2.setSpeed(speed);
    }

}
