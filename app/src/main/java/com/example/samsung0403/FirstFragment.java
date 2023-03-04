package com.example.samsung0403;

import static com.example.samsung0403.Gender.FEMALE;
import static com.example.samsung0403.Gender.MALE;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import com.example.samsung0403.databinding.FragmentFirstBinding;

import java.io.Serializable;

public class FirstFragment extends Fragment {
    private FragmentFirstBinding binding;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        binding = FragmentFirstBinding.inflate(inflater, container, false);
        Button btnContinue = binding.btnContinue;

        btnContinue.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                
            }
        });
        return binding.getRoot();
    }

    private Bundle makePersonBundle(Person person) {
        Bundle bundle = new Bundle();
        bundle.putSerializable("person", (Serializable)person);
        return bundle;
    }

    private Person getPersonData() {
        String name = binding.nameInput.getText().toString();
        int age = Integer.parseInt(binding.ageInput.getText().toString());
        Gender gender = MALE;
        if (binding.rbFemale.isChecked())
            gender = FEMALE;

        return new Person(name, age, gender);
    }

    private void moveToSecondFragment(Bundle bundle) {
        Navigation
                .findNavController(binding.getRoot())
                .navigate(R.id.action_firstFragment_to_secondFragment, bundle);
    }
}