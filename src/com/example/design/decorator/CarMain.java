package com.example.design.decorator;

public class CarMain {

    public static void main(String[] args) {

        ICar audi = new Audi(1000);
        audi.showPrice();

        // a3
        ICar a3 = new A3(audi, "A3");
        a3.showPrice();
        // a4
        ICar a4 = new A4(audi, "A4");
        a4.showPrice();
        // a5
        ICar a5 = new A5(audi, "A5");
        a5.showPrice();
    }
}
