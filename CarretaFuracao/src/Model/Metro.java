/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.geom.Ellipse2D;

/**
 *
 * @author victor
 */
public class Metro {

    private float velocidade = 100;
    
    private int tamanho = 10;

    private int x;

    private int y;

    private int limInfX;
    
    private int limSupX;
    
    private int limInfY;
    
    private int limSupY;
    
    public Metro(int infX, int supX, int infY, int supY, int x, int y) {
        this.x = x;
        this.y = y;
        limInfX = infX;
        limSupX = supX;
        limInfY = infY;
        limSupY = supY;
    }

    public void update(long time) {
        //MODIFICAR ISSO PARA NOSSO PROBLEMA
        //O tempo é em milis. Para obter em segundos, precisamos dividi-lo por 1000.		
        x += (time * velocidade) / 1000;
        y += (time * velocidade) / 1000;
        
    }

    public void draw(Graphics2D g2d) {
        Graphics2D g = (Graphics2D) g2d.create();

        //g.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g.setColor(Color.RED);
        g.fill(new Ellipse2D.Float(x, y, tamanho, tamanho));
        g.dispose();
    }

}
