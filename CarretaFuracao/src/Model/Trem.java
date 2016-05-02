/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Paint;
import java.awt.Transparency;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import static java.lang.Thread.sleep;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JTextField;
import javax.swing.plaf.basic.BasicArrowButton;
import static java.lang.Thread.sleep;
import static java.lang.Thread.sleep;
import static java.lang.Thread.sleep;
import static java.lang.Thread.sleep;
import static java.lang.Thread.sleep;
import static java.lang.Thread.sleep;
import static java.lang.Thread.sleep;

/**
 *
 * @author victor
 */
public class Trem {
    private boolean token;
    private int maxX;
    private int minX;
    private int maxY;
    private int minY;
    private Mapa mapa;
    public int x;
    public int y;
    public long maxSystemSpeed = 10;
    public long maxSpeed = 10;
    public int speed = 1;

   // private int cont;
    private JButton botao;
    private JTextField campoVelocidade;

    public Trem(int maxX, int minX, int maxY, int minY, Mapa mapa, int x, int y) {
        this.maxX = maxX;
        this.minX = minX;
        this.maxY = maxY;
        this.minY = minY;
        this.mapa = mapa;
        this.x = x;
        this.y = y;
        new Thread(new TremThread()).start();

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

    public boolean isToken() {
        return token;
    }
    
    public void setToken(boolean token) {
        this.token = token;
    }

    public JTextField getCampoVelocidade() {
        return campoVelocidade;
    }

    public double getVelocidadeMetrosPorSegundo(){
        return (speed*200);
    }
    
    public void setMaxSpeed(int newSpeed){
        speed = newSpeed;
    }
    
    public boolean setSpeed(int newSpeed){
        if(token == true && newSpeed <= maxSystemSpeed){
            this.speed = newSpeed/2;
            return true;
        }else if (token == false && newSpeed <= maxSpeed){
            this.speed = newSpeed;
            return true;
        }else
            return false;
    }
    
    private class TremThread implements Runnable {

        @Override
        public void run() {
            int auxX;
            int auxY;
            while (true) {
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
