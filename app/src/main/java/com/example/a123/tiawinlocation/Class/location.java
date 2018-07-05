package com.example.a123.tiawinlocation.Class;

public class location {

    private int ID;
    private String lat;
    private String lot;

    public location(int id, String lat, String lot) {
        this.lat = lat;
        this.lot = lot;
        this.ID = id;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getLat() {
        return lat;
    }

    public void setLat(String lat) {
        this.lat = lat;
    }

    public String getLot() {
        return lot;
    }

    public void setLot(String lot) {
        this.lot = lot;
    }
}
