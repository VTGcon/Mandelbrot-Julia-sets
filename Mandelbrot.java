import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.*;

public class Mandelbrot extends JPanel {
	public double newX;
	public double newY;
	public double zoom;

	public Mandelbrot(double newX, double newY, double zoom) {
		this.newX = newX;
		this.newY = newY;
		this.zoom = zoom;
	}

	public static void setNewX(double newX, Mandelbrot m) {
		m.newX = newX;
	}

	public static void setNewY(double newY, Mandelbrot m) {
		m.newY = newY;
	}

	public static void setzoom(double zoom, Mandelbrot m) {
		m.zoom = zoom;
	}

	@Override
	protected void paintComponent(Graphics arg0) {
		Graphics2D g2d = (Graphics2D) arg0;
		for (int i = 0; i <= getWidth(); i++) {
			for (int j = 0; j <= getHeight(); j++) {
				double x = (i-getWidth()/2)*2*zoom/getWidth()+newX;
				double y = (j-getHeight()/2)*2*zoom/getHeight()-newY;
				Complex z0 = new Complex(x, y);
				Complex z = new Complex(x, y);
				for (int k = 0; k <= 255; k++) {
					if (Complex.abs(z) >= 2) {
						g2d.setColor(new Color((int) (k % 255), (int) (k * k % 255), (int) (k * k * k % 255)));
						break;
					} else {
						Complex tmp = Complex.multiply(z, z);
						tmp = Complex.add(tmp, z0);
						z = tmp;
					}
				}
				g2d.drawLine(i, j, i + 1, j + 1);
			}
		}
	}
}
