package com.example.myhome1.ui.fragment;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.myhome1.R;
import com.example.myhome1.databinding.FragmentHomeBinding;
import com.example.myhome1.interfaces.OnItemClick;
import com.example.myhome1.model.TaskModel;
import com.example.myhome1.ui.adapter.TaskAdapter;
import com.example.myhome1.ui.viewmodel.SharedViewModel;

import java.util.ArrayList;

public class HomeFragment extends Fragment {

    FragmentHomeBinding binding;
    TaskAdapter adapter = new TaskAdapter();
    SharedViewModel mainViewModel;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentHomeBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    private void initId() {
        binding.btn.setOnClickListener(v -> {
            Toast.makeText(getContext(), "Вот Ваш Список", Toast.LENGTH_SHORT).show();
            mainViewModel.fetchData();
            binding.btn.setVisibility(View.GONE);

        });
        mainViewModel.mutableLiveData.observe(getViewLifecycleOwner(), new Observer<ArrayList<TaskModel>>() {
            @Override
            public void onChanged(ArrayList<TaskModel> model) {
                adapter.addlist(model);
            }
        });
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initRecView();
        ininilize();
        initId();
        setupListener();
    }

    private void setupListener() {
        adapterClickListener();
    }

    private void adapterClickListener() {
        adapter.setOnItemClick(new OnItemClick() {
            @Override
            public void OnClick(int pos) {
                mainViewModel.setPosition(pos);
                Log.e("pos", "OnClick: " + pos);
                NavController navController = Navigation.findNavController(requireActivity(), R.id.nav_host_fragment);
                navController.navigate(R.id.action_homeFragment_to_detailFragment2);
            }
        });
    }

    private void ininilize() {
        mainViewModel = new ViewModelProvider(requireActivity()).get(SharedViewModel.class);
    }

    private void initRecView() {
        binding.rec.setLayoutManager(new LinearLayoutManager(getContext()));
        binding.rec.setAdapter(adapter);
    }
}