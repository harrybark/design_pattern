package com.example.design.facade;

public class Reader {

    private String fileName;

    public Reader(String fileName) {
        this.fileName = fileName;
    }

    public void fileConnect() {
        String format = String.format("Reader %s 연결합니다.", fileName);
        System.out.println(format);
    }

    public void fileRead() {
        String format = String.format("Reader %s 내용을 읽어 옵니다.", fileName);
        System.out.println(format);
    }

    public void fileDisconnect() {
        String format = String.format("Reader %s 연결을 종료합니다.", fileName);
        System.out.println(format);
    }
}
