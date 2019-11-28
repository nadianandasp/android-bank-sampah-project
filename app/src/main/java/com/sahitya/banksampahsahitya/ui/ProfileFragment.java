package com.sahitya.banksampahsahitya.ui;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.sahitya.banksampahsahitya.R;
import com.sahitya.banksampahsahitya.model.ProfilesModel;
import com.sahitya.banksampahsahitya.presentation.adapter.ProfileAdapter;
import com.sahitya.banksampahsahitya.presentation.membership.SettingsActivity;
import com.sahitya.banksampahsahitya.presentation.membership.changepassword.ChangePasswordActivity;
import com.sahitya.banksampahsahitya.presentation.membership.disbursement.DisbursementActivity;
import com.sahitya.banksampahsahitya.presentation.membership.editprofile.EditProfileActivity;
import com.sahitya.banksampahsahitya.presentation.membership.login.LoginActivity;

import java.util.ArrayList;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
/**
 * A simple {@link Fragment} subclass.
 */
public class ProfileFragment extends Fragment {

    @BindView(R.id.img_avatar)
    ImageView imgAvatar;
    @BindView(R.id.tv_name)
    TextView tvName;
    @BindView(R.id.tv_email)
    TextView tvEmail;
    @BindView(R.id.rv_profile)
    RecyclerView rvProfile;
    @BindView(R.id.container_logout)
    LinearLayout containerLogout;
    @BindView(R.id.linear_profile)
    LinearLayout linearProfile;

    Unbinder unbinder;

    public ProfileFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_profile, container, false);

        unbinder = ButterKnife.bind(this, view);

        setListMenuProfile();

        setLogoutAccount();

        return view;
    }

    private void setLogoutAccount() {
        containerLogout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getContext(), "Logout", Toast.LENGTH_SHORT).show();
                startActivity(new Intent(getContext(), LoginActivity.class));
            }
        });
    }

    private void setListMenuProfile() {
        ArrayList<ProfilesModel> profilesModelList = new ArrayList<>();

        profilesModelList.add(new ProfilesModel(R.drawable.ic_disbursement, "Pencairan"));
        profilesModelList.add(new ProfilesModel(R.drawable.ic_edit_profile, "Edit ProfilesModel"));
        profilesModelList.add(new ProfilesModel(R.drawable.ic_change_password, "Ganti Password"));
        profilesModelList.add(new ProfilesModel(R.drawable.ic_setting, "Pengaturan"));

        ProfileAdapter profileAdapter = new ProfileAdapter(getContext(), profilesModelList);

        rvProfile.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false));
        rvProfile.setAdapter(profileAdapter);

        profileAdapter.setOnProfileClickListener(new ProfileAdapter.OnProfileClickListener() {

            @Override
            public void onProfileClicked(View view, int position) {
                switch (position) {
                    case 0:
                        DisbursementActivity.start(getContext());
                        break;
                    case 1:
                        EditProfileActivity.start(getContext());
                        break;
                    case 2:
                        ChangePasswordActivity.start(getContext());
                        break;
                    case 3:
                        SettingsActivity.start(getContext());
                        break;
                }
            }
        });
    }

}
