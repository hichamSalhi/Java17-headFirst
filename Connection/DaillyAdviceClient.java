package Connection;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.Reader;
import java.net.InetSocketAddress;
import java.nio.channels.Channels;
import java.nio.channels.SocketChannel;

public class DaillyAdviceClient {
    public void go() {
        // InetSocketAdress represents the machine we want to connect to
        InetSocketAddress serverAddress = new InetSocketAddress("127.0.0.1", 5000);

        // We use the socketChannel to talk to other machine
        // Im using try-with-resources to auto close the channel
        try (SocketChannel socketChannel = SocketChannel.open(serverAddress)) {

            // The reader reeds the bytes from the channel and decodes them to characters
            Reader channelReader = Channels.newReader(socketChannel, "UTF-8");

            // BufferedReader allows us to read a line at a time from the reader
            BufferedReader reader = new BufferedReader(channelReader);

            String advice = reader.readLine();
            System.out.println("Today you should: " + advice);
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        DaillyAdviceClient client = new DaillyAdviceClient();
        client.go();
    }
}
