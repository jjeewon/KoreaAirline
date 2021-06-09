package com.gomdolstudio.travelkorea.ui.ticket;

import android.content.Context;
import android.view.LayoutInflater;

import com.gomdolstudio.travelkorea.databinding.FragmentTicketBinding;
import com.gomdolstudio.travelkorea.di.ApplicationContext;
import com.gomdolstudio.travelkorea.di.FragmentScope;

import dagger.Module;
import dagger.Provides;

@Module
public class TicketModule {

    @Provides
    @FragmentScope
    public FragmentTicketBinding provideBinding(@ApplicationContext Context context){
        return FragmentTicketBinding.inflate(LayoutInflater.from(context), null, false);
    }

}
