package com.mapi.ble.position;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by fabio on 1/9/2017.
 */
public class Ibeacons {
    private HashMap<String, Ibeacon> ibeaconHashMap;

    public Ibeacons() {
        ibeaconHashMap = new HashMap<>();
    }

    public void addIbeacon(Ibeacon ibeacon) throws IOException {
        if (!ibeaconHashMap.containsKey(ibeacon.getMac())) {
            ibeaconHashMap.put(ibeacon.getMac(), ibeacon);
            ibeacon.getWriteToFile().writeData(ibeacon);
        } else {
            Ibeacon ibeacon1 = ibeaconHashMap.get(ibeacon.getMac());
            if(ibeacon1.getCount() >= Vars.MAX_VALUES){
                return;
            }
            ibeacon1.setDistance(ibeacon.getDistance());
            ibeacon1.setPosition(ibeacon.getPosition());
            ibeacon1.setRSSI(ibeacon.getRSSI());
            ibeacon1.getWriteToFile().writeData(ibeacon1);
            ibeacon1.increaseCount();
        }
    }

    public void removeIbeacon(String mac) {
        ibeaconHashMap.remove(mac);
    }

    public ArrayList<Ibeacon> getIbeaconArrayList() {
        return new ArrayList<>(ibeaconHashMap.values());
    }

    public void addDevice(Device device, String antenna) throws IOException {
        Ibeacon ibeacon = new Ibeacon(device.getAddress(), device.getName(), device.getRSSI(), antenna);
        addIbeacon(ibeacon);
    }

    public void setBeacons(String antenna) throws IOException {
        Ibeacon ibeacon;

        ibeacon = new Ibeacon("E3:4A:30:D0:DB:D4(Static)", "9mbi", new Position(0, 1, 2), antenna);
        ibeaconHashMap.put(ibeacon.getMac(), ibeacon);
        ibeacon = new Ibeacon("D8:2C:97:CA:2B:64(Static)", "hbdi", new Position(0, 1, 2), antenna);
        ibeaconHashMap.put(ibeacon.getMac(), ibeacon);
        ibeacon = new Ibeacon("EF:9B:F5:0E:28:B7(Static)", "gjv2", new Position(0, 1, 2), antenna);
        ibeaconHashMap.put(ibeacon.getMac(), ibeacon);
        ibeacon = new Ibeacon("EA:03:7F:09:24:8B(Static)", "xk4t", new Position(0, 1, 2), antenna);
        ibeaconHashMap.put(ibeacon.getMac(), ibeacon);
        ibeacon = new Ibeacon("F5:86:D6:05:B9:43(Static)", "b0vw", new Position(0, 1, 2), antenna);
        ibeaconHashMap.put(ibeacon.getMac(), ibeacon);
        ibeacon = new Ibeacon("E0:40:6F:FE:30:31(Static)", "yvlm", new Position(0, 1, 2), antenna);
        ibeaconHashMap.put(ibeacon.getMac(), ibeacon);
        ibeacon = new Ibeacon("C5:C0:7D:78:F8:55(Static)", "gmta", new Position(0, 1, 2), antenna);
        ibeaconHashMap.put(ibeacon.getMac(), ibeacon);
        ibeacon = new Ibeacon("EC:C5:D4:ED:C7:48(Static)", "unpx", new Position(0, 1, 2), antenna);
        ibeaconHashMap.put(ibeacon.getMac(), ibeacon);
        ibeacon = new Ibeacon("CE:CE:0B:9B:D2:94(Static)", "07n0", new Position(0, 1, 2), antenna);
        ibeaconHashMap.put(ibeacon.getMac(), ibeacon);
        ibeacon = new Ibeacon("C9:F6:F4:CF:F0:81(Static)", "gq0q", new Position(0, 1, 2), antenna);
        ibeaconHashMap.put(ibeacon.getMac(), ibeacon);

    }
}
