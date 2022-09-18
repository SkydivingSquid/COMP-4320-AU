import javax.xml.crypto.Data;
import java.io.*;
import java.net.*;
import java.util.Locale;

public class client {
    public static void main(String[] args) throws Exception {
        try {

            BufferedReader inFromUser = new BufferedReader(new InputStreamReader(System.in));

            DatagramSocket clientSocket = new DatagramSocket();

            InetAddress IPAddress = InetAddress.getByName("hostname");

            byte[] sendData = new byte[1024];
            byte[] receiveData = new byte[1024];

            String sentence = inFromUser.readLine();
            sendData = sentence.getBytes();

            DatagramPacket sendPacket = new DatagramPacket(sendData, sendData.length, IPAddress, 10001);

            clientSocket.send(sendPacket);

            DatagramPacket receivePacket = new DatagramPacket(receiveData, receiveData.length);

            clientSocket.receive(receivePacket);

            String modifiedSentence = new String(receivePacket.getData());

            System.out.println("FROM SERVER: " + modifiedSentence);
            clientSocket.close();

        } catch (Exception e) {
            System.out.println(e);
        }
    }

    }

