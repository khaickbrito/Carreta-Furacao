/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import Controller.TrainController;
import com.sun.glass.ui.Cursor;
import java.awt.AlphaComposite;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 *
 * @author victor
 */
public class Map extends JFrame {

    private static Train[] trem = new Train[3];
    private static TrainController control;
    private static Train trem1;
    private static Train trem2;
    private static Train trem3;
    private boolean podeEscrever = false;
    public static int id;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel myIdLabel;
    private javax.swing.JTextField speedField;
    private javax.swing.JLabel speedTrain0;
    private javax.swing.JLabel speedTrain1;
    private javax.swing.JLabel speedTrain2;
    
    public Map(TrainController c) {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(900, 800);
        setVisible(true);
        trem[0] = null;
        trem[1] = null;
        trem[2] = null;
        control = c;
    
                jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        myIdLabel = new javax.swing.JLabel();
        speedField = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        speedTrain0 = new javax.swing.JLabel();
        speedTrain1 = new javax.swing.JLabel();
        speedTrain2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        
        JPanel trem0 = new JPanel();
        JPanel trem1 = new JPanel();
        JPanel trem2 = new JPanel();
        JPanel painel = new JPanel();
        
        
        jLabel1.setText("TRAIN 0");
        
        jLabel2.setText("TRAIN 1");

        jLabel3.setText("TRAIN 2");

        jButton1.setText("CHANGE");


        jLabel4.setText("My ID");

        myIdLabel.setText("jLabel5");

       

        jLabel5.setText("Speed");

        jLabel6.setText("Speed");

        jLabel7.setText("Speed");

        speedTrain0.setText("jLabel8");

        speedTrain1.setText("jLabel8");

        speedTrain2.setText("jLabel8");
        
        trem0.add(jLabel1);
        trem0.add(jLabel5);
        trem0.add(speedTrain0);
        trem0.setBounds(20, 20, 200, 20);
        this.add(trem0);
        
        trem1.add(jLabel2);
        trem1.add(jLabel6);
        trem1.add(speedTrain1);
        trem1.setBounds(20, 40, 200, 20);
        this.add(trem1);
        
        trem2.add(jLabel3);
        trem2.add(jLabel7);
        trem2.add(speedTrain2);
        trem2.setBounds(20, 60, 200, 20);
        this.add(trem2);
        
        painel.add(jLabel4);
        
        this.add(painel);
        
        
        
    }

    public void changeSpeed(int id, int speed){
        if(id == 0){
            speedTrain0.setText(Integer.toString(speed));
        }
        else if(id == 1){
            speedTrain1.setText(Integer.toString(speed));
        }
        else if(id == 2){
            speedTrain2.setText(Integer.toString(speed));
        }
    }
    
    public void addTrain(Train t) {
        trem[t.getId()] = t;
    }
    
    public static void setId(int id) {
        Map.id = id;
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        Graphics2D g2d = (Graphics2D) g.create();
        g2d.drawRect(150, 300, 250, 250);
        g2d.drawRect(400, 300, 250, 250);
        g2d.drawRect(275, 175, 250, 125);
        g2d.setColor(Color.RED);
        if (trem[0] != null) {
            if (id == 0) {
                g2d.setColor(Color.blue);
            }
            g2d.fillOval(trem[0].getX(), trem[0].getY(), 10, 10);
            g2d.setColor(Color.red);

        }
        if (trem[1] != null) {
            if (id == 1) {
                g2d.setColor(Color.blue);
            }
            g2d.fillOval(trem[1].getX(), trem[1].getY(), 10, 10);
            g2d.setColor(Color.red);
        }
        if (trem[2] != null) {
            if (id == 2) {
                g2d.setColor(Color.blue);
            }
            g2d.fillOval(trem[2].getX(), trem[2].getY(), 10, 10);
            g2d.setColor(Color.red);
        }

    }

}
