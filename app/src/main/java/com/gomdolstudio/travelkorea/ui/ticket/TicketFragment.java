package com.gomdolstudio.travelkorea.ui.ticket;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.NavController;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.gomdolstudio.travelkorea.databinding.FragmentTicketBinding;
import com.gomdolstudio.travelkorea.di.AppViewModelFactory;

import javax.inject.Inject;

import dagger.Lazy;
import dagger.android.support.DaggerFragment;
import io.reactivex.rxjava3.annotations.NonNull;
import io.reactivex.rxjava3.annotations.Nullable;

public class TicketFragment extends DaggerFragment {
    @Inject
    FragmentTicketBinding binding;
    @Inject
    Lazy<NavController> navController;

    @Inject
    AppViewModelFactory viewModelFactory;

    TicketViewModel viewModel;
    
    @Inject
    TicketAdapter adapter;

    @Inject
    LinearLayoutManager layoutManager;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        viewModel = new ViewModelProvider(this, viewModelFactory).get(TicketViewModel.class);
        if(savedInstanceState == null){
            // Flight 객첼르 전달받는다.
            TicketFragmentArgs args = TicketFragmentArgs.fromBundle(getArguments());
            viewModel.load(args.getFlight());
        }


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
        binding.recyclerView.setAdapter(adapter);
        binding.recyclerView.setLayoutManager(layoutManager);
        binding.setViewModel(viewModel);


    }
}
