/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Transparency;
import javax.swing.JComponent;

/**
 *
 * @author victor
 */
public class Trem extends JComponent implements Runnable {
    
   public Trem(){
    
       
   }
   
   public void paint(Graphics g){
      Graphics2D g2d = (Graphics2D)g.create();
      g2d.setColor(Color.RED);
      g2d.drawRect(100, 100, 10, 10);
   }
    
   
    
    @Override
    public void run() {
        
    }
    
}
