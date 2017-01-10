package com.mapi.ble.position;

import java.io.IOException;
import java.util.ArrayList;

/**
 * Created by fabio on 1/9/2017.
 */
public class Ibeacon {
    private String mac;
    private String name;
    private ArrayList<Measure> measures;

    public Ibeacon(String mac, String name, double RSSI, String antenna) throws IOException {
        this.mac = mac;
        this.name = name;
        this.measures = new ArrayList<>();
    }

    public Ibeacon(String mac, String name, Position position, String antenna) throws IOException {
        this.mac = mac;
        this.name = name;
        this.measures = new ArrayList<>();
    }

    public Ibeacon(String mac, String name, Position position, double RSSI, double distance, String antenna) throws IOException {
        this.mac = mac;
        this.name = name;
        this.measures = new ArrayList<>();

    }

    public String getMac() {
        return mac;
    }

    public void setMac(String mac) {
        this.mac = mac;
    }

    public void addMeasure(double rssi){
        Measure measure = new Measure(new Position(0,0,0), rssi, 0);
        this.measures.add(measure);
    }

    public ArrayList<Measure> getMeasures() {
        return measures;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    @Override
    public String toString() {
        return "Ibeacon{" +
                "mac='" + mac + '\'' +
                ", name='" + name + '\'' +
                '}';
    }
}
