package com.example.design.adaptor;

public class AdaptorSocket implements Electornic110V {

    private Electornic220V electornic220V;

    public AdaptorSocket(Electornic220V electornic220V) {
        this.electornic220V = electornic220V;
    }

    @Override
    public void powerOn() {
        electornic220V.connect();
    }
}
