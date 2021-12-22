package com.example.design.proxy;

public class ProxyBrowser implements IBrowser {

    private String url ;
    private Html html;

    public ProxyBrowser(String url) {
        this.url = url;
    }

    @Override
    public Html show() {

        if(html == null) {
            html = new Html(url);
            System.out.println("ProxyBrowser loading html : " + url);
        }
        System.out.println("ProxyBrowser use cache html : " + url);
        return html;
    }
}
