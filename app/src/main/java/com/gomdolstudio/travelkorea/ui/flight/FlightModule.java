package com.gomdolstudio.travelkorea.ui.flight;

import android.content.Context;
import android.view.LayoutInflater;

import androidx.navigation.NavController;
import androidx.navigation.fragment.NavHostFragment;

import com.gomdolstudio.travelkorea.databinding.FragmentSearchBinding;
import com.gomdolstudio.travelkorea.di.ApplicationContext;
import com.gomdolstudio.travelkorea.di.FragmentScope;

import dagger.Module;
import dagger.Provides;

@Module
public class FlightModule {
    // 데이터 바인딩 클래스 제공
    @Provides
    @FragmentScope
    FragmentSearchBinding provideBinding(@ApplicationContext Context context){
        return FragmentSearchBinding.inflate(LayoutInflater.from(context),null,false);
    }

    // Navigation 컴포넌트에서 목적지 간 이동을 담당하는 NavController
    @Provides
    @FragmentScope
    NavController provideNavController(FlightFragment fragment){
        return NavHostFragment.findNavController(fragment);
    }
}
