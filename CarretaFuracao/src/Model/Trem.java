/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JTextField;
import static java.lang.Thread.sleep;

/**
 *
 * @author victor
 */
public class Trem {
    private Calculo calculador;
    private int id;
    private int maxX;
    private int minX;
    private int maxY;
    private int minY;
    private int zoneInX;
    private int zoneInY;
    private int zoneOutX;
    private int zoneOutY;
    private Mapa mapa;
    private int x;
    private int y;
    private long maxSystemSpeed = 10;
    private long maxSpeed = 10;
    private int speed = 0;
    private int distanceToZone;
//    public boolean id;
    // private int cont;
    private JButton botao;
    private JTextField campoVelocidade;

    public Trem(int id, int maxX, int minX, int maxY, int minY, Mapa mapa, int x, int y,
            int zoneInX, int zoneInY, int zoneOutX, int zoneOutY, int dist) {
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
        calculador = new Calculo();
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

    public Mapa getMapa() {
        return mapa;
    }

    public void setMapa(Mapa mapa) {
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
    
    public void setId(int id){
        this.id = id;
    }
    
    public int getId(){
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

    public void setMaxSystemSpeed(long maxSystemSpeed) {
        this.maxSystemSpeed = maxSystemSpeed;
    }

    public long getMaxSpeed() {
        return maxSpeed;
    }

    public boolean setMaxSpeed(long maxSpeed) {
        if(maxSpeed <= maxSystemSpeed && maxSpeed >= 0){
            this.maxSpeed = maxSpeed;
            return true;
        }else
            return false;
    }
    
    public int getSpeed() {
        return speed;
    }

    public boolean setSpeed(int newSpeed) {
        if (newSpeed <= maxSystemSpeed && newSpeed >= 0) {
            this.speed = newSpeed / 2;
            return true;
        } else if (newSpeed <= maxSpeed && newSpeed >= 0) {
            this.speed = newSpeed;
            return true;
        } else {
            return false;
        }
    }

    private class TremThread implements Runnable {
        Trem trem;
        
        public TremThread(Trem trem){
            this.trem = trem;
        }
        
        @Override
        public void run() {
            int auxX;
            int auxY;
            while (true) {
                if(calculador.isEntryingZone(trem)){
                    System.out.println("Entrando");
                }
                else if(calculador.isInZone(trem)){
                    System.out.println("Posicao X: " + x + "Posicao Y: " + y);
                }else if(calculador.isLeavingZone(trem)){
                    
                }
                if (x != maxX && y == minY) {
                    if ((x + speed) > maxX) {
                        auxX = maxX - x;
                        auxY = speed - auxX;
                        x = maxX;
                        y += auxY;
                        
                    } else {
                        x += speed;
                    }
                } else if (x != minX && y == maxY) {
                    if ((x - speed) < minX) {
                        auxX = x - minX;
                        auxY = speed - auxX;
                        x = minX;
                        y -= auxY;
                    } else {
                        x -= speed;
                    }
                } else if (x == maxX && y != maxY) {
                    if ((y + speed) > maxY) {
                        auxY = maxY - y;
                        auxX = speed - auxY;
                        y = maxY;
                        x -= auxX;
                    } else {
                        y += speed;
                    }
                } else if (x == minX && y != minY) {
                    if ((y - speed) < minY) {
                        auxY = y - minY;
                        auxX = speed - auxY;
                        y = minY;
                        x += auxX;
                    } else {
                        y -= speed;
                    }
                }
                mapa.repaint();
                try {
                    sleep(10);
                } catch (InterruptedException ex) {
                    Logger.getLogger(Trem.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }
}
