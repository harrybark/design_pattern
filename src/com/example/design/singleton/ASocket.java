package com.example.design.singleton;

public class ASocket {

    private SocketClient socketClient;

    public ASocket() {
        this.socketClient = SocketClient.getInstance();
    }

    public SocketClient getSocketClient() {
        return socketClient;
    }
}
