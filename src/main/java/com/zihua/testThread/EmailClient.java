package com.zihua.testThread;

import java.io.*;
import java.net.Socket;

/**
 * Created by zihua on 17-3-26.
 */
public class EmailClient {
    private Socket socket;
    private boolean isConnect = false;
    private DataOutputStream output;
    private DataInputStream input;


    public void connect(String ip, int port) {
        try {
            socket = new Socket(ip, port);
            output = new DataOutputStream(socket.getOutputStream());
            input = new DataInputStream(socket.getInputStream());
            isConnect = true;
            System.out.println("连接成功");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void sendMsg(String msg) {
        if (isConnect) {
            try {
                output.writeUTF(msg);
                output.flush();
                String rep = input.readUTF();
                System.out.println(rep);

            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        EmailClient client = new EmailClient();
        client.connect("127.0.0.1", 8888);
        client.sendMsg("gogogogogogogogog");

    }
}
