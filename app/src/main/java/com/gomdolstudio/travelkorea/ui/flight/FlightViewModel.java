package com.gomdolstudio.travelkorea.ui.flight;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;

import com.gomdolstudio.travelkorea.util.SingleLiveEvent;

public class FlightViewModel extends AndroidViewModel implements FlightItem.EventListener {

    private final SingleLiveEvent<FlightItem> searchBtnClickEvent = new SingleLiveEvent<>();


    public FlightViewModel(@NonNull Application application) {
        super(application);
    }

    /**
     * onSearBtnClick 클릭 이벤트 구현
     * @param flightItem
     */
    @Override
    public void onSearchBtnClick(FlightItem flightItem) {
        // 프래그먼트로 이벤트를 전달하도록
        // SingleLiveEvent의 값을 변경한다.
        searchBtnClickEvent.setValue(flightItem);
    }
    
}
