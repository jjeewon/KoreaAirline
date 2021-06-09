package com.gomdolstudio.travelkorea.data.entity;

import android.widget.ArrayAdapter;

import java.util.ArrayList;
import java.util.List;

public class AirportId {
    ArrayList<String> airportIdList;

    public AirportId(){
        airportIdList = new ArrayList<>();
        airportIdList.add("ICN");
        airportIdList.add("JEJU");
        airportIdList.add("KMP");
        airportIdList.add("DAGU");
    }

    public ArrayList<String> getAirportIdList(){
        return airportIdList;
    }
}
