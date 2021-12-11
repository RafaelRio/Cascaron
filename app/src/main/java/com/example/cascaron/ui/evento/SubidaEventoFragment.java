package com.example.cascaron.ui.evento;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.cascaron.R;
import com.example.cascaron.databinding.FragmentSubidaEventoBinding;

public class SubidaEventoFragment extends Fragment implements View.OnClickListener {

    private FragmentSubidaEventoBinding binding;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding = FragmentSubidaEventoBinding.inflate(inflater, container, false);
        binding.btnBorrarCampos.setOnClickListener(this);
        binding.btnPublicarEvento.setOnClickListener(this);
        return binding.getRoot();
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.btnBorrarCampos:
                borrarCampos();
                break;
            case R.id.btnPublicarEvento:
                publicarEvento();
                break;
        }
    }

    private void publicarEvento() {
        Toast.makeText(getActivity(), R.string.publicacionEvento, Toast.LENGTH_LONG).show();
    }

    private void borrarCampos() {
        binding.tieNombreEvento.setText("");
        binding.tieFechaInicioEvento.setText("");
        binding.tieFechFinEvento.setText("");
        binding.tieTipoEvento.setText("");
        binding.tieUbicacionEvento.setText("");
        binding.tieDescripcion.setText("");
    }
}