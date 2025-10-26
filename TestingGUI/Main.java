package TestingGUI;

import javax.swing.JButton;
import javax.swing.JFrame;

public class Main {

    public static JFrame frame = new JFrame("Testing GUI");
    public static JButton button = new JButton("Click Me");
    public static void main(String[] args) {
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 300);
        frame.setVisible(true);

        button.addActionListener(e -> changeIt());
        frame.getContentPane().add(button);
    }

    public static void changeIt() {
        button.setText("I've been clicked!");
    }

}
