package com.example.cascaron.ui.perfilUsuario;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.cascaron.R;
import com.example.cascaron.databinding.FragmentPerfilUsuarioBinding;

public class PerfilUsuarioFragment extends Fragment {

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getActivity().setTitle(R.string.perfil_usuario);
    }

    FragmentPerfilUsuarioBinding binding;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentPerfilUsuarioBinding.inflate(inflater,container,false);
        binding.btnAtrasPerfilUsuario.setOnClickListener(view -> volverAtras());
        return binding.getRoot();
    }

    private void volverAtras() {
        NavHostFragment.findNavController(this).navigateUp();
    }
}