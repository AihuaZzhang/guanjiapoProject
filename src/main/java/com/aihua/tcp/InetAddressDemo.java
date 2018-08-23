package com.aihua.tcp;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class InetAddressDemo {
    public static void main(String[] args) throws UnknownHostException{
        funcion();
    }

    public static void funcion() throws UnknownHostException{
        InetAddress inet = InetAddress.getLocalHost();
        System.out.println(inet);

        System.out.println(inet.getHostAddress());
        System.out.println(inet.getHostName());
    }
}
