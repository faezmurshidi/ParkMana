package com.faezmurshidiadnan.parkmana;

/**
 * Created by User on 20/05/16.
 */
public class Content {
    private String place;
    private String name;
    private String Lots;
    private String Long,Lat;



    public String getPlace() {
        return place;
    }
    public void setPlace(String id) {
        this.place = id;

    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getLots() {
        return Lots;
    }
    public void setLot(String lot) {
        this.Lots = lot;
    }
    public String getLong() {
        return Long;
    }
    public void setLong(String lon) {
        this.Long = lon;
    }

    public String getLat() {
        return Lat;
    }
    public void setLat(String lat) {
        this.Lat = lat;
    }


    @Override
    public String toString() {
        return place + ","  + Lots + "," + Long + "," + Lat;
    }
}