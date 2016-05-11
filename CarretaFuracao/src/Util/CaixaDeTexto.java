/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Util;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.concurrent.Semaphore;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 *
 * @author victor
 */
public class CaixaDeTexto {

    private static String ipServidor;
    private static Semaphore semaforo = new Semaphore(1);

    public static String pedirIP() {
        JPanel panel = new JPanel(null);
        panel.setSize(300, 100);

        JLabel pergunta = new JLabel("Digite o IP de um dos trens");
        pergunta.setBounds(0, 0, 300, 50);
        JPanel panel2 = new JPanel();
        JTextField caixaDeTexto = new JTextField();
        caixaDeTexto.setBounds(0, 50, 125, 30);
        JButton botao = new JButton();
        botao.setText("Conectar");
        botao.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ipServidor = caixaDeTexto.getText();
                semaforo.release();
            }
        });
        botao.setBounds(130, 50, 100, 30);
        JFrame frame = new JFrame("Trem 1");

        panel.add(pergunta);
        panel.add(caixaDeTexto);
        panel.add(botao);

        frame.add(panel);
        frame.setSize(350, 110);
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
