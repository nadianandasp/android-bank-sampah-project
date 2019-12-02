package com.sahitya.banksampahsahitya.presentation.membership;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import com.sahitya.banksampahsahitya.R;

import androidx.appcompat.app.AppCompatActivity;

public class SettingsActivity extends AppCompatActivity {

    public static void start(Context context) {
        Intent starter = new Intent(context, SettingsActivity.class);
        context.startActivity(starter);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);
    }
}
