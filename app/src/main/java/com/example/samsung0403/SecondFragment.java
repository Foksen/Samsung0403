package com.example.samsung0403;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.samsung0403.databinding.FragmentSecondBinding;

public class SecondFragment extends Fragment {
    private FragmentSecondBinding binding;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding = FragmentSecondBinding.inflate(inflater, container, false);

        assert getArguments() != null;
        String name = getArguments().getString("name");
        String gender = getArguments().getString("gender");
        String age = getArguments().getString("age");

        binding.userName.setText(name);
        binding.userGender.setText(gender);
        binding.userAge.setText(age);

        return binding.getRoot();
    }
}