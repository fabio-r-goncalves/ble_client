package com.mapi.ble.position;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

/**
 * Created by fabio on 1/10/2017.
 */
public class WriteToFile {
    private String fileName;
    private File file;
    private BufferedWriter bufferedWriter;


    public WriteToFile(String antenna, String name) throws IOException {
        File dir  = new File("beacons");
        dir.mkdir();
        this.fileName = "beacons/" + antenna + "_" + name + ".csv";
        File file = new File(fileName);
        FileWriter fileWriter = new FileWriter(file);
        bufferedWriter = new BufferedWriter(fileWriter);
    }

    public void writeData(Ibeacon ibeacon) throws IOException {
        String data = ibeacon.getName()  + "," + ibeacon.getRSSI() + "," + ibeacon.getDistance() + "," + ibeacon.getPosition().getX() + "," + ibeacon.getPosition().getY() + "," + ibeacon.getPosition().getZ();

        bufferedWriter.write(data);
        bufferedWriter.newLine();
        bufferedWriter.flush();
    }

}
