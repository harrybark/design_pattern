package com.example.design.adaptor;

public class AdaptorMain {

    public static void main(String[] args) {
        AdaptorMain adaptor = new AdaptorMain();

        // 110v
        HairDryer hairDryer = new HairDryer();
        adaptor.connect(hairDryer);

        // 220v
        Cleaner cleaner = new Cleaner();
        Electornic110V socket = new AdaptorSocket(cleaner);
        adaptor.connect(socket);

        AirConditioner airConditioner = new AirConditioner();
        Electornic110V airSocket = new AdaptorSocket(airConditioner);
        adaptor.connect(airSocket);

    }

    // 콘센트
    public void connect(Electornic110V electornic110V) {
        electornic110V.powerOn();
    }
}
