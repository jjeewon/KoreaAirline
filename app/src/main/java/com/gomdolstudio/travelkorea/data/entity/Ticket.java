package com.gomdolstudio.travelkorea.data.entity;

import android.os.Parcel;
import android.os.Parcelable;

public class Ticket implements Parcelable {
    private String vihicleId;
    private String airlineNm;
    private long depPlandTime;
    private long arrPlandTime;
    private long economyCharge;
    private long prestigeCharge;
    private String depAirportNm;
    private String arrAirportNm;

    public Ticket(String vihicleId, String airlineNm, long depPlandTime,
                  long arrPlandTime, long economyCharge, long prestigeCharge
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

    public long getDepPlandTime() {
        return depPlandTime;
    }

    public String getArrAirportNm() {
        return arrAirportNm;
    }

    public long getArrPlandTime() {
        return arrPlandTime;
    }

    public String getDepAirportNm() {
        return depAirportNm;
    }

    public long getEconomyCharge() {
        return economyCharge;
    }

    public long getPrestigeCharge() {
        return prestigeCharge;
    }

    protected Ticket(Parcel in) {
        vihicleId = in.readString();
        airlineNm = in.readString();
        depPlandTime = in.readLong();
        arrPlandTime = in.readLong();
        economyCharge = in.readLong();
        prestigeCharge = in.readLong();
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
        dest.writeLong(depPlandTime);
        dest.writeLong(arrPlandTime);
        dest.writeLong(economyCharge);
        dest.writeLong(prestigeCharge);
        dest.writeString(depAirportNm);
        dest.writeString(arrAirportNm);
    }
}