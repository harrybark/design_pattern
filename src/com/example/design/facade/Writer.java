package com.example.design.facade;

public class Writer {

    private String fileName;

    public Writer(String fileName) {
        this.fileName = fileName;
    }

    public void fileConnect() {
        String format = String.format("Reader %s 연결합니다.", fileName);
        System.out.println(format);
    }

    public void fileWrite() {
        String format = String.format("Reader %s 파일 쓰기를 합니다.", fileName);
        System.out.println(format);
    }

    public void fileDisconnect() {
        String format = String.format("Reader %s 연결을 종료합니다.", fileName);
        System.out.println(format);
    }
}
