package com.gomdolstudio.travelkorea.data.entity;

import android.os.Parcel;
import android.os.Parcelable;

public class Ticket implements Parcelable {
    private String vihicleId;
    private String airlineNm;
    private String depPlandTime;
    private String arrPlandTime;
    private String economyCharge;
    private String prestigeCharge;
    private String depAirportNm;
    private String arrAirportNm;

    public Ticket(String vihicleId, String airlineNm, String depPlandTime,
                  String arrPlandTime, String economyCharge, String prestigeCharge
                    ,String depAirportNm, String arrAirportNm) {
        this.vihicleId = vihicleId;
        this.airlineNm = airlineNm;
        this.depPlandTime = depPlandTime;
        this.arrPlandTime = arrPlandTime;
        this.economyCharge = economyCharge;
        this.prestigeCharge = prestigeCharge;
        this.depAirportNm = depAirportNm;
        this.arrAirportNm = arrAirportNm;
    }

    public String getVihicleId() {
        return vihicleId;
    }

    public String getAirlineNm() {
        return airlineNm;
    }

    public String getDepPlandTime() {
        return depPlandTime;
    }

    public String getArrAirportNm() {
        return arrAirportNm;
    }

    public String getArrPlandTime() {
        return arrPlandTime;
    }

    public String getDepAirportNm() {
        return depAirportNm;
    }

    public String getEconomyCharge() {
        return economyCharge;
    }

    public String getPrestigeCharge() {
        return prestigeCharge;
    }

    protected Ticket(Parcel in) {
        vihicleId = in.readString();
        airlineNm = in.readString();
        depPlandTime = in.readString();
        arrPlandTime = in.readString();
        economyCharge = in.readString();
        prestigeCharge = in.readString();
        depAirportNm = in.readString();
        arrAirportNm = in.readString();
    }

    public static final Creator<Ticket> CREATOR = new Creator<Ticket>() {
        @Override
        public Ticket createFromParcel(Parcel in) {
            return new Ticket(in);
        }

        @Override
        public Ticket[] newArray(int size) {
            return new Ticket[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(vihicleId);
        dest.writeString(airlineNm);
        dest.writeString(depPlandTime);
        dest.writeString(arrPlandTime);
        dest.writeString(economyCharge);
        dest.writeString(prestigeCharge);
        dest.writeString(depAirportNm);
        dest.writeString(arrAirportNm);
    }
}
