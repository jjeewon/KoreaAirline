package com.gomdolstudio.travelkorea.data.entity;

public class Item {
    private String airlineNm;
    private String arrAirportNm;
    private long arrPlandTime;
    private String depAirportNm;
    private long depPlandTime;
    private long economyCharge;
    private long prestigeCharge;
    private String vihicleId;

    public String getVihicleId() {
        return vihicleId;
    }

    public String getAirlineNm() {
        return airlineNm;
    }

    public String getArrAirportNm() {
        return arrAirportNm;
    }

    public String getDepAirportNm() {
        return depAirportNm;
    }

    public long getArrPlandTime() {
        return arrPlandTime;
    }

    public long getDepPlandTime() {
        return depPlandTime;
    }

    public long getEconomyCharge() {
        return economyCharge;
    }

    public long getPrestigeCharge() {
        return prestigeCharge;
    }
}
