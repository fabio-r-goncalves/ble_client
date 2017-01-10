package com.mapi.ble.position;

import java.io.IOException;

/**
 * Created by fabio on 1/9/2017.
 */
public class Ibeacon {
    private String mac;
    private String name;
    private Position position;
    private double RSSI;
    private double distance;
    private int count;
    private WriteToFile writeToFile;



    public Ibeacon(String mac, String name, double RSSI, String antenna) throws IOException {
        this.mac = mac;
        this.name = name;
        this.RSSI = RSSI;
        this.count = 1;
        this.writeToFile = new WriteToFile(antenna, name);
        this.position = new Position(0,0,0);
    }

    public Ibeacon(String mac, String name, Position position, String antenna) throws IOException {
        this.mac = mac;
        this.name = name;
        this.position = position;
        this.count = 0;
        this.writeToFile = new WriteToFile(antenna, name);

    }

    public Ibeacon(String mac, String name, Position position, double RSSI, double distance, String antenna) throws IOException {
        this.mac = mac;
        this.name = name;
        this.position = position;
        this.RSSI = RSSI;
        this.distance = distance;
        this.count = 1;
        this.writeToFile = new WriteToFile(antenna, name);
    }

    public String getMac() {
        return mac;
    }

    public void setMac(String mac) {
        this.mac = mac;
    }

    public Position getPosition() {
        return position;
    }

    public void setPosition(Position position) {
        this.position = position;
    }

    public double getRSSI() {
        return RSSI;
    }

    public void setRSSI(double RSSI) {
        this.RSSI = RSSI;
    }

    public double getDistance() {
        return distance;
    }

    public void setDistance(double distance) {
        this.distance = distance;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public void increaseCount() {
        this.count = this.count + 1;
    }

    public WriteToFile getWriteToFile() {
        return writeToFile;
    }

    public void setWriteToFile(WriteToFile writeToFile) {
        this.writeToFile = writeToFile;
    }

    @Override
    public String toString() {
        return "Ibeacon{" +
                "mac='" + mac + '\'' +
                ", name='" + name + '\'' +
                ", position=" + position +
                ", RSSI=" + RSSI +
                ", distance=" + distance +
                ", count=" + count +
                '}';
    }
}
