package com.mapi.ble.position;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

/**
 * Created by fabio on 1/10/2017.
 */
public class WriteToFile {

    private final String ROOT_DIR = "beacons";

    public WriteToFile() {
        File file = new File(ROOT_DIR);
        file.mkdir();
    }

    public void saveData(Antennas antennas) throws IOException {
        ArrayList<Antenna> antennaArrayList = antennas.getAntennaArrayList();

        for(Antenna antenna: antennaArrayList){
            saveAntenaData(antenna);
        }
    }

    public void saveAntenaData(Antenna antenna) throws IOException {
        ArrayList<Ibeacon> ibeaconArrayList = antenna.getIbeacons().getIbeaconArrayList();
        saveAllInOne(ibeaconArrayList, antenna.getName());

        //for(Ibeacon ibeacon: ibeaconArrayList){
        //    ArrayList<Measure>  measures = ibeacon.getMeasures();
        //    saveMeasures(measures, antenna.getName() + "_" + ibeacon.getName() + ".csv");
        //}

    }

    public void saveAllInOne(ArrayList<Ibeacon> ibeacons, String antenna) throws IOException {
        String distance = "";
        String rssi = "";

        File distanceDir = new File(ROOT_DIR + "/distance");
        distanceDir.mkdirs();
        File distanceFile = new File(ROOT_DIR + "/distance/"+antenna+".csv");

        File rssiDir = new File(ROOT_DIR + "/rssi");
        rssiDir.mkdirs();
        File rssiFile = new File(ROOT_DIR + "/rssi/"+antenna+".csv");

        FileWriter distanceWriter = new FileWriter(distanceFile);
        FileWriter rssiWriter = new FileWriter(rssiFile);

        BufferedWriter distBufferedWriter = new BufferedWriter(distanceWriter);
        BufferedWriter rssiBufferedWriter = new BufferedWriter(rssiWriter);




        String aux = ibeacons.get(0).getName();
        for(int i = 1; i < ibeacons.size(); i ++){
            aux = aux + "," + ibeacons.get(i).getName();
        }

        distBufferedWriter.write(aux);
        distBufferedWriter.newLine();
        rssiBufferedWriter.write(aux);
        rssiBufferedWriter.newLine();
        distBufferedWriter.flush();
        rssiBufferedWriter.flush();

        for (int i = 0; i < ibeacons.get(0).getMeasures().size(); i ++){
            distance = ibeacons.get(0).getMeasures().get(i).getDistance()+"";
            rssi = ibeacons.get(0).getMeasures().get(i).getRSSI()+"";
            for(int j = 1; j < ibeacons.size(); j ++){
                distance = distance + "," + ibeacons.get(j).getMeasures().get(i).getDistance();

                rssi = rssi + "," + ibeacons.get(j).getMeasures().get(i).getRSSI();
            }
            distBufferedWriter.write(distance);
            distBufferedWriter.newLine();
            distBufferedWriter.flush();
            rssiBufferedWriter.write(rssi);
            rssiBufferedWriter.newLine();
            rssiBufferedWriter.flush();
        }

        rssiBufferedWriter.close();
        distBufferedWriter.close();

    }

    public void saveData(String data, BufferedWriter bufferedWriter){

    }



    public void saveMeasures(ArrayList<Measure> measures, String fileName){

    }

    public void saveMeasure(Measure measure, BufferedWriter bufferedWriter){

    }

}
