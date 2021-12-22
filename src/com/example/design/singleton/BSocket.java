package com.example.design.singleton;

public class BSocket {

    private SocketClient socketClient;

    public BSocket() {
        this.socketClient = SocketClient.getInstance();
    }

    public SocketClient getSocketClient() {
        return socketClient;
    }
}
