/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import Model.Mapa;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.List;
import java.awt.Rectangle;
import java.awt.Shape;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Random;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;

/**
 *
 * @author victor
 */
public class Main extends JFrame{
    
    
    public Main() {
        System.out.println("as".equalsIgnoreCase(null));
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        init();
        pack();
        setVisible(true);
    }

    private void init() {
        final Design d = new Design();
        d.addRect(0,0,10,20);

        JButton b = new JButton("add");
        b.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                Random r = new Random();
                int w = r.nextInt(100);
                int h = r.nextInt(100);
                d.addRect(0,0,w,h);
            }
        });
        add(d);
        add(b,BorderLayout.SOUTH);
    }

    public static void main(String... strings) {
        new Main();
    }

    private class Design extends JComponent {
        private static final long serialVersionUID = 1L;

        private ArrayList<Shape> shapes = new ArrayList<Shape>();

        public void paint(Graphics g) {
            super.paintComponent(g);
            Graphics2D g2d = (Graphics2D) g;
            for(Shape s : shapes){
                g2d.draw(s);
            }
        }

        public void addRect(int xPos, int yPos, int width, int height) {
            shapes.add(new Rectangle(xPos,yPos,width,height));
            repaint();
        }

        @Override
        public Dimension getPreferredSize() {
            return new Dimension(100,100);
        }

    }
    
}
