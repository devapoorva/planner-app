package com.example.plannerapp.activities.application;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.plannerapp.R;

public class ApplicationHolder extends RecyclerView.ViewHolder {
    TextView tvName,tvId,tvMobile,tvEmail;
    public ApplicationHolder(@NonNull View itemView) {
        super(itemView);
        tvName = itemView.findViewById(R.id.tvAppName);
        tvId = itemView.findViewById(R.id.tvAppId);
        tvMobile = itemView.findViewById(R.id.tvAppMobile);
        tvEmail = itemView.findViewById(R.id.tvAppEmail);
    }
}
