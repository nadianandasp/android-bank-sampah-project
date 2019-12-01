package com.sahitya.banksampahsahitya;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.google.android.material.textfield.TextInputLayout;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

public class VerificationCodeActivity extends AppCompatActivity {

    @BindView(R.id.btn_verification_code)
    Button btnVerificationCode;

    @BindView(R.id.edit_text_verification_code)
    TextInputLayout edtVerificationCode;

    private Unbinder unbinder;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_verification_code);

        unbinder = ButterKnife.bind(this);

        btnVerificationCode.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String verificationCode = edtVerificationCode.getEditText().getText().toString().trim();

                startActivity(new Intent(getApplicationContext(), MainActivity.class));
            }
        });
    }
}
