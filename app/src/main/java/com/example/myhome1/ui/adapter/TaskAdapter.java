package com.example.myhome1.ui.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myhome1.R;
import com.example.myhome1.databinding.ItemHomeBinding;
import com.example.myhome1.model.TaskModel;

import java.util.ArrayList;


public class TaskAdapter extends RecyclerView.Adapter<TaskAdapter.ViewHolder> {

    ItemHomeBinding binding;
    ArrayList<TaskModel> list = new ArrayList<>();

    public void addlist(ArrayList<TaskModel> models) {
        this.list = models;
        notifyDataSetChanged();
    }


    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        binding = ItemHomeBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false);
        return new ViewHolder(binding.getRoot());
    }

    @Override
    public void onBindViewHolder(@NonNull TaskAdapter.ViewHolder holder, int position) {
        holder.onBind(list.get(position));
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
        }

        public void onBind(TaskModel taskModel) {
            binding.imageView.setImageResource(taskModel.getImageview());
            binding.textView.setText(taskModel.getTitle());

        }
    }
}

