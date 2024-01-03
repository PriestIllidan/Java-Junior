package client;

import java.io.IOException;
import java.net.InetAddress;
import java.net.Socket;
import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите ваше имя: ");
        String name = scanner.nextLine();
        try {
            Socket socket = new Socket("localhost", 1500);
            InetAddress inetAddress = socket.getInetAddress();
            Client client = new Client(socket, name);
            System.out.println("Inetadress: " + inetAddress);
            String remoteIP = inetAddress.getHostAddress();
            System.out.println("Remote IP: " + remoteIP);
            System.out.println("LocalPort: " + socket.getLocalPort());

            client.listenForMessage();
            client.sendMessage();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
