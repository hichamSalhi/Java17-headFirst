package TestingGUI;



import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Graphics;
import java.util.concurrent.TimeUnit;

import javax.swing.*;

public class SimpleGui {
    JButton button; JButton changeLabel;
    JLabel label;
    JFrame frame ;
    
    int x = 70;
    int y = 70;

    public SimpleGui() {
        frame = new JFrame("Testing GUI");
        button = new JButton("Change Colors");
        changeLabel = new JButton("Change Label");
        label = new JLabel("I'm a label");
    }
    
    public static void main(String[] args) {
        SimpleGui gui = new SimpleGui();
        gui.go();
    }

    public void go() {
        //frame.getContentPane().add(BorderLayout.SOUTH,button);
        //frame.getContentPane().add(BorderLayout.EAST,changeLabel);
        //frame.getContentPane().add(BorderLayout.WEST,label);

        button.addActionListener(_ -> frame.repaint());
        changeLabel.addActionListener(_ -> label.setText("I've been changed!"));

        DrawPanel drawPanel = new DrawPanel();
        
        
        frame.getContentPane().add(BorderLayout.CENTER, drawPanel);

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 300);
        frame.setVisible(true);

        for (int i = 0; i < 130; i++) {
            x++;
            y++;
            drawPanel.repaint();
            try {
                TimeUnit.MILLISECONDS.sleep(50);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    class DrawPanel extends JPanel {
        public void paintComponent(Graphics g) {
            g.setColor(Color.white);
            g.fillRect(0, 0, this.getWidth(), this.getHeight());

            g.setColor(Color.green);
            g.fillOval(x, y, 40, 40);
        }
    }
}
