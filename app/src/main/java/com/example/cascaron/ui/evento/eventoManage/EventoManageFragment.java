package com.example.cascaron.ui.evento.eventoManage;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.cascaron.R;
import com.example.cascaron.databinding.FragmentEventoManageBinding;
import com.example.cascaron.model.Evento;
import com.example.cascaron.ui.listaAgrupacion.ManageAgrupacion.AgrupacionManageFragment;

public class EventoManageFragment extends Fragment implements EventoManageContract.View {

    FragmentEventoManageBinding binding;
    EventoManageContract.Presenter presenter;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        presenter = new EventoManagePresenter(this);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentEventoManageBinding.inflate(inflater, container, false);
        return binding.getRoot();

    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        if (EventoManageFragmentArgs.fromBundle(getArguments()).getEvento() != null) {
            initView(EventoManageFragmentArgs.fromBundle(getArguments()).getEvento());
            initFabEdit();
        } else {
            initFabAdd();
        }
    }

    private void initView(Evento evento) {
        binding.tieNombre.setText(evento.getNombre());
        binding.tieDescripcion.setText(evento.getDescripcion());
    }

    private Evento getEvento() {
        Evento evento = new Evento();
        if (EventoManageFragmentArgs.fromBundle(getArguments()).getEvento() != null)
            evento.setNombre(EventoManageFragmentArgs.fromBundle(getArguments()).getEvento().getNombre());
        evento.setNombre(binding.tieNombre.getText().toString());
        evento.setDescripcion(binding.tieDescripcion.getText().toString());

        return evento;
    }

    private void initFabAdd() {
        binding.floatingActionButton2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                presenter.addEvento(getEvento());
                NavHostFragment.findNavController(EventoManageFragment.this).navigateUp();
            }
        });
    }

    private void initFabEdit() {
        binding.floatingActionButton2.setImageResource(R.drawable.ic_edit);
        binding.tieNombre.setEnabled(false);
        binding.floatingActionButton2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                presenter.edit(getEvento());
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