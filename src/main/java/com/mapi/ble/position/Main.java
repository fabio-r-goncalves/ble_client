package com.mapi.ble.position;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.Socket;

/**
 * Created by fabio on 1/4/2017.
 */


public class Main {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        Socket socket = new Socket("localhost", 8080);
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
            int minValue = Vars.MAX_VALUES;
            if (i == 20) {
                i = 0;
                for (Antenna a : antennas.getAntennaArrayList()) {
                    for (Ibeacon ibeacon : a.getIbeacons().getIbeaconArrayList()) {
                        if(ibeacon.getMeasures().size() != Vars.MAX_VALUES){
                            all = false;
                        }
                        if(ibeacon.getMeasures().size() < minValue){
                            minValue = ibeacon.getMeasures().size();
                        }
                    }
                }

                System.out.println("measured: "+minValue);

                if(all){
                    WriteToFile writeToFile =new WriteToFile();
                    writeToFile.saveData(antennas);
                    System.exit(0);
                }
            }
        }


    }


}
