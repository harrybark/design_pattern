package com.example.design.adaptor;

public class Cleaner implements Electornic220V {

    @Override
    public void connect() {
        System.out.println("Cleaner 220V On");
    }
}
