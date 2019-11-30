package com.sahitya.banksampahsahitya;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Spinner;
import android.widget.Toast;

import com.sahitya.banksampahsahitya.model.RegistersModel;
import com.sahitya.banksampahsahitya.rest.service.RegisterApiService;
import com.sahitya.banksampahsahitya.tools.DatePickerFragment;
import com.sahitya.banksampahsahitya.utils.RegisterApiUtils;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class RegisterActivity extends AppCompatActivity implements View.OnClickListener, DatePickerFragment.DialogDateListener, AdapterView.OnItemSelectedListener {

    private final String TAG = RegisterActivity.class.getSimpleName();
    private final static String DATE_PICKER_TAG = "DatePicker";

    @BindView(R.id.edit_text_name_register)
    EditText editTextName;
    @BindView(R.id.edit_text_nim_register)
    EditText editTextNim;
    @BindView(R.id.spinner_fakultas_register)
    Spinner spinnerFakultas;
    @BindView(R.id.spinner_jurusan_register)
    Spinner spinnerJurusan;
    @BindView(R.id.edit_text_no_hp_register)
    EditText editTextNoHp;
    @BindView(R.id.edit_text_alamat_register)
    EditText editTextAlamat;
    @BindView(R.id.btn_set_calendar)
    ImageButton btnCalendar;
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
    private ProgressDialog loading;

    private String fakultas;
    private String jurusan;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        unbinder = ButterKnife.bind(this);

        ArrayAdapter<CharSequence> adapterFakultas = ArrayAdapter.createFromResource(this, R.array.fakultas, android.R.layout.simple_spinner_item);
        adapterFakultas.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerFakultas.setAdapter(adapterFakultas);

        ArrayAdapter<CharSequence> adapterJurusan = ArrayAdapter.createFromResource(this, R.array.jurusan_no_selected, android.R.layout.simple_spinner_item);
        adapterJurusan.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerJurusan.setAdapter(adapterJurusan);

        mRegisterApiService = RegisterApiUtils.getRegisterApiService();

        spinnerFakultas.setOnItemSelectedListener(this);
        spinnerJurusan.setOnItemSelectedListener(this);
        btnDaftar.setOnClickListener(this);
        btnCalendar.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        if (view.getId() == R.id.btn_daftar_register){
            String name = editTextName.getText().toString().trim();
            String nim = editTextNim.getText().toString().trim();
            String noHp = editTextNoHp.getText().toString().trim();
            String alamat = editTextAlamat.getText().toString().trim();
            String ttl = editTextTtl.getText().toString().trim();
            String email = editTextEmail.getText().toString().trim();
            String password = editTextPassword.getText().toString().trim();
            String konfirmasiPassword = editTextKonfirmasiPassword.getText().toString().trim();

            if (!TextUtils.isEmpty(name) && !TextUtils.isEmpty(nim) && !fakultas.equals("Pilih Fakultas") && !jurusan.equals("Pilih Jurusan") && !TextUtils.isEmpty(noHp) && !TextUtils.isEmpty(alamat) && !TextUtils.isEmpty(ttl) && !TextUtils.isEmpty(email) && !TextUtils.isEmpty(password) && !TextUtils.isEmpty(konfirmasiPassword)){
                if (password.equals(konfirmasiPassword)){
                    loading = ProgressDialog.show(this, null, "Harap Tunggu...", true, false);
                    sendRegisterPost(name, email, password, konfirmasiPassword, nim, fakultas, jurusan, noHp, alamat, ttl);
                }else{
                    Toast.makeText(this, "Password Tidak Sama", Toast.LENGTH_SHORT).show();
                }
            }else if (fakultas.equals("Pilih Fakultas") || jurusan.equals("Pilih Jurusan")){
                Toast.makeText(this, "Fakultas atau Jurusan harus dipilih", Toast.LENGTH_SHORT).show();
            }else{
                Toast.makeText(this, "Field Tidak Boleh Kosong", Toast.LENGTH_SHORT).show();
            }
        }else if (view.getId() == R.id.btn_set_calendar){
            DatePickerFragment datePickerFragment = new DatePickerFragment();
            datePickerFragment.show(getSupportFragmentManager(), DATE_PICKER_TAG);
        }
    }



    private void sendRegisterPost(String name, String email, String password, String konfirmasiPassword, String nim, String fakultas, String jurusan, String noHp, String alamat, String ttl ) {
        mRegisterApiService.saveRegisterPost(name, email, password, konfirmasiPassword, nim, fakultas, jurusan, noHp, alamat, ttl).enqueue(new Callback<RegistersModel>() {
            @Override
            public void onResponse(Call<RegistersModel> call, Response<RegistersModel> response) {
                if (response.isSuccessful()){
                    loading.dismiss();
                    Log.d(TAG, response.body().toString());
                    startActivity(new Intent(getApplicationContext(), RegisterSuccesfullyActivity.class));
                    Log.d(TAG, "Sukses");
                }else{
                    loading.dismiss();
                    Log.d(TAG, "Gagal");
                    Toast.makeText(RegisterActivity.this, "Anda tidak berhasil register", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<RegistersModel> call, Throwable t) {
                loading.dismiss();
                Log.d(TAG, "Unable to submit post to API");
                Log.i(TAG, t.toString());
            }
        });
    }

    @Override
    public void onDialogDateSet(String tag, int year, int month, int dayOfMonth) {
        Calendar calendar = Calendar.getInstance();
        calendar.set(year, month, dayOfMonth);
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd", Locale.getDefault());

        editTextTtl.setText(dateFormat.format(calendar.getTime()));
    }

    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int position, long l) {
        switch (adapterView.getId()){
            case R.id.spinner_fakultas_register :
                fakultas = adapterView.getItemAtPosition(position).toString();

                ArrayAdapter<CharSequence> adapterJurusan;

                if (fakultas.equals("Pilih Fakultas")){
                    adapterJurusan = ArrayAdapter.createFromResource(this, R.array.jurusan_no_selected, android.R.layout.simple_spinner_item);
                    adapterJurusan.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                    spinnerJurusan.setAdapter(adapterJurusan);
                }else if (fakultas.equals("Ilmu Tarbiyah dan Keguruan")){
                    adapterJurusan = ArrayAdapter.createFromResource(this, R.array.jurusan_fitk, android.R.layout.simple_spinner_item);
                    adapterJurusan.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                    spinnerJurusan.setAdapter(adapterJurusan);
                }else if (fakultas.equals("Adab Dan Humaniora")){
                    adapterJurusan = ArrayAdapter.createFromResource(this, R.array.jurusan_adab_humaniora, android.R.layout.simple_spinner_item);
                    adapterJurusan.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                    spinnerJurusan.setAdapter(adapterJurusan);
                }else if (fakultas.equals("Ushuluddin")){
                    adapterJurusan = ArrayAdapter.createFromResource(this, R.array.jurusan_ushuluddin, android.R.layout.simple_spinner_item);
                    adapterJurusan.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                    spinnerJurusan.setAdapter(adapterJurusan);
                }else if (fakultas.equals("Syariah Dan Hukum")){
                    adapterJurusan = ArrayAdapter.createFromResource(this, R.array.jurusan_syariah_hukum, android.R.layout.simple_spinner_item);
                    adapterJurusan.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                    spinnerJurusan.setAdapter(adapterJurusan);
                }else if (fakultas.equals("Dakwah Dan Ilmu Komunikasi")){
                    adapterJurusan = ArrayAdapter.createFromResource(this, R.array.jurusan_dakwah_komunikasi, android.R.layout.simple_spinner_item);
                    adapterJurusan.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                    spinnerJurusan.setAdapter(adapterJurusan);
                }else if (fakultas.equals("Dirasat Islamiyah")){
                    adapterJurusan = ArrayAdapter.createFromResource(this, R.array.jurusan_dirasat, android.R.layout.simple_spinner_item);
                    adapterJurusan.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                    spinnerJurusan.setAdapter(adapterJurusan);
                }else if (fakultas.equals("Psikologi")){
                    adapterJurusan = ArrayAdapter.createFromResource(this, R.array.jurusan_psikologi, android.R.layout.simple_spinner_item);
                    adapterJurusan.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                    spinnerJurusan.setAdapter(adapterJurusan);
                }else if (fakultas.equals("Ekonomi Dan Bisnis")){
                    adapterJurusan = ArrayAdapter.createFromResource(this, R.array.jurusan_ekonomi, android.R.layout.simple_spinner_item);
                    adapterJurusan.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                    spinnerJurusan.setAdapter(adapterJurusan);
                }else if (fakultas.equals("Sains Dan Teknologi")){
                    adapterJurusan = ArrayAdapter.createFromResource(this, R.array.jurusan_sains_teknologi, android.R.layout.simple_spinner_item);
                    adapterJurusan.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                    spinnerJurusan.setAdapter(adapterJurusan);
                }else if (fakultas.equals("Ilmu Kesehatan")){
                    adapterJurusan = ArrayAdapter.createFromResource(this, R.array.jurusan_ilmu_kesehatan, android.R.layout.simple_spinner_item);
                    adapterJurusan.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                    spinnerJurusan.setAdapter(adapterJurusan);
                }else if (fakultas.equals("Ilmu Sosial Dan Ilmu Politik")){
                    adapterJurusan = ArrayAdapter.createFromResource(this, R.array.jurusan_isip, android.R.layout.simple_spinner_item);
                    adapterJurusan.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                    spinnerJurusan.setAdapter(adapterJurusan);
                }else if (fakultas.equals("Kedokteran")){
                    adapterJurusan = ArrayAdapter.createFromResource(this, R.array.jurusan_kedokteran, android.R.layout.simple_spinner_item);
                    adapterJurusan.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                    spinnerJurusan.setAdapter(adapterJurusan);
                }
                return;

            case R.id.spinner_jurusan_register :
                jurusan = adapterView.getItemAtPosition(position).toString();
                return;
        }
    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }
}