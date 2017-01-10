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

        }
    }

    public void saveAntenaData(Antenna antenna){
        ArrayList<Ibeacon> ibeaconArrayList = antenna.getIbeacons().getIbeaconArrayList();
        saveAllInOne(ibeaconArrayList);

        for(Ibeacon ibeacon: ibeaconArrayList){
            ArrayList<Measure>  measures = ibeacon.getMeasures();
            saveMeasures(measures, antenna.getName() + "_" + ibeacon.getName() + ".csv");
        }

    }

    public void saveAllInOne(ArrayList<Ibeacon> ibeacons){

    }

    public void saveMeasures(ArrayList<Measure> measures, String fileName){

    }

    public void saveMeasure(Measure measure, BufferedWriter bufferedWriter){

    }

}
