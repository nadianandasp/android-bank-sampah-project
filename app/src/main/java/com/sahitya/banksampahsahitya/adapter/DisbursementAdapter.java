package com.sahitya.banksampahsahitya.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.sahitya.banksampahsahitya.R;
import com.sahitya.banksampahsahitya.model.DisburmentModel;

import java.util.ArrayList;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.BindView;
import butterknife.ButterKnife;

public class DisbursementAdapter extends RecyclerView.Adapter<DisbursementAdapter.DisburmentViewHolder> {

    private ArrayList<DisburmentModel> disburmentModels;

    public OnDisburmentClickListener onDisburmentClickListener;

    public DisbursementAdapter(ArrayList<DisburmentModel> disburmentModels) {
        this.disburmentModels = disburmentModels;
    }

    public ArrayList<DisburmentModel> getDisburmentModels() {
        return disburmentModels;
    }

    public void setDisburmentModels(ArrayList<DisburmentModel> disburmentModels) {
        this.disburmentModels = disburmentModels;
    }

    public OnDisburmentClickListener getOnDisburmentClickListener() {
        return onDisburmentClickListener;
    }

    public void setOnDisburmentClickListener(OnDisburmentClickListener onDisburmentClickListener) {
        this.onDisburmentClickListener = onDisburmentClickListener;
    }

    @NonNull
    @Override
    public DisburmentViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from((parent.getContext()));
        View view = layoutInflater.inflate(R.layout.item_disbursement, parent, false);
        return new DisburmentViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull DisburmentViewHolder holder, int position) {
        holder.bind(disburmentModels.get(position));

    }

    @Override
    public int getItemCount() {
        return disburmentModels.size();
    }

    public class DisburmentViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.tv_amount)
        TextView tvAmount;

        @BindView(R.id.tv_time)
        TextView tvTime;

        @BindView(R.id.tv_date)
        TextView tvDate;

        public DisburmentViewHolder(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }

        public void bind(DisburmentModel disburmentModel) {
            tvAmount.setText(disburmentModel.getTvAmount());
            tvDate.setText(disburmentModel.getTvDate());
            tvTime.setText(disburmentModel.getTvTime());
        }
    }

    private interface OnDisburmentClickListener {
        void OnDisburmentClicked(View view, int position);
    }
}
