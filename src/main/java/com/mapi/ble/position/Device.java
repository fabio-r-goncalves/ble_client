/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mapi.ble.position;

import java.io.Serializable;

/**
 * @author root
 */
public class Device implements Serializable {
    private String uuid;
    private String name;
    private double RSSI;
    private double RSSIAvg;
    private double TXPower;
    private double TXPowerAvg;
    private long lastAdvertise;
    private String type;
    private String address;
    private double distance;
    private double lastSumRSSI;
    private int totalRead;
    private double x;
    private double y;
    private double z;

    public Device(String uuid, String address, double x, double y, double z, String name) {
        this.uuid = uuid;
        this.address = address;
        this.x = x;
        this.y = y;
        this.z = z;
        this.name = name;
    }


    public Device(String uuid, double RSSI, double TXPower, long lastAdvertise, String type, String address, double distance) {
        this.uuid = uuid;

        this.RSSI = RSSI;
        this.TXPower = TXPower;
        this.lastAdvertise = lastAdvertise;
        this.type = type;
        this.address = address;
        this.distance = distance;

        this.TXPowerAvg = TXPower;
        this.RSSIAvg = RSSI;
        this.lastSumRSSI = 0;
        this.totalRead = 0;
    }

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getRSSI() {
        return RSSI;
    }

    public void setRSSI(double RSSI) {
        totalRead = totalRead + 1;
        this.setRSSIAvg(RSSI);
        this.RSSI = RSSI;
    }

    public double getTXPower() {
        return TXPower;
    }

    public void setTXPower(double TXPower) {
        this.TXPower = TXPower;


    }

    public long getLastAdvertise() {
        return lastAdvertise;
    }

    public void setLastAdvertise(long lastAdvertise) {
        this.lastAdvertise = lastAdvertise;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public double getDistance() {
        return distance;
    }

    public void setDistance(double distance) {
        this.distance = distance;
    }

    public double getRSSIAvg() {
        return RSSIAvg;
    }

    private void setRSSIAvg(double RSSIAvg) {
        this.lastSumRSSI = this.lastSumRSSI + RSSIAvg;
        this.RSSIAvg = this.lastSumRSSI / (double) totalRead;
    }

    public double getTXPowerAvg() {
        return TXPowerAvg;
    }

    public void setTXPowerAvg(double TXPowerAvg) {
        this.TXPowerAvg = (TXPowerAvg + this.TXPowerAvg) / (double) 2;
    }

    public double getX() {
        return x;
    }

    public void setX(double x) {
        this.x = x;
    }

    public double getY() {
        return y;
    }

    public void setY(double y) {
        this.y = y;
    }

    public double getZ() {
        return z;
    }

    public void setZ(double z) {
        this.z = z;
    }


    @Override
    public String toString() {
        return "Device{" + "uuid=" + uuid + ", name=" + name + ", RSSI=" + RSSI + ", RSSIAvg=" + RSSIAvg + ", TXPower=" + TXPower + ", TXPowerAvg=" + TXPowerAvg + ", lastAdvertise=" + lastAdvertise + ", type=" + type + ", address=" + address + ", distance=" + distance + " num=" + totalRead + '}';
    }

    public int getTotalRead() {
        return totalRead;
    }
}
