package com.example.cascaron.ui.busqueda;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;

import com.example.cascaron.R;
import com.example.cascaron.databinding.FragmentBusquedaAgrupacionBinding;

public class BusquedaAgrupacion extends Fragment {

    FragmentBusquedaAgrupacionBinding binding;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getActivity().setTitle(R.string.tvBusquedaAgrupaciones);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding = FragmentBusquedaAgrupacionBinding.inflate(inflater, container, false);


        binding.btnBorrar.setOnClickListener(view -> BorrarCampos());
        binding.btnAgrupacionEncontrada.setOnClickListener(view -> toPerfilAgrupacion());

        String[] tipos = {  "Banda de musica (BM)","Agrupacion Musical (AM)",
                            "Banda de cornetas y tambores (CCTT)",
                            "Banda sinfonica (BS)",
                            "Capilla musical (CP)",
                            "Orquesta (ORQ)",
                            "Grupo de musica (GM)"
        };

        binding.spinnerTipoAgrupacion.setAdapter(new ArrayAdapter<String>(getActivity(), R.layout.support_simple_spinner_dropdown_item, tipos));

        return binding.getRoot();
    }

    private void BorrarCampos() {
        binding.tieNombre.setText("");
    }

    private void toPerfilAgrupacion(){
        NavHostFragment.findNavController(this).navigate(R.id.action_busquedaAgrupacion_to_perfilAgrupacionFragment);
    }

}