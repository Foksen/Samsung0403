package com.example.samsung0403;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import com.example.samsung0403.databinding.FragmentFirstBinding;

public class FirstFragment extends Fragment {
    private FragmentFirstBinding binding;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding = FragmentFirstBinding.inflate(inflater, container, false);

        binding.btnContinue.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (isInputValid())
                    moveToSecondFragment(getDataBundle());
                else
                    Toast.makeText(binding.getRoot().getContext(), "Недопустимый ввод", Toast.LENGTH_SHORT).show();
            }
        });

        return binding.getRoot();
    }

    private Boolean isInputValid() {
        if      (   binding.nameInput.getText().toString().equals("")
                ||  binding.nameInput.getText().toString().length() > 32
                ||  (!binding.rbMale.isChecked() && !binding.rbFemale.isChecked())
                ||  binding.ageInput.getText().toString().equals(""))
            return false;

        return true;
    }

    private Bundle getDataBundle() {
        Bundle bundle = new Bundle();

        bundle.putSerializable("name", binding.nameInput.getText().toString());
        bundle.putSerializable("gender", binding.rbMale.isChecked() ? "Мужской" : "Женский");
        bundle.putSerializable("age", binding.ageInput.getText().toString());

        return bundle;
    }

    private void moveToSecondFragment(Bundle bundle) {
        Navigation
                .findNavController(binding.getRoot())
                .navigate(R.id.action_firstFragment_to_secondFragment, bundle);
    }
}