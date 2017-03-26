package com.zihua.testThread;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by zihua on 17-3-25.
 */
public class EmailServer {
    private ArrayList<Socket> list = new ArrayList<Socket>();
    private ServerSocket server;
    private ExecutorService execs;//线程池
    private final int poolSize = 20;//线程池大小
    private int port = 8888;


    public EmailServer() {
        try {
            server = new ServerSocket(port);
            execs = Executors.newFixedThreadPool(poolSize);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void service() {
        System.out.println("服务器启动成功");
        while (true) {
            Socket socket = null;
            try {
                socket = server.accept();
                list.add(socket);
                execs.execute(new TaskClient(socket));
            } catch (IOException e) {

            }
        }
    }

    public static void main(String[] args) {
        EmailServer server = new EmailServer();
        server.service();
    }


}
