package com.gomdolstudio.travelkorea.data.entity;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Item {
    @SerializedName("airlineNm")
    @Expose
    private String airlineNm;
    @SerializedName("arrAirportNm")
    @Expose
    private String arrAirportNm;
    @SerializedName("arrPlandTime")
    @Expose
    private Long arrPlandTime;
    @SerializedName("depAirportNm")
    @Expose
    private String depAirportNm;
    @SerializedName("depPlandTime")
    @Expose
    private Long depPlandTime;
    @SerializedName("vihicleId")
    @Expose
    private String vihicleId;
    @SerializedName("economyCharge")
    @Expose
    private Integer economyCharge = 0;
    @SerializedName("prestigeCharge")
    @Expose
    private Integer prestigeCharge = 0;

    public String getAirlineNm() {
        return airlineNm;
    }

    public void setAirlineNm(String airlineNm) {
        this.airlineNm = airlineNm;
    }

    public String getArrAirportNm() {
        return arrAirportNm;
    }

    public void setArrAirportNm(String arrAirportNm) {
        this.arrAirportNm = arrAirportNm;
    }

    public Long getArrPlandTime() {
        return arrPlandTime;
    }

    public void setArrPlandTime(Long arrPlandTime) {
        this.arrPlandTime = arrPlandTime;
    }

    public String getDepAirportNm() {
        return depAirportNm;
    }

    public void setDepAirportNm(String depAirportNm) {
        this.depAirportNm = depAirportNm;
    }

    public Long getDepPlandTime() {
        return depPlandTime;
    }

    public void setDepPlandTime(Long depPlandTime) {
        this.depPlandTime = depPlandTime;
    }

    public String getVihicleId() {
        return vihicleId;
    }

    public void setVihicleId(String vihicleId) {
        this.vihicleId = vihicleId;
    }

    public Integer getEconomyCharge() {
        return economyCharge;
    }

    public void setEconomyCharge(Integer economyCharge) {
        this.economyCharge = economyCharge;
    }

    public Integer getPrestigeCharge() {
        return prestigeCharge;
    }

    public void setPrestigeCharge(Integer prestigeCharge) {
        this.prestigeCharge = prestigeCharge;
    }
}