package com.example.plannerapp.activities.users;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.plannerapp.R;

public class UserViewHolder extends RecyclerView.ViewHolder {
    TextView tvUserName;
    TextView tvUserEmail;
    public UserViewHolder(@NonNull View itemView) {
        super(itemView);
        tvUserName = itemView.findViewById(R.id.tvUserName);
        tvUserEmail = itemView.findViewById(R.id.tvUserEmail);
    }
}
