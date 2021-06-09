package com.gomdolstudio.travelkorea.ui.flight;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;

import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.NavController;

import com.gomdolstudio.travelkorea.data.entity.AirportId;
import com.gomdolstudio.travelkorea.databinding.FragmentSearchBinding;
import com.gomdolstudio.travelkorea.di.AppViewModelFactory;

import javax.inject.Inject;

import dagger.Lazy;
import dagger.android.support.DaggerFragment;
import io.reactivex.rxjava3.annotations.NonNull;
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

    ArrayAdapter<String> arrayAdapter;

    @Inject
    Lazy<NavController> navController;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        // ViewModel 객체 요청
        viewModel = new ViewModelProvider(this, viewModelFactory).get(FlightViewModel.class);
        AirportId airportIdList = new AirportId();
        arrayAdapter = new ArrayAdapter<>(getContext(), android.R.layout.simple_spinner_dropdown_item,airportIdList.getAirportIdList());
        binding.arrAirportId.setAdapter(arrayAdapter);
        binding.depAirportId.setAdapter(arrayAdapter);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState){
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState){
        super.onViewCreated(view, savedInstanceState);
        binding.setLifecycleOwner(getViewLifecycleOwner());
        binding.setViewModel(viewModel);

        viewModel.getSearchBtnClickEvent()
                .observe(getViewLifecycleOwner(), flightItem ->
                        navController.get().navigate(FlightFragmentDirections.actionFlightFragmentToTicketFragment(flightItem.getFlight())));
    }

}
