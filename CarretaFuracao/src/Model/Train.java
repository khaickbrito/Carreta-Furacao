/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import Util.Operations;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JTextField;
import static java.lang.Thread.sleep;

/**
 *
 * @author victor
 */
public class Train {

    private Operations calculador;
    private int id;
    private int maxX;
    private int minX;
    private int maxY;
    private int minY;
    private int zoneInX;
    private int zoneInY;
    private int zoneOutX;
    private int zoneOutY;
    private Map mapa;
    private int x;
    private int y;
    private long maxSystemSpeed = 20;
    private long maxSpeed = 40;
    private int speed = 0;
    private int distanceToZone;
    private int myDistanceInZone;
    private int myOldSpeed = 0;
    private long myOldMaxSpeed = 40;

    public int getMyOldSpeed() {
        return myOldSpeed;
    }

    public void setMyOldSpeed(int myOldSpeed) {
        this.myOldSpeed = myOldSpeed;
    }

    public void setMyOldMaxSpeed(int myOldMaxSpeed) {
        this.myOldMaxSpeed = myOldMaxSpeed;
    }

    public long getMyOldMaxSpeed() {
        return myOldMaxSpeed;
    }

    public int getMyDistanceInZone() {
        return myDistanceInZone;
    }

//    public boolean id;
    // private int cont;
    private JButton botao;
    private JTextField campoVelocidade;

    public Train(int id, int maxX, int minX, int maxY, int minY, Map mapa, int x, int y,
            int zoneInX, int zoneInY, int zoneOutX, int zoneOutY, int dist, Operations calc) {
        this.distanceToZone = dist;
        this.id = id;
        this.maxX = maxX;
        this.minX = minX;
        this.maxY = maxY;
        this.minY = minY;
        this.mapa = mapa;
        this.zoneInX = zoneInX;
        this.zoneInY = zoneInY;
        this.zoneOutX = zoneOutX;
        this.zoneOutY = zoneOutY;
        this.x = x;
        this.y = y;
        calculador = calc;
        if (id == 0) {
            myDistanceInZone = 250;
        } else {
            myDistanceInZone = 375;
        }
        new Thread(new TremThread(this)).start();

//        campoVelocidade = new JTextField();
//        campoVelocidade.setText("Digite");
//        botao = new JButton();
//        botao.setText("Alterar");
//        botao.addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//                velocidade = Long.parseLong(campoVelocidade.getText());
//            }
//        });
    }

    public JButton getBotao() {
        return botao;
    }

    public int getMaxX() {
        return maxX;
    }

    public void setMaxX(int maxX) {
        this.maxX = maxX;
    }

    public int getMinX() {
        return minX;
    }

    public void setMinX(int minX) {
        this.minX = minX;
    }

    public int getMaxY() {
        return maxY;
    }

    public void setMaxY(int maxY) {
        this.maxY = maxY;
    }

    public int getMinY() {
        return minY;
    }

    public void setMinY(int minY) {
        this.minY = minY;
    }

    public int getZoneInX() {
        return zoneInX;
    }

    public void setZoneInX(int zoneInX) {
        this.zoneInX = zoneInX;
    }

    public int getZoneInY() {
        return zoneInY;
    }

    public void setZoneInY(int zoneInY) {
        this.zoneInY = zoneInY;
    }

    public int getZoneOutX() {
        return zoneOutX;
    }

    public void setZoneOutX(int zoneOutX) {
        this.zoneOutX = zoneOutX;
    }

    public int getZoneOutY() {
        return zoneOutY;
    }

    public void setZoneOutY(int zoneOutY) {
        this.zoneOutY = zoneOutY;
    }

    public Map getMapa() {
        return mapa;
    }

    public void setMapa(Map mapa) {
        this.mapa = mapa;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public int getDistanceToZone() {
        return distanceToZone;
    }

    public void setDistanceToZone(int distanceToZone) {
        this.distanceToZone = distanceToZone;
    }

    public long getMaxSystemSpeed() {
        return maxSystemSpeed;
    }

//    public void setMaxSystemSpeed(long maxSystemSpeed) {
//        this.maxSystemSpeed = maxSystemSpeed;
//    }

    public long getMaxSpeed() {
        return maxSpeed;
    }

    public boolean setMaxSpeed(long maxSpeed) {
        if (maxSpeed <= maxSystemSpeed) {
            this.myOldMaxSpeed = this.maxSpeed;
            this.maxSpeed = maxSpeed;
            return true;
        } else {
            return false;
        }
    }

    public int getSpeed() {
        return speed;
    }

    public boolean setSpeed(int newSpeed) {
        if (newSpeed > maxSpeed) {
            return false;
        } else {
            this.myOldSpeed = speed;
            this.speed = newSpeed;
            return true;
        }
    }
    
    public void returnOldSpeeds(){
        this.maxSpeed = myOldMaxSpeed;
        speed = myOldSpeed;
    }

    private class TremThread implements Runnable {

        Train trem;

        public TremThread(Train trem) {
            this.trem = trem;
        }

        @Override
        public void run() {
            while (true) {
                if (speed != 0) {
                    if (calculador.isEntryingZone(trem)) {
                        /*
                            Calcula quem é o primeiro trem a entrar;
                            Calcula o tempo que o trem que está na zona vai demorar
                        dentro da zona.
                            muda a velocidade dos outros.
                         */
                        
                        Train firstTrain = calculador.firstToEnter(trem);
                        trem.setSpeed(10);
//                        
//                        System.out.println("-------------------");
//                        System.out.println("Velocidade maxima = " + trem.getMaxSpeed());
//                        System.out.println("Velocidade do trem na zona = " + trem.getSpeed());
                        int timeInZone = calculador.timeInZone(trem);
//                        System.out.println("TimeInZone = " + timeInZone);
//                        System.out.println(firstTrain.getId());
                        calculador.changeSpeedsInByTime(trem, timeInZone, firstTrain);
                        
                        move();
                        distanceToZone--;
                    } else if (calculador.isInZone(trem)) {
                        if (calculador.isLeavingZone(trem)) {
                       
//                            calculador.changeSpeedsIn(trem, 10);
                            calculador.returnOldSpeeds();
                            calculador.putDistance(trem);
                            move();
                        } else {
                            move();
                        }
                    } else {
                        distanceToZone--;
                        move();
                    }
                    mapa.repaint();
                }
                try {
                    if (speed != 0) {
                        sleep(100 / speed);
                    } else {
                        sleep(10);
                    }
                } catch (InterruptedException ex) {
                    Logger.getLogger(Train.class.getName()).log(Level.SEVERE, null, ex);
                }

            }
        }

        public void move() {
            int auxX;
            int auxY;
            if (x != maxX && y == minY) {
                x++;
//                if ((x + speed) > maxX) {
//                    auxX = maxX - x;
//                    auxY = speed - auxX;
//                    x = maxX;
//                    y += auxY;
//                } else {
//                    x += speed;
//                }
            } else if (x != minX && y == maxY) {
                x--;
//                if ((x - speed) < minX) {
//                    auxX = x - minX;
//                    auxY = speed - auxX;
//                    x = minX;
//                    y -= auxY;
//                } else {
//                    x -= speed;
//                }
            } else if (x == maxX && y != maxY) {
                y++;
//                if ((y + speed) > maxY) {
//                    auxY = maxY - y;
//                    auxX = speed - auxY;
//                    y = maxY;
//                    x -= auxX;
//                } else {
//                    y += speed;
//                }
            } else if (x == minX && y != minY) {
                y--;
//                if ((y - speed) < minY) {
//                    auxY = y - minY;
//                    auxX = speed - auxY;
//                    y = minY;
//                    x += auxX;
//                } else {
//                    y -= speed;
//                }
            }
        }
    }
}
