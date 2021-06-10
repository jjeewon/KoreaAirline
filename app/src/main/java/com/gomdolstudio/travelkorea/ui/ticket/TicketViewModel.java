package com.gomdolstudio.travelkorea.ui.ticket;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.MutableLiveData;

import com.gomdolstudio.travelkorea.R;
import com.gomdolstudio.travelkorea.data.SearchService;
import com.gomdolstudio.travelkorea.data.entity.Flight;
import com.gomdolstudio.travelkorea.data.entity.Response;
import com.gomdolstudio.travelkorea.data.entity.Ticket;
import com.gomdolstudio.travelkorea.data.entity.TicketResponse;
import com.gomdolstudio.travelkorea.util.SingleLiveEvent;

import java.util.List;

import javax.inject.Inject;
import javax.inject.Named;

import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers;
import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.disposables.CompositeDisposable;
import io.reactivex.rxjava3.schedulers.Schedulers;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import timber.log.Timber;

public class TicketViewModel extends AndroidViewModel implements TicketItem.EventListener{

    @NonNull
    private final SingleLiveEvent<Throwable> errorEvent;

    private final MutableLiveData<Boolean> loading = new MutableLiveData<>(true);

    private final MutableLiveData<List<TicketItem>> liveTickets = new MutableLiveData<>();
    private final MutableLiveData<List<Ticket>> tickets = new MutableLiveData<>();
    private final MutableLiveData<TicketResponse> liveResponse = new MutableLiveData<>();
    private final CompositeDisposable compositeDisposable = new CompositeDisposable();

    private final SingleLiveEvent<TicketItem> ticketClickEvent = new SingleLiveEvent<>();

    @NonNull
    private final SearchService searchService;

    @Inject
    public TicketViewModel(@NonNull Application application, SearchService searchService, @Named("errorEvent") SingleLiveEvent<Throwable> errorEvent) {
        super(application);
        Timber.d("PostViewModel created");
        // 오브젝트 그래프로부터 생성자 주입
        this.searchService = searchService;
        this.errorEvent = errorEvent;
    }

    public MutableLiveData<List<Ticket>> getTickets(){ return tickets; }
    public MutableLiveData<Boolean> getLoading(){
        return loading;
    }

    public void load(Flight flight){
        flight.setDepAirportId("NAARKJJ");
        flight.setArrAirportId("NAARKPC");
        compositeDisposable.add(searchService.getTicket(flight.getServiceKey(),flight.getNumOfRows(),
                flight.getPageNo(),flight.getDepAirportId(),flight.getArrAirportId(),
                Long.parseLong(flight.getDepPlandTime()),"json")
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .doOnSuccess(item -> loading.postValue(false))
                .subscribe(liveResponse::setValue, errorEvent::setValue));
    }

    @Override
    protected void onCleared(){
        super.onCleared();
        Timber.d("onCleared");
        compositeDisposable.dispose();
    }
    /**

    @NonNull
    public MutableLiveData<List<TicketItem>> getLiveTickets(){
        return liveTickets;
    }

    /**
     * TicketItem 클릭 이벤트 구현
     * @param ticket
     */
    @Override
    public void onTicketClick(TicketItem ticket) {
        // Fragment로 이벤트를 전달하도록
        // SingleLiveEvent의 값을 변경한다.
        ticketClickEvent.setValue(ticket);
    }

    // TicketFragment로 ticketClickEvent 변수를 노출
    public SingleLiveEvent<TicketItem> getTicketClickEvent(){
        return ticketClickEvent;
    }

    @NonNull
    public MutableLiveData<TicketResponse> getLiveResponse() {
        return liveResponse;
    }

    public SingleLiveEvent<Throwable> getErrorEvent(){
        return errorEvent;
    }
}
