/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Util;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.util.concurrent.Semaphore;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

/**
 *
 * @author victor
 */
public class CaixaDeTexto {

    private static int ipServidor;
    private static Semaphore semaforo = new Semaphore(1);

    public static int pedirIP() {
        JPanel panel = new JPanel(null);
        panel.setSize(300, 100);

        
        JRadioButton radio0 = new JRadioButton("Trem 0");
        radio0.setMnemonic(KeyEvent.VK_B);
        radio0.setActionCommand("Trem 0");
        radio0.setSelected(false);
        radio0.setBounds(0, 0, 100, 100);
        
        
        JRadioButton radio1 = new JRadioButton("Trem 1");
        radio1.setMnemonic(KeyEvent.VK_B);
        radio1.setActionCommand("Trem 0");
        radio1.setSelected(false);
        radio1.setBounds(100, 0, 100, 100);
        
        
        JRadioButton radio2 = new JRadioButton("Trem 2");
        radio2.setMnemonic(KeyEvent.VK_B);
        radio2.setActionCommand("Trem 0");
        radio2.setSelected(false);
        radio2.setBounds(200, 0, 100, 100);
        
//        caixaDeTexto.setBounds(300, 50, 100, 100);
        JButton botao = new JButton();
        botao.setText("Conectar");
        botao.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(radio0.isSelected())
                    ipServidor = 0;
                else if(radio1.isSelected())
                    ipServidor = 1;
                else if(radio2.isSelected())
                    ipServidor = 2;
                
           
                semaforo.release();
            }
        });
        botao.setBounds(300, 50, 100, 30);
        JFrame frame = new JFrame("Trem 1");

        
//        panel.add(caixaDeTexto);
        panel.add(botao);
        panel.add(radio0);
        panel.add(radio1);
        panel.add(radio2);

        frame.add(panel);
        frame.setSize(450, 110);
        frame.setResizable(false);
        frame.setVisible(true);

        try {
            semaforo.acquire();
            semaforo.acquire();
            semaforo.release();
        } catch (InterruptedException ex) {
            ex.printStackTrace();
        }

        frame.dispose();
        return ipServidor;
    }

}
