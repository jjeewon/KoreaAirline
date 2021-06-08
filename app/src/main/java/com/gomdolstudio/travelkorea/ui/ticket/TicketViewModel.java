package com.gomdolstudio.travelkorea.ui.ticket;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.MutableLiveData;

import javax.inject.Inject;

public class TicketViewModel extends AndroidViewModel {

    private final MutableLiveData<Boolean> loading = new MutableLiveData<>(true);

    @Inject
    public TicketViewModel(@NonNull Application application) {
        super(application);
    }

    public void loadTickets(){

    }

    public MutableLiveData<Boolean> getLoading(){
        return loading;
    }
}
