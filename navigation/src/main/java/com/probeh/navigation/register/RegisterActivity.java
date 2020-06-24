package com.probeh.navigation.register;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import androidx.databinding.DataBindingUtil;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;

import com.probeh.navigation.R;
import com.probeh.navigation.common.BaseActivity;
import com.probeh.navigation.databinding.ActivityRegisterBinding;

public class RegisterActivity extends BaseActivity {
    
    private static final String TAG = "* RegisterActivity";
    private ActivityRegisterBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.binding = DataBindingUtil.setContentView(this, R.layout.activity_register);
        NavController navigation = Navigation.findNavController(this, R.id.register_content);
        navigation.addOnDestinationChangedListener((controller, destination, arguments) -> {
            Log.i(TAG, "onCreate: Navigation Changed");
            Log.i(TAG, "Destination: " + destination.getLabel() + ", ID: " + destination.getId());
        });
    }
    @Override
    public void initialize() { }
    @Override
    public void onSubmit(View view) {
        Log.i(TAG, "onSubmit: ");
        
    }
}