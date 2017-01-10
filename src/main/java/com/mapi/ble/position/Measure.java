package com.mapi.ble.position;

/**
 * Created by fabio on 1/10/2017.
 */
public class Measure {
    private Position position;
    private double RSSI;
    private double distance;

    public Measure(Position position, double RSSI, double distance) {
        this.position = position;
        this.RSSI = RSSI;
        this.distance = distance;
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

    @Override
    public String toString() {
        return "Measure{" +
                "position=" + position +
                ", RSSI=" + RSSI +
                ", distance=" + distance +
                '}';
    }
}
