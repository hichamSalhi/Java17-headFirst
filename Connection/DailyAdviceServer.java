package Connection;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.InetSocketAddress;
import java.nio.channels.Channels;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.Random;

public class DailyAdviceServer {
    final private String[] adviceList = {
        "Take smaller bites",
        "Go for the tight jeans. No they do NOT make you look fat.",
        "One word: inappropriate",
        "Just for today, be honest. Tell your boss what you *really* think",
        "You might want to rethink that haircut."
    };
    
    private final Random random = new Random();

    public void go() {
        try (ServerSocketChannel serverChannel = ServerSocketChannel.open()) {
            // bind the server to every address on port 5000
            serverChannel.bind(new InetSocketAddress(5000));

            while (serverChannel.isOpen()) {
                SocketChannel clientChanel = serverChannel.accept();

                // Create a writer to send data to the client
                PrintWriter writer = new PrintWriter(Channels.newOutputStream(clientChanel));

                String advice = getAdvice();
                writer.println(advice);
                writer.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public String getAdvice() {
        int index = random.nextInt(adviceList.length);
        return adviceList[index];
    }

    public static void main(String[] args) {
        DailyAdviceServer server = new DailyAdviceServer();
        server.go();
    }
}
