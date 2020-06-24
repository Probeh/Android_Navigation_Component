package com.probeh.navigation.barcode;
import android.os.Bundle;
import android.view.View;

import com.probeh.navigation.R;
import com.probeh.navigation.common.BaseActivity;

public class BarcodeActivity extends BaseActivity {
    
    public BarcodeActivity() {}
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_barcode);
    }
    @Override
    public void initialize() { }
    @Override
    public void onSubmit(View view) { }
}