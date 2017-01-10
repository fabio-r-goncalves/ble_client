package com.mapi.ble.position;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.Socket;

/**
 * Created by fabio on 1/4/2017.
 */


public class Main {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        Socket socket = new Socket("192.168.1.73", 8080);
        System.out.println("connected");
        ObjectInputStream objectInputStream = new ObjectInputStream(socket.getInputStream());
        Antennas antennas = new Antennas();
        int i = 0;
        while (true) {
            Object o = objectInputStream.readObject();

            Device device = (Device) o;
            antennas.addDevice(device);

            i++;
            boolean all = true;
            if (i == 20) {
                i = 0;
                for (Antenna a : antennas.getAntennaArrayList()) {
                    for (Ibeacon ibeacon : a.getIbeacons().getIbeaconArrayList()) {
                        if(ibeacon.getCount() != Vars.MAX_VALUES){
                            all = false;
                        }
                        System.out.println(ibeacon);
                    }
                }

                if(all){
                    System.exit(0);
                }
            }
        }


    }


}
