package com.example.cascaron.ui.signup;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.cascaron.databinding.ActivitySignUpBinding;

public class SignUpActivity extends AppCompatActivity {
    ActivitySignUpBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding=ActivitySignUpBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        /**
         * Se utiliza el metodo OnBackPressed para eliminar la Activity SignUpActivity
         * y restaurar la actividad anterior LoginActivity
         */
        binding.btnSignUp.setOnClickListener((view -> onBackPressed()));
        binding.btnCuentaCreada.setOnClickListener((view -> onBackPressed()));
    }
}