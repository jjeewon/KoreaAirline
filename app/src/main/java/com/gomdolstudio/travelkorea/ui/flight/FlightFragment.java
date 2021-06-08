package com.gomdolstudio.travelkorea.ui.flight;

import com.gomdolstudio.travelkorea.databinding.FragmentSearchBinding;
import com.gomdolstudio.travelkorea.di.AppViewModelFactory;

import javax.inject.Inject;

import dagger.android.support.DaggerFragment;

public class FlightFragment extends DaggerFragment {

    /**
     * 오브젝트 그래프로부터 멤버 인젝션
     */
    @Inject
    FragmentSearchBinding binding;
    @Inject
    AppViewModelFactory viewModelFactory;

    FlightViewModel viewModel;

    
}
