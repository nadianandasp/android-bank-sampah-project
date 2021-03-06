package com.sahitya.banksampahsahitya.presentation.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.sahitya.banksampahsahitya.R;
import com.sahitya.banksampahsahitya.model.Profile;

import java.util.ArrayList;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.BindView;
import butterknife.ButterKnife;

public class ProfileAdapter extends RecyclerView.Adapter<ProfileAdapter.ProfileViewHolder> {

    private Context context;

    private ArrayList<Profile> menuProfileList;

    public OnProfileClickListener onProfileClickListener;

    public ProfileAdapter(Context context, ArrayList<Profile> profileList) {
        this.context = context;
        this.menuProfileList = profileList;
    }

    public ArrayList<Profile> getMenuProfileList() {
        return menuProfileList;
    }

    public OnProfileClickListener getOnProfileClickListener(){
        return onProfileClickListener;
    }

    public void setOnProfileClickListener(OnProfileClickListener onProfileClickListener) {
        this.onProfileClickListener = onProfileClickListener;
    }

    @NonNull
    @Override
    public ProfileViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from((parent.getContext()));
        View view = layoutInflater.inflate(R.layout.item_profile, parent, false);
        return new ProfileViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ProfileViewHolder holder, int position) {
        holder.bind(menuProfileList.get(position));
    }

    @Override
    public int getItemCount() {
        return menuProfileList.size();
    }

    public class ProfileViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.container_menu_profile)
        CardView containerMenuProfile;

        @BindView(R.id.img_profile)
        ImageView imgProfile;

        @BindView(R.id.tv_profile)
        TextView tvProfile;

        public ProfileViewHolder(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }

        public void bind(Profile profile) {
            imgProfile.setImageResource(profile.getImgProfile());
            tvProfile.setText(profile.getTvProfile());

            containerMenuProfile.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    getOnProfileClickListener().onProfileClicked(view, getAdapterPosition());
                }
            });
        }
    }

    public interface OnProfileClickListener {
        void onProfileClicked(View view, int position);
    }
}
