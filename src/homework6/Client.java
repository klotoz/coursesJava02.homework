package homework6;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class Client {

    public static void main(String[] args) {

        Socket socket = null;

        try {
            socket = new Socket("localhost", 8189);
            Scanner in =  new Scanner(socket.getInputStream());
            PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
            Scanner sc = new Scanner(System.in);

            Socket finalSocket = socket;
            new Thread(new Runnable() {
                @Override
                public void run() {
                    try {
                        while (true) {
                            String msg = in.nextLine();
                            System.out.println("Сервер: " + msg);
                            if (msg.equalsIgnoreCase("/end")){
                                break;
                            }
                        }
                    } finally {
                        try {
                            finalSocket.close();
                            System.exit(0);

                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }).start();


            while (true) {
                System.out.println("Напишите ваше сообщение...");
                String msg = sc.nextLine();

                out.println(msg);
            }

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                socket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}



