package com.sahitya.banksampahsahitya.adapter;

import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class GarbageInfoAdapter extends RecyclerView.Adapter<GarbageInfoAdapter.GarbageInfoViewHolder> {
    @NonNull
    @Override
    public GarbageInfoViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull GarbageInfoViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }

    public class GarbageInfoViewHolder extends RecyclerView.ViewHolder {
        public GarbageInfoViewHolder(@NonNull View itemView) {
            super(itemView);
        }
    }
}
