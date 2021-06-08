package com.gomdolstudio.travelkorea.data.entity;

import android.os.Parcel;
import android.os.Parcelable;

public class Flight implements Parcelable {
    private String numOfRows;
    private String pageNo;
    private String depAirportId;
    private String arrAirportId;
    private String depPlandTime;
    private String airlineId;

    public Flight(String numOfRows, String pageNo, String depAirportId, String arrAirportId, String depPlandTime, String airlineId){
        this.numOfRows = numOfRows;
        this.pageNo = pageNo;
        this.depAirportId = depAirportId;
        this.arrAirportId = arrAirportId;
        this.depPlandTime = depPlandTime;
        this.airlineId = airlineId;
    }

    public String getNumOfRows(){
        return numOfRows;
    }

    public String getPageNo() {
        return pageNo;
    }

    public String getDepAirportId() {
        return depAirportId;
    }

    public String getArrAirportId() {
        return arrAirportId;
    }

    public String getDepPlandTime() {
        return depPlandTime;
    }

    public String getAirlineId() {
        return airlineId;
    }

    protected Flight(Parcel in) {
        numOfRows = in.readString();
        pageNo = in.readString();
        depAirportId = in.readString();
        arrAirportId = in.readString();
        depPlandTime = in.readString();
        airlineId = in.readString();
    }

    public static final Creator<Flight> CREATOR = new Creator<Flight>() {
        @Override
        public Flight createFromParcel(Parcel in) {
            return new Flight(in);
        }

        @Override
        public Flight[] newArray(int size) {
            return new Flight[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(numOfRows);
        dest.writeString(pageNo);
        dest.writeString(depAirportId);
        dest.writeString(arrAirportId);
        dest.writeString(depPlandTime);
        dest.writeString(airlineId);
    }
}
