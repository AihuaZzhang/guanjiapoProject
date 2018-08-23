package com.aihua.tcp;

//实现tcp客户端 链接到服务器

import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;

public class TCPClient {
    public static void main(String[] args) throws IOException{
        Socket socket = new Socket("127.0.0.1",8888);
        OutputStream out = socket.getOutputStream();
        out.write("服务器OK".getBytes());

        socket.close();
    }
}
