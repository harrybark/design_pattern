package com.example.design.facade;

public class FTPMain {

    public static void main(String[] args) {

        FTP ftpClient = new FTP("www.foo.co.kr", 22, "/home/etc");

        ftpClient.connect();
        ftpClient.moveDirectory();

        Writer writer = new Writer("text.tmp");
        writer.fileConnect();
        writer.fileWrite();

        Reader reader = new Reader("text.tmp");
        reader.fileConnect();
        reader.fileRead();

        reader.fileDisconnect();
        writer.fileDisconnect();
        ftpClient.disConnect();

        // facade pattern

        SFtpClient sFtpClient = new SFtpClient("www.foo.co.kr", 22, "/home/etc", "text.tmp");
        sFtpClient.connect();
        sFtpClient.write();
        sFtpClient.read();
        sFtpClient.disconnect();
    }
}
