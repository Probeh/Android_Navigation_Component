package com.probeh.navigation.common;
/*
    Created by Yonathan Probeh
    On Wednesday, Jun 24, 2020
*/
import android.os.Bundle;
import android.os.PersistableBundle;
import android.view.View;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public abstract class BaseActivity extends AppCompatActivity {
    
    // Constructors
    public BaseActivity() { }
    // Abstractions
    public abstract void initialize();
    public abstract void onSubmit(View view);
    // Overrides
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState, @Nullable PersistableBundle persistentState) {
        super.onCreate(savedInstanceState, persistentState);
    }
}
