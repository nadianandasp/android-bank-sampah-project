package com.sahitya.banksampahsahitya.presentation.membership.editprofile;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import com.sahitya.banksampahsahitya.R;
import com.sahitya.banksampahsahitya.presentation.membership.disbursement.DisbursementActivity;

public class EditProfileActivity extends AppCompatActivity {

    public static void start(Context context) {
        Intent starter = new Intent(context, EditProfileActivity.class);
        context.startActivity(starter);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_profile);
    }
}
