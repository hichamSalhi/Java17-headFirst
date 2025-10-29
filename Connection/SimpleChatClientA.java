package Connection;

import java.awt.BorderLayout;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.InetSocketAddress;
import java.nio.channels.Channels;
import java.nio.channels.SocketChannel;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.WindowConstants;

public class SimpleChatClientA {
    private JTextField outgoing;
    private PrintWriter writer;

    public void go() {
        setUpNetworking();

        outgoing = new JTextField(20);
        JButton sendButton = new JButton("Send");
        sendButton.addActionListener(_ -> sendMessage());
        JPanel mainPanel = new JPanel();
        mainPanel.add(outgoing);
        mainPanel.add(sendButton);
        JFrame frame = new JFrame("Ludicrously Simple Chat Client");
        frame.getContentPane().add(BorderLayout.CENTER, mainPanel);
        frame.setSize(400, 100);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }

    private void setUpNetworking() {
        try {
            InetSocketAddress serverAddress = new InetSocketAddress("127.0.0.1", 5000);
            SocketChannel socketChannel = SocketChannel.open(serverAddress);
            writer = new PrintWriter(Channels.newWriter(socketChannel, "utf-8"));
        } catch (IOException e) {
            e.getStackTrace();
        }
    }

    private void sendMessage() {
        writer.println(outgoing.getText());
        writer.flush();
        outgoing.setText("");
        outgoing.requestFocus();
    }

    public static void main(String[] args) {
        SimpleChatClientA client = new SimpleChatClientA();
        client.go();
    }
}
