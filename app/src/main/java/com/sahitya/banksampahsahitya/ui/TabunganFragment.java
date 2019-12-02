package com.sahitya.banksampahsahitya.ui;


import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.sahitya.banksampahsahitya.R;
import com.sahitya.banksampahsahitya.presentation.disbursement.DisbursementActivity;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * A simple {@link Fragment} subclass.
 */
public class TabunganFragment extends Fragment {

    @BindView(R.id.linear_history_disbursement)
    LinearLayout linearHistoryDisbursement;

    Unbinder unbinder;

    private TextView tvTotalUang, tvTotalSampah, tvRiwayatTransaksi;

    public TabunganFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_tabungan, container, false);
        unbinder = ButterKnife.bind(this, view);

        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        tvTotalUang = view.findViewById(R.id.tv_total_uang);
        tvTotalSampah = view.findViewById(R.id.tv_amount_of_waste);
        tvRiwayatTransaksi = view.findViewById(R.id.tv_riwayat_transaksi);

        DetailsHistoryDisbursement();
    }

    private void DetailsHistoryDisbursement() {
        linearHistoryDisbursement.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DisbursementActivity.start(getContext());
            }
        });
    }

}
