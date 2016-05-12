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
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.colorchooser.AbstractColorChooserPanel;

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
    private static javax.swing.JLabel myIdLabel;
    private javax.swing.JTextField speedField;
    private javax.swing.JLabel speedTrain0;
    private javax.swing.JLabel speedTrain1;
    private javax.swing.JLabel speedTrain2;
    
    public Map(TrainController c, int id) {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(900, 600);
        setVisible(true);
        trem[0] = null;
        trem[1] = null;
        trem[2] = null;
        this.id = id;
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
        JPanel aux = new JPanel();
        
        
        jLabel1.setText("TRAIN 0");
        
        jLabel2.setText("TRAIN 1");

        jLabel3.setText("TRAIN 2");

        jButton1.setText("CHANGE SPEED");


        jLabel4.setText("My ID");

        myIdLabel.setText("00000");

       

        jLabel5.setText("Speed");

        jLabel6.setText("Speed");

        jLabel7.setText("Speed");

        speedTrain0.setText("0");

        speedTrain1.setText("0");

        speedTrain2.setText("0");
        
        
        trem0.add(jLabel1);
        trem0.add(jLabel5);
        trem0.add(speedTrain0);
        speedTrain0.setText("0");
        trem0.setBounds(20, 20, 200, 20);
        this.add(trem0);
        
        trem1.add(jLabel2);
        trem1.add(jLabel6);
        trem1.add(speedTrain1);
        speedTrain1.setText("0");
        trem1.setBounds(20, 40, 200, 20);
        this.add(trem1);
        
        trem2.add(jLabel3);
        trem2.add(jLabel7);
        trem2.add(speedTrain2);
        speedTrain2.setText("0");
        trem2.setBounds(20, 60, 200, 20);
        this.add(trem2);
        
        painel.add(jButton1);
        speedField.setBounds(725, 60, 50, 20);
        jLabel4.setBounds(400, 20, 30, 30);
        myIdLabel.setBounds(435, 20, 30, 30);
        this.add(jLabel4);
        this.add(myIdLabel);
        this.add(speedField);
        painel.setBounds(650,20,200,200);
        this.add(painel);
        
        JFrame frame = this;
        
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                int speed = Integer.parseInt(speedField.getText());
                long maxSpeed = trem[id].getMaxSpeed();
                long maxSystemSpeed = trem[id].getMaxSystemSpeed();
                if(speed < 0  || speed > 10)
                    JOptionPane.showMessageDialog(frame, "Put a correct speed value:(0-" + maxSystemSpeed + ").", "Error", JOptionPane.ERROR_MESSAGE);
                else if(speed > maxSpeed)
                    JOptionPane.showMessageDialog(frame, "Pierced limit. Put a correct speed value:(0-" + maxSpeed + ").", "Error", JOptionPane.ERROR_MESSAGE);
                else{
                    control.changeSpeed(id, speed);
                    control.changeTrainInfoRMI(id, speed);
                }        
            }
        });
        
        this.add(aux);
        
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
    
    public static void showId() {
        myIdLabel.setText(Integer.toString(id));
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
