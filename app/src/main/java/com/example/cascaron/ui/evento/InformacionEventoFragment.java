package com.example.cascaron.ui.evento;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.cascaron.R;
import com.example.cascaron.databinding.FragmentInformacionEventoBinding;
import com.example.cascaron.databinding.FragmentVentanaPrincipalBinding;

public class InformacionEventoFragment extends Fragment implements View.OnClickListener{

    private FragmentInformacionEventoBinding binding;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getActivity().setTitle(R.string.tvInfoEvento);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentInformacionEventoBinding.inflate(inflater, container, false);
        binding.btnCalendario.setOnClickListener(this);
        binding.btnInfoEventoAtras.setOnClickListener(this);
        binding.fabComentario.setOnClickListener(this);
        binding.btnUbicacion.setOnClickListener(this);
        return binding.getRoot();
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.btnCalendario:
                showCalendario();
                break;
            case R.id.btnInfoEventoAtras:
                NavHostFragment.findNavController(this).navigateUp();
                break;

            case R.id.fabComentario:
                anadirComentario();
                break;


            case R.id.btnUbicacion:
                Toast.makeText(getActivity(), R.string.toastUbicacion,Toast.LENGTH_SHORT).show();
                break;

        }
    }

    private void showCalendario() {
        Toast.makeText(getActivity(), R.string.toastCalendario,Toast.LENGTH_SHORT).show();
    }

    private void anadirComentario() {
        Toast.makeText(getActivity(), R.string.anadirComentario,Toast.LENGTH_SHORT).show();
    }
}