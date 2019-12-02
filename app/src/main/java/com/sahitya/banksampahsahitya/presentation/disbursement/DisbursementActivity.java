package com.sahitya.banksampahsahitya.presentation.disbursement;

import android.content.Context;
import android.content.Intent;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.TextView;

import com.sahitya.banksampahsahitya.R;
import com.sahitya.banksampahsahitya.adapter.DisbursementAdapter;
import com.sahitya.banksampahsahitya.model.DisburmentModel;

import java.util.ArrayList;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.BindView;
import butterknife.ButterKnife;

public class DisbursementActivity extends AppCompatActivity {

    @BindView(R.id.tv_total_income)
    TextView tvTotalIncome;

    @BindView(R.id.rv_history_disbursement)
    RecyclerView rvHistoryDisbursement;
    @BindView(R.id.toolbar)
    Toolbar toolbar;

    private ArrayList<DisburmentModel> disburmentModels = new ArrayList<>();

    public static void start(Context context) {
        Intent starter = new Intent(context, DisbursementActivity.class);
        context.startActivity(starter);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_disbursement);
        ButterKnife.bind(this);

        setListHistoryDisbursement();

        DisbursementAdapter disbursementAdapter = new DisbursementAdapter(disburmentModels);
        rvHistoryDisbursement.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
        rvHistoryDisbursement.setAdapter(disbursementAdapter);

        setSupportActionBar(toolbar);
        toolbar.setBackgroundColor(getResources().getColor(R.color.colorPrimaryDark));
        toolbar.setTitleTextColor(getResources().getColor(R.color.white));
        getSupportActionBar().setTitle(getString(R.string.label_disbursement));
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        final Drawable upArrow = ContextCompat.getDrawable(this, R.drawable.abc_ic_ab_back_material);
        upArrow.setColorFilter(ContextCompat.getColor(this, R.color.white), PorterDuff.Mode.SRC_ATOP);
        getSupportActionBar().setHomeAsUpIndicator(upArrow);
    }

    private void setListHistoryDisbursement() {

        disburmentModels.add(new DisburmentModel(getString(R.string.value_amount_1), getString(R.string.value_time_1), getString(R.string.value_date_1)));
        disburmentModels.add(new DisburmentModel(getString(R.string.value_amount_2), getString(R.string.value_time_2), getString(R.string.value_date_1)));
        disburmentModels.add(new DisburmentModel(getString(R.string.value_amount_3), getString(R.string.value_time_3), getString(R.string.value_date_3)));
        disburmentModels.add(new DisburmentModel(getString(R.string.value_amount_4), getString(R.string.value_time_4), getString(R.string.value_date_3)));
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (item.getItemId() == android.R.id.home){
            onBackPressed();
        }
        return super.onOptionsItemSelected(item);
    }
}
