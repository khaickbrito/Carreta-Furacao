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
public class Map extends JFrame {

    private static Train[] trem = new Train[3];
    private static Train trem1;
    private static Train trem2;
    private static Train trem3;
    private boolean podeEscrever = false;

    private static Map instance = new Map();

    public Map() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(800, 600);
        setVisible(true);
        trem[0] = null;
        trem[1] = null;
        trem[2] = null;
    }

    public static Map getInstance() {
        return instance;
    }
    
    public void addTrain(Train t) {
        trem[t.getId()] = t;
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        Graphics2D g2d = (Graphics2D) g.create();
        g2d.drawRect(150, 300, 250, 250);
        g2d.drawRect(400, 300, 250, 250);
        g2d.drawRect(275, 175, 250, 125);
        g2d.setColor(Color.RED);
        System.out.println("mapinha");
        if (trem[0] != null) {
            g2d.fillOval(trem[0].getX(), trem[0].getY(), 10, 10);
        }
        if (trem[1] != null) {
            g2d.fillOval(trem[1].getX(), trem[1].getY(), 10, 10);
        }
        if (trem[2] != null) {
            g2d.fillOval(trem[2].getX(), trem[2].getY(), 10, 10);
        }

    }

}
