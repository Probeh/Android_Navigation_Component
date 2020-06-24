package com.probeh.navigation.common;
/*
    Created by Yonathan Probeh
    On Wednesday, Jun 24, 2020
*/
import androidx.fragment.app.Fragment;

import com.probeh.navigation.utilities.Subscription;

public abstract class BaseFragment extends Fragment {
    
    public Subscription<Object> emitter = new Subscription<>();
    // Constructors
    public BaseFragment() {}
    // Abstractions
    public abstract void initialize();
    public abstract void onComplete();
}
