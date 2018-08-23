package com.aihua.tcp;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class UDPReceive {
    public static void main(String[] args) throws IOException{
        //创建数据包传输对象 绑定端口号
        DatagramSocket ds = new DatagramSocket(6000);
        //创建字节数组
        byte[] data = new byte[1024];
        //创建数据包对象 传递字节数组
        DatagramPacket dp = new DatagramPacket(data,data.length);
        ds.receive(dp);//线程阻塞

        //拆包
        //接收到的字节个数
        int length = dp.getLength();
        //发送端的IP地址对象
        String ip = dp.getAddress().getHostAddress();
        //发送放的端口号
        int port = dp.getPort();

        System.out.println(new String(data,0,length));
        ds.close();
    }
}
