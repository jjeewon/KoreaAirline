package com.gomdolstudio.travelkorea.ui.ticket;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.MutableLiveData;

import com.gomdolstudio.travelkorea.data.entity.Flight;
import com.gomdolstudio.travelkorea.util.SingleLiveEvent;

import java.util.List;

import javax.inject.Inject;
import javax.inject.Named;

import io.reactivex.rxjava3.disposables.CompositeDisposable;
import timber.log.Timber;

public class TicketViewModel extends AndroidViewModel {

    @NonNull
    private final SingleLiveEvent<Throwable> errorEvent;

    private final MutableLiveData<Boolean> loading = new MutableLiveData<>(true);

    private final MutableLiveData<List<TicketItem>> liveTickets = new MutableLiveData<>();
    private final CompositeDisposable compositeDisposable = new CompositeDisposable();

    @Inject
    public TicketViewModel(@NonNull Application application, @Named("errorEvent") SingleLiveEvent<Throwable> errorEvent) {
        super(application);
        Timber.d("PostViewModel created");
        // 오브젝트 그래프로부터 생성자 주입
        this.errorEvent = errorEvent;
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
