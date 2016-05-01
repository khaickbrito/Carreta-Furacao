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

/**
 *
 * @author victor
 */
public class Trem{
    private int maxX;
    private int minX;
    private int maxY;
    private int minY;
    private Mapa mapa;
    public int x;
    public int y;
    public long velocidade = 15;
    private int cont;
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

    public JTextField getCampoVelocidade() {
        return campoVelocidade;
    }
    
    private class TremThread implements Runnable{
        
        @Override
        public void run() {
            while(true){
                if(x != maxX && y == minY){
                    x++;
                }else if(x != minX && y == maxY){
                    x--;
                }else if(x == maxX && y != maxY){
                    y++;
                }else if(x == minX && y != minY){
                    y--;
                }
                mapa.repaint();
                try {
                    sleep(velocidade);
                } catch (InterruptedException ex) {
                    Logger.getLogger(Trem.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }
}
