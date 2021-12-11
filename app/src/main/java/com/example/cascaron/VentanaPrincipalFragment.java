package com.example.cascaron;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.cascaron.databinding.FragmentVentanaPrincipalBinding;

public class VentanaPrincipalFragment extends Fragment implements View.OnClickListener{

    private FragmentVentanaPrincipalBinding binding;


    public View onCreateView(
            LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState
    ) {

        binding = FragmentVentanaPrincipalBinding.inflate(inflater, container, false);
        binding.btnBuscar.setOnClickListener(this);
        binding.btnEvento.setOnClickListener(this);
        binding.btnCalendar.setOnClickListener(this);
        binding.btnUsusario.setOnClickListener(this);
        binding.fabPublicarEvento.setOnClickListener(this);
        binding.btnAboutUs.setOnClickListener(this);
        binding.btnRecycler.setOnClickListener(this);
        return binding.getRoot();

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.btnBuscar:
                showBusquedaAgrupaciones();
                break;
            case R.id.fabPublicarEvento:
                showPublicacionEvento();
                break;

            case R.id.btnCalendar:
                showCalendario();
                break;

            case R.id.btnEvento:
                showInfoEvento();
                break;

            case R.id.btnUsusario:
                showPerfilUsuario();
                break;

            case R.id.btnAboutUs:
                showAboutUs();
                break;

            case R.id.btnRecycler:
                showRecycler();
                break;
        }
    }

    public void showRecycler(){
        NavHostFragment.findNavController(this).navigate(R.id.action_ventanaPrincipal_to_agrupacionListFragment);
    }

    private void showAboutUs() {
        NavHostFragment.findNavController(this).navigate(R.id.action_ventanaPrincipal_to_aboutUsFragment);
    }

    private void showInfoEvento() {
        NavHostFragment.findNavController(this).navigate(R.id.action_ventanaPrincipal_to_informacionEventoFragment);
    }

    private void showBusquedaAgrupaciones(){
        NavHostFragment.findNavController(this).navigate(R.id.action_ventanaPrincipal_to_busquedaAgrupacion);
    }

    private void showPerfilUsuario(){
        NavHostFragment.findNavController(this).navigate(R.id.action_ventanaPrincipal_to_perfilUsuarioFragment);
    }
    private void showCalendario(){
        NavHostFragment.findNavController(this).navigate(R.id.action_ventanaPrincipal_to_calendarioFragment);
    }
    private void showPublicacionEvento(){
        NavHostFragment.findNavController(this).navigate(R.id.action_ventanaPrincipal_to_subidaEventoFragment);
    }


}