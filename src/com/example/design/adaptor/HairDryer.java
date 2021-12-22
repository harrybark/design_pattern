package com.example.design.adaptor;

public class HairDryer implements Electornic110V {

    @Override
    public void powerOn() {
        System.out.println("Hair Dryer 110V On.");
    }

}
