package com.example.design.strategy;

public class EncoderMain {

    public static void main(String[] args) {
        Encoder encoder = new Encoder();

        String message = "hello java";
        // Base64
        EncodingStrategy base64 = new Base64Strategy();

        // Normal
        NormalStrategy normalStrategy = new NormalStrategy();

        encoder.setEncodingStrategy(base64);
        String base64Result = encoder.getMessage(message);

        encoder.setEncodingStrategy(normalStrategy);
        String normalResult = encoder.getMessage(message);

        String s1 = String.format("Base64 Result is %s", base64Result);
        String s2 = String.format("Normal Result is %s", normalResult);
        System.out.println(s1);
        System.out.println(s2);

        encoder.setEncodingStrategy(new AppendStrategy());
        String appendResult = encoder.getMessage(message);
        String s3 = String.format("Appender Result is %s", appendResult);

        System.out.println(s3);

    }
}
