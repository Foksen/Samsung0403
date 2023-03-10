package com.example.samsung0403;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.samsung0403.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {
    private ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
    }

    // Обратить внимание на атрибуты FragmentContainerView в activity_main.xml,
    // Обязательно должны быть defaultNavHost, navGraph. Идишники должны соответствовать!

    // Не забывать про dependencies в gradle!
}