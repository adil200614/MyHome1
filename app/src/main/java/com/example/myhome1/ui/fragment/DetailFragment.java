package com.example.myhome1.ui.fragment;

import android.content.SharedPreferences;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.myhome1.databinding.FragmentDetailBinding;
import com.example.myhome1.databinding.ItemHomeBinding;
import com.example.myhome1.ui.adapter.TaskAdapter;
import com.example.myhome1.ui.viewmodel.SharedViewModel;

public class DetailFragment extends Fragment {


    FragmentDetailBinding binding;
    TaskAdapter adapter = new TaskAdapter();
    SharedViewModel viewModel;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentDetailBinding.inflate(getLayoutInflater(), container, false);
        ininilize();
        getData();
        return binding.getRoot();


    }


    private void ininilize() {
        viewModel = new ViewModelProvider(requireActivity()).get(SharedViewModel.class);
    }

    private void getData() {
        viewModel.setPosition(viewModel.pos);
        binding.description.setText(viewModel.list.get(viewModel.pos).getDesc());

    }
}
