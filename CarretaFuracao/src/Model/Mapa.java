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
    private static Trem trem1;
    private static Trem trem2;
    private static Trem trem3;
    
    
    public Mapa() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(800, 600);
        setVisible(true);
    }

    public static void main(String[] args) {
        Mapa m = new Mapa();
        trem1 = new Trem(520, 270, 295, 170, m, 270, 170);
        trem2 = new Trem(395, 145, 545, 295, m, 145, 545);
        trem3 = new Trem(645, 395, 545, 295, m, 645, 545);

//        m.add(trem1.getBotao());
//        trem1.getBotao().setVisible(true);
//        trem1.getBotao().setSize(100, 50);

    }
    
    @Override
    public void paint(Graphics g) {
        super.paint(g);
        Graphics2D g2d = (Graphics2D) g.create();
        g2d.drawRect(150, 300, 250, 250);
        g2d.drawRect(400, 300, 250, 250);
        g2d.drawRect(275, 175, 250, 125);
        g2d.setColor(Color.RED);
        g2d.fillOval(trem1.x, trem1.y, 10, 10);
        g2d.fillOval(trem2.x, trem2.y, 10, 10);
        g2d.fillOval(trem3.x, trem3.y, 10, 10);
        
    }

}
