package com.probeh.navigation;
import android.os.Bundle;
import android.view.View;

import com.probeh.navigation.R;
import com.probeh.navigation.common.BaseActivity;

public class SplashActivity extends BaseActivity {
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
    }
    @Override
    public void initialize() {}
    @Override
    public void onSubmit(View view) { }
}