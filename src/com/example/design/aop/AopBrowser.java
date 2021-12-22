package com.example.design.aop;

import com.example.design.proxy.Html;
import com.example.design.proxy.IBrowser;

public class AopBrowser implements IBrowser {

    private String url;
    private Html html;

    private Runnable before;
    private Runnable after;

    public AopBrowser(String url, Runnable before, Runnable after) {
        this.url = url;
        this.before = before;
        this.after = after;
    }

    @Override
    public Html show() {

        before.run();

        if(html==null){
            html = new Html(url);
            System.out.println("AopBrowser html loading from : " + url);

            try {
                Thread.sleep(1500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        System.out.println("AopBrowser use cache html : " + url);

        after.run();

        return html;
    }
}
