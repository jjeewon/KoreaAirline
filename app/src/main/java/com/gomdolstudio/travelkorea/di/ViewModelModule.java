package com.gomdolstudio.travelkorea.di;

import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;

import com.gomdolstudio.travelkorea.ui.flight.FlightViewModel;
import com.gomdolstudio.travelkorea.ui.ticket.TicketViewModel;

import dagger.Binds;
import dagger.Module;
import dagger.multibindings.IntoMap;

// ViewModel과 관련된 내용을 오브젝트 그래프로 관리
@Module
public abstract class ViewModelModule {

    @Binds
    abstract ViewModelProvider.Factory bindViewModelFactory(AppViewModelFactory factory);

    @Binds
    @IntoMap
    @ViewModelKey(FlightViewModel.class)
    abstract ViewModel bindsFlightViewModel(FlightViewModel viewModel);

    @Binds
    @IntoMap
    @ViewModelKey(TicketViewModel.class)
    abstract ViewModel bindsTicketViewModel(TicketViewModel viewModel);
}
