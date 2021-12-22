package com.example.design.proxy;

import com.example.design.aop.AopBrowser;

import java.util.concurrent.atomic.AtomicLong;

public class ProxyMain {

    public static void main(String[] args) {

        Browser browser = new Browser("www.naver.com");
        browser.show();
        browser.show();
        browser.show();
        browser.show();

        System.out.println("===========================================");

        ProxyBrowser proxyBrowser = new ProxyBrowser("www.naver.com");
        proxyBrowser.show();
        proxyBrowser.show();
        proxyBrowser.show();
        proxyBrowser.show();

        System.out.println("===========================================");

        AtomicLong start = new AtomicLong();
        AtomicLong end = new AtomicLong();

        AopBrowser aopBrowser = new AopBrowser("www.naver.com",
                () -> {
                    System.out.println("before");
                    start.set(System.currentTimeMillis());
                },
                () -> {
                    long now = System.currentTimeMillis();
                    end.set(now - start.get());
                });

        aopBrowser.show();
        System.out.println(end.get());

        aopBrowser.show();
        System.out.println(end.get());
    }
}
