package com.example.design.adaptor;

public class AirConditioner implements Electornic220V {

    @Override
    public void connect() {
        System.out.println("Air Conditioner 220V On");
    }
}
