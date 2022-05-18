package com.example.cascaron;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

import com.example.cascaron.databinding.FragmentVentanaPrincipalBinding;

public class VentanaPrincipalFragment extends Fragment implements View.OnClickListener{

    private FragmentVentanaPrincipalBinding binding;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setHasOptionsMenu(true);
    }

    @Override
    public void onResume() {
        super.onResume();
        getActivity().setTitle(R.string.app_name);
    }

    public View onCreateView(
            LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState
    ) {

        binding = FragmentVentanaPrincipalBinding.inflate(inflater, container, false);
        binding.btnEvento.setOnClickListener(this);
        binding.fabPublicarEvento.setOnClickListener(this);
        binding.btnRecycler.setOnClickListener(this);
        return binding.getRoot();

    }



    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.fabPublicarEvento:
                showPublicacionEvento();
                break;

            case R.id.btnEvento:
                showInfoEvento();
                break;

            case R.id.btnRecycler:
                showRecycler();
                break;
        }
    }

    public void showRecycler(){
        NavHostFragment.findNavController(this).navigate(R.id.action_ventanaPrincipal_to_agrupacionListFragment);
    }

    private void showInfoEvento() {
        NavHostFragment.findNavController(this).navigate(R.id.action_ventanaPrincipal_to_informacionEventoFragment);
    }

    private void showPublicacionEvento(){
        NavHostFragment.findNavController(this).navigate(R.id.action_ventanaPrincipal_to_subidaEventoFragment);
    }


}