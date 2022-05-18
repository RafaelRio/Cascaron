package com.example.cascaron.ui.listaAgrupacion.ManageAgrupacion;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;

import com.example.cascaron.R;
import com.example.cascaron.databinding.FragmentAgrupacionManageBinding;
import com.example.cascaron.model.Agrupacion;

public class AgrupacionManageFragment extends Fragment implements AgrupacionManageContract.View {

    FragmentAgrupacionManageBinding binding;
    AgrupacionManageContract.Presenter presenter;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        presenter = new AgrupacionManagePresenter(this);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentAgrupacionManageBinding.inflate(inflater, container, false);
        return binding.getRoot();

    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        if (AgrupacionManageFragmentArgs.fromBundle(getArguments()).getAgrupacion() != null) {
            initView(AgrupacionManageFragmentArgs.fromBundle(getArguments()).getAgrupacion());
            initFabEdit();
        } else {
            initFabAdd();
        }
    }

    private void initView(Agrupacion agrupacion) {
        binding.tieNombre.setText(agrupacion.getNombre());
        binding.tieDescripcion.setText(agrupacion.getDescripcion());
    }

    private Agrupacion getAgrupacion() {
        Agrupacion agrupacion = new Agrupacion();
        if (AgrupacionManageFragmentArgs.fromBundle(getArguments()).getAgrupacion() != null)
            agrupacion.setNombre(AgrupacionManageFragmentArgs.fromBundle(getArguments()).getAgrupacion().getNombre());
        agrupacion.setNombre(binding.tieNombre.getText().toString());
        agrupacion.setDescripcion(binding.tieDescripcion.getText().toString());

        return agrupacion;
    }

    private void initFabAdd() {
        binding.floatingActionButton2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                presenter.addAgrupacion(getAgrupacion());
                NavHostFragment.findNavController(AgrupacionManageFragment.this).navigateUp();
            }
        });
    }

    private void initFabEdit() {
        binding.floatingActionButton2.setImageResource(R.drawable.ic_edit);
        binding.tieNombre.setEnabled(false);
        binding.floatingActionButton2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                presenter.edit(getAgrupacion());
            }
        });
    }

    @Override
    public void setEmptyName() {
        binding.tieNombre.setError("Este campo no puede estar vacio");
    }

    @Override
    public void setEmptyDescription() {
        binding.tieDescripcion.setError("Este campo no puede estar vacio");
    }

    @Override
    public void onAddSuccess() {

    }

    @Override
    public void onEditSuccess() {

    }

    @Override
    public void onAddFailure() {

    }

    @Override
    public void onEditFailure() {

    }
}