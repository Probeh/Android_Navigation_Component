package com.probeh.navigation.common;
/*
    Created by Yonathan Probeh
    On Wednesday, Jun 24, 2020
*/
import androidx.fragment.app.Fragment;

public abstract class BaseFragment extends Fragment {
    
    // Constructors
    public BaseFragment() {}
    // Abstractions
    public abstract void initialize();
    public abstract void onComplete();
}
