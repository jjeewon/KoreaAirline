package com.gomdolstudio.travelkorea.ui.flight;

import android.widget.AdapterView;

import androidx.annotation.NonNull;

import com.gomdolstudio.travelkorea.data.entity.Flight;

import java.util.Map;

public class FlightItem {
    @NonNull
    private final Flight flight;

    private EventListener eventListener;

    public FlightItem(@NonNull Flight flight, EventListener eventListener) {
        this.flight = flight;
        this.eventListener = eventListener;

    }

    @NonNull
    public Flight getFlight(){
        return flight;
    }

    public String getDepAirportId(){
        return flight.getDepAirportId();
    }

    public String getArrAirportId(){
        return flight.getArrAirportId();
    }

   public void setDate(String date){
        this.flight.setDepPlandTime(date);
   }

    public EventListener getEventListener(){
        return eventListener;
    }

    public interface EventListener{
        void onSearchBtnClick(FlightItem flightItem);
        void onSpinnerItemSelected(String id, AdapterView<?> parent, int position, String selectedItem);
        void onDateChanged(int year, int month, int day);
    }


    public void setDepAirportId(String id){
        this.flight.setDepAirportId(id);
    }

    public void setArrAirportId(String id){
        this.flight.setArrAirportId(id);
    }

}
