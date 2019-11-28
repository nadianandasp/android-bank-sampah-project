package com.sahitya.banksampahsahitya;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.sahitya.banksampahsahitya.model.RegistersModel;
import com.sahitya.banksampahsahitya.rest.service.RegisterApiService;
import com.sahitya.banksampahsahitya.utils.RegisterApiUtils;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class RegisterActivity extends AppCompatActivity implements View.OnClickListener {

    private final String TAG = RegisterActivity.class.getSimpleName();

    @BindView(R.id.edit_text_name_register)
    EditText editTextName;
    @BindView(R.id.edit_text_nim_register)
    EditText editTextNim;
    @BindView(R.id.edit_text_fakultas_register)
    EditText editTextFakultas;
    @BindView(R.id.edit_text_jurusan_register)
    EditText editTextJurusan;
    @BindView(R.id.edit_text_no_hp_register)
    EditText editTextNoHp;
    @BindView(R.id.edit_text_alamat_register)
    EditText editTextAlamat;
    @BindView(R.id.edit_text_ttl_register)
    EditText editTextTtl;
    @BindView(R.id.edit_text_email_register)
    EditText editTextEmail;
    @BindView(R.id.edit_text_password_register)
    EditText editTextPassword;
    @BindView(R.id.edit_text_konfirmasi_password_register)
    EditText editTextKonfirmasiPassword;
    @BindView(R.id.btn_daftar_register)
    Button btnDaftar;

    private Unbinder unbinder;

    private RegisterApiService mRegisterApiService;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        unbinder = ButterKnife.bind(this);

        mRegisterApiService = RegisterApiUtils.getRegisterApiService();

        btnDaftar.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        if (view.getId() == R.id.btn_daftar_register){
            String name = editTextName.getText().toString().trim();
            String nim = editTextNim.getText().toString().trim();
            String fakultas = editTextFakultas.getText().toString().trim();
            String jurusan = editTextJurusan.getText().toString().trim();
            String noHp = editTextNoHp.getText().toString().trim();
            String alamat = editTextAlamat.getText().toString().trim();
            String ttl = editTextTtl.getText().toString().trim();
            String email = editTextEmail.getText().toString().trim();
            String password = editTextPassword.getText().toString().trim();
            String konfirmasiPassword = editTextKonfirmasiPassword.getText().toString().trim();

            if (!TextUtils.isEmpty(name) && !TextUtils.isEmpty(nim) && !TextUtils.isEmpty(fakultas) && !TextUtils.isEmpty(jurusan) && !TextUtils.isEmpty(noHp) && !TextUtils.isEmpty(alamat) && !TextUtils.isEmpty(ttl) && !TextUtils.isEmpty(email) && !TextUtils.isEmpty(password) && !TextUtils.isEmpty(konfirmasiPassword)){
                sendRegisterPost(name, nim, fakultas, jurusan, noHp, alamat, ttl, email, password, konfirmasiPassword);
            }
        }
    }

    private void sendRegisterPost(String name, String nim, String fakultas, String jurusan, String noHp, String alamat, String ttl, String email, String password, String konfirmasiPassword) {
        mRegisterApiService.saveRegisterPost(name, nim, fakultas, jurusan, noHp, alamat, ttl, email, password, konfirmasiPassword).enqueue(new Callback<RegistersModel>() {
            @Override
            public void onResponse(Call<RegistersModel> call, Response<RegistersModel> response) {
                if (response.isSuccessful()){
                    Log.d(TAG, response.body().toString());
                    Log.d(TAG, "Sukses");
                }else{
                    Log.d(TAG, "Gagal");
                }
            }

            @Override
            public void onFailure(Call<RegistersModel> call, Throwable t) {
                Log.d(TAG, "Unable to submit post to API");
                Log.i(TAG, t.toString());
            }
        });
    }
}
