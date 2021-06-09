package com.gomdolstudio.travelkorea.ui.flight;

import android.app.Application;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.MutableLiveData;

import com.gomdolstudio.travelkorea.R;
import com.gomdolstudio.travelkorea.data.entity.Flight;
import com.gomdolstudio.travelkorea.util.SingleLiveEvent;

import java.util.Map;

import javax.inject.Inject;

public class FlightViewModel extends AndroidViewModel implements FlightItem.EventListener{

    // Flight Item을 Live Data로 관리
    private final Flight flight = new Flight("10","1","ICN",
            "ICN","DD","SS");
    private final String depId = "depId";
    private final String arrId = "arrId";

    private final SingleLiveEvent<FlightItem> searchBtnClickEvent = new SingleLiveEvent<>();

    @Inject
    public FlightViewModel(@NonNull Application application) {
        super(application);

    }

    public String getDepId(){
        return depId;
    }

    public String getArrId(){
        return arrId;
    }

    /**
     * onSearBtnClick 클릭 이벤트 구현
     * @param flightItem
     */
    @Override
    public void onSearchBtnClick(FlightItem flightItem) {
        // 프래그먼트로 이벤트를 전달하도록
        // SingleLiveEvent의 값을 변경한다.
        searchBtnClickEvent.setValue(new FlightItem(flight,this));
    }

    @Override
    public void onSpinnerItemSelected(String id, AdapterView<?> parent, int position, String selectedItem) {
        if(id.equals(depId)){
            flight.setDepAirportId((String)parent.getAdapter().getItem(position));
        }else{
            flight.setArrAirportId((String)parent.getAdapter().getItem(position));
        }
    }

    @Override
    public void onDateChanged(int year, int month, int day) {
        String monthString = String.valueOf(month+1), dayString = String.valueOf(day);
        if(month+1 < 10) monthString = "0"+String.valueOf(month+1);
        if(day < 10) dayString = "0"+String.valueOf(month);
        flight.setDepPlandTime(String.valueOf(year) + monthString + dayString);
    }

    public SingleLiveEvent<FlightItem> getSearchBtnClickEvent(){
        return searchBtnClickEvent;
    }


}
