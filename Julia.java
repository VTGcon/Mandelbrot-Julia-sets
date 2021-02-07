import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.*;

public class Julia extends JPanel {
    public double para;
    public double parb;
    public double newX;
    public double newY;
    public double zoom;


    public Julia(double para, double parb, double newX, double newY, double zoom){
        this.para =  para;
        this.parb = parb;
        this.newX = newX;
        this.newY = newY;
        this.zoom = zoom;
    }
    public static void setNewX(double newX, Julia j){
        j.newX = newX;
    }
    public static void setNewY(double newY, Julia j){
        j.newY = newY;
    }
    public static void setzoom(double zoom, Julia j){
        j.zoom = zoom;
    }
    public static void setA(double para, Julia j){
        j.para =para;
    }
    public static void  setB(double parb, Julia j){
        j.parb = parb;
    }


    @Override
    protected void paintComponent(Graphics arg0) {
        Graphics2D g2d = (Graphics2D) arg0;
        for (int i = 0; i <= getWidth(); i++) {
            for (int j = 0; j <= getHeight(); j++) {
                double x =(i-getWidth()/2)*2*zoom/getWidth()+newX;
                double y =(j-getHeight()/2)*2*zoom/getHeight()-newY;
                Complex z0 = new Complex(para, parb);
                Complex z = new Complex(x, y);
                for (int k = 0; k <= 255; k++) {
                    if (Complex.abs(z) >= 2) {
                        g2d.setColor(new Color((int)(k % 255), (int)(k*k % 255), (int)(k*k*k % 255)));
                        break;
                    } else {
                        Complex tmp = Complex.multiply(z, z);
                        tmp = Complex.add(tmp, z0);
                        z = tmp;
                    }
                }
                g2d.drawLine(i, j, i+1, j+1);
            }
        }
    }
}
