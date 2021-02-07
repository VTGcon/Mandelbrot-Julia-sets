import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
public class Main {
    public static void main(String args[]) {
        JFrame window = new JFrame("Sets");
        window.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        window.setSize(800, 600);
        JPanel up = new JPanel();
        JPanel mid = new JPanel();
        Mandelbrot mandelbrot = new Mandelbrot(0, 0, 2);
        Julia julia = new Julia(0, 0,0, 0, 2);
        JPanel left = new JPanel();
        JPanel down = new JPanel();
        window.add(mid, BorderLayout.CENTER);
        up.setLayout(new GridLayout(2, 6));
        ButtonGroup bgUp = new ButtonGroup();
        JRadioButton rbMandel = new JRadioButton("Mandelbrot");
        JLabel lAlpha = new JLabel("Alpha");
        JScrollBar alpha = new JScrollBar(JScrollBar.HORIZONTAL);
        JButton redraw = new JButton("redraw");
        JButton restart = new JButton("restart");
        JRadioButton rbJulia = new JRadioButton("Julia");
        JLabel lBetta = new JLabel("Betta");
        JScrollBar betta = new JScrollBar(JScrollBar.HORIZONTAL);
        JLabel Valuealpha = new JLabel(Double.toString(1.0*alpha.getValue()/100.0));
        JLabel Valuebetta = new JLabel(Double.toString(1.0*betta.getValue()/100));
        down.setLayout(new FlowLayout());
        JTextField x = new JTextField(5);
        x.setToolTipText("x");
        x.setText("0");
        JTextField y = new JTextField(5);
        y.setToolTipText("y");
        y.setText("0");
        JTextField z = new JTextField(5);
        z.setToolTipText("z");
        z.setText("2");
        rbMandel.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
        betta.addAdjustmentListener(new AdjustmentListener() {
            @Override
            public void adjustmentValueChanged(AdjustmentEvent e) {
            	Valuebetta.setText(Double.toString(betta.getValue() / 100.0));
                Julia.setB(betta.getValue()/100.0, julia);
                Julia.setA(alpha.getValue()/100.0, julia);
                window.repaint();
            }
        });
        alpha.addAdjustmentListener(new AdjustmentListener() {
            @Override
            public void adjustmentValueChanged(AdjustmentEvent e) {
            	Valuealpha.setText(Double.toString(alpha.getValue() / 100.0));
                Julia.setA(alpha.getValue()/100.0, julia);
                Julia.setB(betta.getValue()/100.0, julia);
                window.repaint();
            }
        });

       ;
        
       
        down.add(x);
        down.add(y);
        down.add(z);
        window.add(down, BorderLayout.SOUTH);
        down.setVisible(false);
        up.add(rbMandel);
        up.add(lAlpha);
        up.add(Valuealpha);
       
        up.add(redraw);
        up.add(rbJulia);
        up.add(lBetta);
        up.add(Valuebetta);
        up.add(restart);
       
        bgUp.add(rbMandel);
        bgUp.add(rbJulia);
        Valuealpha.setVisible(false);
        Valuebetta.setVisible(false);
        lAlpha.setVisible(false);
        lBetta.setVisible(false);
        alpha.setVisible(false);
        betta.setVisible(false);
    
        restart.setVisible(true);
        
               
                up.removeAll();
                up.revalidate();
                up.add(rbMandel);
                up.add(lAlpha);
                up.add(Valuealpha);
                up.add(alpha);
               
                up.add(redraw);
                up.add(rbJulia);
                up.add(lBetta);
                up.add(Valuebetta);
                up.add(betta);
                up.add(restart);
                rbMandel.setVisible(true);
                rbJulia.setVisible(true);
                redraw.setVisible(true);
                Valuealpha.setVisible(false);
                Valuebetta.setVisible(false);
                lAlpha.setVisible(false);
                lBetta.setVisible(false);
                alpha.setVisible(false);
                betta.setVisible(false);
             
                restart.setVisible(true);
                window.repaint();
         
        rbMandel.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e){
                mid.removeAll();
                mid.revalidate();
                mid.setLayout(new GridLayout(1, 0));
                mid.add(mandelbrot);
                alpha.setVisible(false);
                betta.setVisible(false);
                lAlpha.setVisible(false);
                lBetta.setVisible(false);
                Valuealpha.setVisible(false);
                Valuebetta.setVisible(false);
                
       
                window.repaint();
            }
        });
        rbJulia.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mid.removeAll();
                mid.revalidate();
                mid.setLayout(new GridLayout(1, 0));
                mid.add(julia);
                lAlpha.setVisible(true);
                lBetta.setVisible(true);
                Valuealpha.setVisible(true);
                Valuebetta.setVisible(true);
             
           
                alpha.setVisible(true);
                betta.setVisible(true);
                window.repaint();
            }
        });
        redraw.addActionListener((ActionEvent e) -> {
        	Valuealpha.setText(Double.toString(1.0*alpha.getValue()/100.0));
        	Valuebetta.setText(Double.toString(1.0*betta.getValue()/100.0));
            String sX = x.getText();
            String sY = y.getText();
            String sZ = z.getText();
            Mandelbrot.setNewX(Double.parseDouble(sX), mandelbrot);
            Mandelbrot.setNewY(Double.parseDouble(sY), mandelbrot);
            Mandelbrot.setzoom(Double.parseDouble(sZ), mandelbrot);
            Julia.setNewX(Double.parseDouble(sX), julia);
            Julia.setNewY(Double.parseDouble(sY), julia);
            Julia.setzoom(Double.parseDouble(sZ), julia);
            Julia.setA(1.0*alpha.getValue()/100.0, julia);
            Julia.setB(1.0*betta.getValue()/100.0, julia);
            
            window.repaint();
        });
        restart.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Mandelbrot.setNewX(0, mandelbrot);
                Mandelbrot.setNewY(0, mandelbrot);
                Mandelbrot.setzoom(4.0, mandelbrot);
                Julia.setNewX(0, julia);
                Julia.setNewY(0, julia);
                Julia.setzoom(4.0, julia);
                window.repaint();
            }
        });
        window.add(up, BorderLayout.NORTH);
        up.setVisible(false);
        left.setLayout(new BoxLayout(left, BoxLayout.Y_AXIS));
        JCheckBox ch1 = new JCheckBox("up panel");
        JCheckBox ch2 = new JCheckBox("down panel");
        left.add(ch1);
        left.add(ch2);
        ch1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                up.setVisible(!up.isVisible());
            }
        });
        ch2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                down.setVisible(!down.isVisible());
            }
        });
       
        window.add(left, BorderLayout.WEST);
        window.setVisible(true);
    }
}
