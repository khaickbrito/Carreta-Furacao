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
import static java.lang.Thread.sleep;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JComponent;

/**
 *
 * @author victor
 */
public class Trem extends JComponent implements Runnable {

    private int x;
    private int y;
    private Graphics g2d;
    public Trem(Graphics g, int x, int y) {
        this.x = x;
        this.y = y;
        Graphics2D g2d = (Graphics2D) g.create();
        this.g2d = g2d;
        
    }
    
   

    @Override
    public void run() {
        for (int i = 0; i < 250; i++) {
            g2d.setColor(Color.RED);
            g2d.fillRoundRect(this.x, this.y, 10, 10, 100, 100);
            
            repaint();
            this.x += 1;
            try {
                sleep(10);
                
                //g2d.setColor(Color.BLACK);
            } catch (InterruptedException ex) {
                Logger.getLogger(Trem.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
        
    }

}
