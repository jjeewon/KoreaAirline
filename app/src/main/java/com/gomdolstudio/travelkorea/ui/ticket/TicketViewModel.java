package com.gomdolstudio.travelkorea.ui.ticket;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.MutableLiveData;

import com.gomdolstudio.travelkorea.data.entity.Flight;

import java.util.List;

import javax.inject.Inject;

public class TicketViewModel extends AndroidViewModel {

    private final MutableLiveData<Boolean> loading = new MutableLiveData<>(true);

    private final MutableLiveData<List<TicketItem>> liveTickets = new MutableLiveData<>();
    
    @Inject
    public TicketViewModel(@NonNull Application application) {
        super(application);
    }

    public void loadTickets(){

    }

    public MutableLiveData<Boolean> getLoading(){
        return loading;
    }

    public void load(Flight flight){
        int a = 4;
        int c = 4;
    }
}
