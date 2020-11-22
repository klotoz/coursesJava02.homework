package homework6;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class Server {
    private static int PORT = 8189;

    public static void main(String[] args) {
        ServerSocket server = null;
        Socket socket = null;
        try {
            server = new ServerSocket(PORT);
            System.out.println("Сервер запущен");
            socket = server.accept();
            System.out.println("Клиент подключился");
            Scanner in = new Scanner(socket.getInputStream());
            PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
            Scanner sc = new Scanner(System.in);

            new Thread (new Runnable() {
                @Override
                public void run() {
                    while (true){
                        System.out.println("Сервер: здесь можно писать");
                        String msg = sc.nextLine();
                        out.println(msg);
                    }
                }
            }).start();

            while (true){
                String str = in.nextLine();
                if (str.equals("/end")){
                    System.out.println("Клиент отключился");
                    break;
                }
                System.out.println("Клиент: " + str);
                // out.println("echo: " + str);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                socket.close();
                server.close();
                System.out.println("Сервер отключен");
                System.exit(0);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}

