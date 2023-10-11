package com.example.plannerapp.activities.application;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.plannerapp.R;
import com.example.plannerapp.dto.ApplicationForm;

import java.util.List;

public class ApplicationAdapter extends RecyclerView.Adapter<ApplicationHolder> {
    private List<ApplicationForm> applicationForms;

    public ApplicationAdapter(List<ApplicationForm> applicationForms) {
        this.applicationForms = applicationForms;
    }

    @NonNull
    @Override
    public ApplicationHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.application_view,parent,false);
        return new ApplicationHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ApplicationHolder holder, int position) {
        holder.tvId.setText(String.valueOf(applicationForms.get(position).getId()));
        holder.tvName.setText(applicationForms.get(position).getName());
        holder.tvMobile.setText(applicationForms.get(position).getMobileNumber());
        holder.tvEmail.setText(applicationForms.get(position).getEmail());
    }

    @Override
    public int getItemCount() {
        return this.applicationForms.size();
    }
}
