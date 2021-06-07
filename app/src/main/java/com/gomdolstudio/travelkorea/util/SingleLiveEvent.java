package com.gomdolstudio.travelkorea.util;

import androidx.annotation.MainThread;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;

import java.util.concurrent.atomic.AtomicBoolean;


import io.reactivex.rxjava3.annotations.Nullable;
import timber.log.Timber;

public class SingleLiveEvent<T> extends MutableLiveData<T> {
    private final AtomicBoolean mPending = new AtomicBoolean(false);

    @MainThread
    public void observe(LifecycleOwner owner, final Observer<? super T> observer){
        if(hasActiveObservers()){
            Timber.w("여러 Observer가 존재하지만, 단 하나만 알림을 받을 수 있다.");
        }

        super.observe(owner, t -> {
            if(mPending.compareAndSet(true, false)){
                observer.onChanged(t);
            }
        });
    }

    @MainThread
    public void setValue(@Nullable T t){
        mPending.set(true);
        super.setValue(t);
    }

    @MainThread
    public void call(){
        setValue(null);
    }
}
