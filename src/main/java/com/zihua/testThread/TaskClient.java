package com.zihua.testThread;

import java.io.*;
import java.net.Socket;

/**
 * Created by zihua on 17-3-25.
 */
public class TaskClient implements Runnable {
    private Socket socket;
    private DataOutputStream output;
    private DataInputStream input;

    public TaskClient(Socket socket) {
        this.socket = socket;
    }

    public void run() {
        while (true) {
            try {
                output = new DataOutputStream(socket.getOutputStream());
                input = new DataInputStream(socket.getInputStream());
                String msg = input.readUTF();
                System.out.println("client msg: " + msg);
                String resp = "系统消息";
                output.writeUTF(resp);
                output.flush();
            } catch (IOException e) {
                //e.printStackTrace();
                System.out.println("用户退出");
                break;
            }
        }
    }
}
