package com.example.cascaron.ui.evento;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;

import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.cascaron.R;
import com.example.cascaron.databinding.FragmentSubidaEventoBinding;

public class SubidaEventoFragment extends Fragment implements View.OnClickListener {

    private FragmentSubidaEventoBinding binding;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getActivity().setTitle(R.string.subida_evento);
        setHasOptionsMenu(true);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding = FragmentSubidaEventoBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        binding.fabAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getActivity(), R.string.addEvent, Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public void onCreateOptionsMenu(@NonNull Menu menu, @NonNull MenuInflater inflater) {
        inflater.inflate(R.menu.publicacionevento_menu, menu);
        super.onCreateOptionsMenu(menu, inflater);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.action_delete:
                borrarCampos();
                return true;
            default:
                //Si lsos fragments modifican el menu de la Activity se devuelve false
                return super.onOptionsItemSelected(item);
        }
    }

    private void borrarCampos() {
        binding.tieNombreEvento.setText("");
        binding.tieFechaInicioEvento.setText("");
        binding.tieFechFinEvento.setText("");
        binding.tieTipoEvento.setText("");
        binding.tieUbicacionEvento.setText("");
        binding.tieDescripcion.setText("");
    }

    @Override
    public void onClick(View view) {

    }
}