package com.gomdolstudio.travelkorea.ui.flight;

import android.os.Bundle;

import androidx.lifecycle.ViewModelProvider;

import com.gomdolstudio.travelkorea.databinding.FragmentSearchBinding;
import com.gomdolstudio.travelkorea.di.AppViewModelFactory;

import javax.inject.Inject;

import dagger.android.support.DaggerFragment;
import io.reactivex.rxjava3.annotations.Nullable;

public class FlightFragment extends DaggerFragment {

    /**
     * 오브젝트 그래프로부터 멤버 인젝션
     */
    @Inject
    FragmentSearchBinding binding;
    @Inject
    AppViewModelFactory viewModelFactory;

    FlightViewModel viewModel;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        // ViewModel 객체 요청
        viewModel = new ViewModelProvider(this, viewModelFactory).get(FlightViewModel.class);
    }
}
