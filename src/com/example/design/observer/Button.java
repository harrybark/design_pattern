package com.example.design.observer;

public class Button {

    private String name;
    private IButtonlistner buttonlistner;

    public Button(String name) {
        this.name = name;
    }

    public void click(String message) {
        buttonlistner.clickEvent(message);
    }

    public void addListner(IButtonlistner buttonlistner) {
        this.buttonlistner = buttonlistner;
    }
}
