package com.mapi.ble.position;

/**
 * Created by fabio on 1/9/2017.
 */
public class Antenna {
    private String name;
    private Ibeacons ibeacons;
    private Position position;

    public Antenna(String name) {
        this.name = name;
    }

    public Antenna(String name, Ibeacons ibeacons) {
        this.name = name;
        this.ibeacons = ibeacons;
    }

    public Antenna(String name, Ibeacons ibeacons, Position position) {
        this.name = name;
        this.ibeacons = ibeacons;
        this.position = position;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Ibeacons getIbeacons() {
        return ibeacons;
    }

    public void setIbeacons(Ibeacons ibeacons) {
        this.ibeacons = ibeacons;
    }

    public Position getPosition() {
        return position;
    }

    public void setPosition(Position position) {
        this.position = position;
    }


}
