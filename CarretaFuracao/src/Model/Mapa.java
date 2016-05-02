/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import com.sun.glass.ui.Cursor;
import java.awt.AlphaComposite;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import javax.swing.JComponent;
import javax.swing.JFrame;

/**
 *
 * @author victor
 */
public class Mapa extends JFrame {

    private static Trem[] trem = new Trem[3];
    private static Trem trem1;
    private static Trem trem2;
    private static Trem trem3;
    private boolean podeEscrever = false;

    private static Mapa instance = new Mapa();

    public Mapa() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(800, 600);
        setVisible(true);
        trem[0] = null;
        trem[1] = null;
        trem[2] = null;
    }

    public static Mapa getInstance() {
        return instance;
    }

//    public void startMap() {
//        Mapa m = Mapa.getInstance();
//        trem1 = new Trem(520, 270, 295, 170, m, 270, 170);
//        trem2 = new Trem(395, 145, 545, 295, m, 145, 545);
//        trem3 = new Trem(645, 395, 545, 295, m, 645, 545);
//    }
    
    public void addTrain(Trem t) {

        for (int i = 0; i < 3; i++) {
            if (trem[i] == null) {
                trem[i] = t;

                if (trem[2] != null) {
                    podeEscrever = true;
                }
                break;
            }
            
        }

//        trem[0] = new Trem(520, 270, 295, 170, instance, 270, 170);
//        trem[1] = new Trem(395, 145, 545, 295, instance, 145, 545);
//        trem[2] = new Trem(645, 395, 545, 295, instance, 645, 545);
    }

//    public static void main(String[] args) {
//        Mapa m = new Mapa();
//        trem1 = new Trem(520, 270, 295, 170, m, 270, 170);
//        trem2 = new Trem(395, 145, 545, 295, m, 145, 545);
//        trem3 = new Trem(645, 395, 545, 295, m, 645, 545);
//
////        m.add(trem1.getBotao());
////        trem1.getBotao().setVisible(true);
////        trem1.getBotao().setSize(100, 50);
//
//    }
    @Override
    public void paint(Graphics g) {
        super.paint(g);
        Graphics2D g2d = (Graphics2D) g.create();
        g2d.drawRect(150, 300, 250, 250);
        g2d.drawRect(400, 300, 250, 250);
        g2d.drawRect(275, 175, 250, 125);
        g2d.setColor(Color.RED);
        if (trem[0] != null) {
            g2d.fillOval(trem[0].x, trem[0].y, 10, 10);
        }
        if (trem[1] != null) {
            g2d.fillOval(trem[1].x, trem[1].y, 10, 10);
        }
        if (trem[2] != null) {
            g2d.fillOval(trem[2].x, trem[2].y, 10, 10);
        }

    }

}
