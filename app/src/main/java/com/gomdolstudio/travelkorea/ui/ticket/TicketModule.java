package com.gomdolstudio.travelkorea.ui.ticket;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.navigation.NavController;
import androidx.navigation.fragment.NavHostFragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

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

    @Provides
    @FragmentScope
    public NavController provideNavController(TicketFragment fragment){
        return NavHostFragment.findNavController(fragment);
    }

    // RecyclerView용 레이아웃 매니저
    @Provides
    @FragmentScope
    LinearLayoutManager provideLinearLayoutManager(@ApplicationContext Context context){
        return new LinearLayoutManager(context){
            @Override
            public RecyclerView.LayoutParams generateDefaultLayoutParams(){
                return new RecyclerView.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,
                        ViewGroup.LayoutParams.WRAP_CONTENT);
            }
        };
    }

}
