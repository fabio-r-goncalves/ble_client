package com.mapi.ble.position;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by fabio on 1/9/2017.
 */
public class Antennas {
    private HashMap<String, Antenna> antennaHashMap;

    public Antennas() {
        antennaHashMap = new HashMap<>();
    }

    public void addAntenna(Antenna antenna) {
        antennaHashMap.put(antenna.getName(), antenna);
    }

    public void removeAntenna(String name) {
        antennaHashMap.remove(name);
    }

    public void addDevice(Device device) throws IOException {
        if (antennaHashMap.containsKey(device.getName())) {
            Antenna antenna = antennaHashMap.get(device.getName());
            Ibeacons ibeacons = antenna.getIbeacons();
            ibeacons.addDevice(device, device.getName());

        } else {
            Antenna antenna = new Antenna(device.getName());
            Ibeacons ibeacons = new Ibeacons();

            ibeacons.setBeacons(device.getName());
            antenna.setIbeacons(ibeacons);
            antenna.getIbeacons().addDevice(device, device.getName());
            antennaHashMap.put(antenna.getName(), antenna);
        }
    }

    public HashMap<String, Antenna> getAntennaHashMap() {
        return antennaHashMap;
    }

    public ArrayList<Antenna> getAntennaArrayList() {
        return new ArrayList<>(antennaHashMap.values());
    }
}
