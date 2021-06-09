package com.gomdolstudio.travelkorea.ui.ticket;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.navigation.NavController;

import com.gomdolstudio.travelkorea.databinding.FragmentTicketBinding;

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

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState){
        super.onCreate(savedInstanceState);

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
        
    }
}
