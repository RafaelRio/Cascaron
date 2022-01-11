package com.example.cascaron.ui.perfilAgrupacion;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.fragment.NavHostFragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.cascaron.R;
import com.example.cascaron.databinding.FragmentBusquedaAgrupacionBinding;
import com.example.cascaron.databinding.FragmentPerfilAgrupacionBinding;

public class PerfilAgrupacionFragment extends Fragment {
FragmentPerfilAgrupacionBinding binding;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getActivity().setTitle(R.string.perfil_agrupacion);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentPerfilAgrupacionBinding.inflate(inflater, container, false);
        binding.fabSeguir.setOnClickListener(view -> seguir());
        binding.imgAtras.setOnClickListener(view -> atras());
        return binding.getRoot();
    }

    private void atras() {
        NavHostFragment.findNavController(this).navigateUp();
    }

    private void seguir() {
        Toast.makeText(getActivity(), R.string.fabSeguir, Toast.LENGTH_LONG).show();
    }
}