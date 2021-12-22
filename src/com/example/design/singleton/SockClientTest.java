package com.example.design.singleton;

public class SockClientTest {

    public static void main(String[] args) {

        ASocket aSocket = new ASocket();
        BSocket bSocket = new BSocket();

        SocketClient aClient = aSocket.getSocketClient();
        SocketClient bClient = bSocket.getSocketClient();

        System.out.print("is it same Object? : ");
        System.out.println(aClient.equals(bClient));
    }
}
