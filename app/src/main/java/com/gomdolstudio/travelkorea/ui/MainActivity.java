package com.gomdolstudio.travelkorea.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.gomdolstudio.travelkorea.R;
import com.gomdolstudio.travelkorea.databinding.ActivityMainBinding;

import javax.inject.Inject;

import dagger.Lazy;
import dagger.android.support.DaggerAppCompatActivity;

public class MainActivity extends DaggerAppCompatActivity {

    // 바인딩 클래스 주입
    @Inject
    Lazy<ActivityMainBinding> binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // 이 액티비티를 lifecycleOwner로 설정하여,
        // 생명주기에 안전하게 데이터 바인딩할 수 있게 함 .
        binding.get().setLifecycleOwner(this);
    }
}