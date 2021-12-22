package com.example.design.observer;

public class ButtonMain {

    public static void main(String[] args) {

        Button button = new Button("Button");
        button.addListner(new IButtonlistner() {
            @Override
            public void clickEvent(String event) {
                System.out.println(event);
            }
        });
        button.click("click 1 send a message.");
        button.click("click 2 send a message.");
        button.click("click 3 send a message.");
    }
}
