package com.aihua.tcp;

//实现udp协议的发送  datagramPacket/Socket

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.UnknownHostException;

public class UDPSend {
    public static void main(String[] args) throws IOException{
        //创建数据包对象 封装要发送的数据 接收端的IP 端口
        byte[] data = "你好UDP".getBytes();
        InetAddress inet = InetAddress.getByName("127.0.0.1");
        DatagramPacket packet = new DatagramPacket(data,data.length,inet,6000);//数据 接收端的IP和端口
        //创建datagramSocket
        DatagramSocket ds = new DatagramSocket();
        ds.send(packet);
        ds.close();
    }

}
