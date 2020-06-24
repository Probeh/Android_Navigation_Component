package com.probeh.navigation.register;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.probeh.navigation.common.BaseFragment;
import com.probeh.navigation.common.BaseViewModel;
import com.probeh.navigation.databinding.FragmentRegisterBinding;

public class RegisterFragment extends BaseFragment {
    
    protected FragmentRegisterBinding binding;
    protected BaseViewModel model;
    public RegisterFragment() {
        this.model = new BaseViewModel("Register Start", "Registration Instructions", "Registration Introduction");
    }
    public RegisterFragment(BaseViewModel model) {
        this.model = model;
    }
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        this.binding = FragmentRegisterBinding.inflate(inflater);
        this.binding.setModel(this.model);
        return this.binding.getRoot();
    }
    @Override
    public void initialize() { }
    @Override
    public void onComplete() { }
}