package com.gomdolstudio.travelkorea.ui.flight;

import androidx.annotation.NonNull;

import com.gomdolstudio.travelkorea.data.entity.Flight;

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
    }

}
