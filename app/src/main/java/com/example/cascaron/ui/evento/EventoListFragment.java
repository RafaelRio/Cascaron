package com.example.cascaron.ui.evento;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.cascaron.AgrupacionDatabase;
import com.example.cascaron.R;
import com.example.cascaron.databinding.FragmentAgrupacionListBinding;
import com.example.cascaron.databinding.FragmentEventoListBinding;
import com.example.cascaron.model.Agrupacion;
import com.example.cascaron.model.Evento;
import com.example.cascaron.ui.listaAgrupacion.AgrupacionAdapter;
import com.example.cascaron.ui.listaAgrupacion.AgrupacionListFragment;
import com.example.cascaron.ui.listaAgrupacion.AgrupacionListFragmentDirections;
import com.example.cascaron.ui.listaAgrupacion.AgrupacionListPresenter;

import java.util.ArrayList;
import java.util.List;

public class EventoListFragment extends Fragment implements EventoListContract.View, EventoAdapter.OnManageEventoListener {

    FragmentEventoListBinding binding;
    EventoAdapter adapter;
    EventoListContract.Presenter presenter;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //1. Se debe indicar a la activity que se quiere modificar el menu
        //setHasOptionsMenu(true);
        //2. Se inicializa el presenter
        presenter = new EventoListPresenter(this);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding = FragmentEventoListBinding.inflate(inflater);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        binding.floatingActionButton.setOnClickListener(view1 -> {
            NavHostFragment.findNavController(EventoListFragment.this).navigate(R.id.action_informacionEventoFragment_to_eventoManageFragment);
        });

        initRv();
        initFab();
    }

    @Override
    public void onStart() {
        super.onStart();
        presenter.load();
    }

    private void initRv() {
        //1. Inicializar adapter
        adapter = new EventoAdapter(new ArrayList<Evento>(), this);

        //2. OBLIGATORIO -> Se debe indicar que el diseño (layout) tendrá el recyclerView
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity(), RecyclerView.VERTICAL, false);

        //3. Asignar el Layout al recyclerView
        binding.rvEvento.setLayoutManager(linearLayoutManager);

        //4. Asigna a la vista sus datos (modelo)
        binding.rvEvento.setAdapter(adapter);
    }

    private void initFab() {
        binding.floatingActionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                EventoListFragmentDirections.ActionInformacionEventoFragmentToEventoManageFragment action = EventoListFragmentDirections.actionInformacionEventoFragmentToEventoManageFragment(null);
                NavHostFragment.findNavController(EventoListFragment.this).navigate(action);
            }
        });
    }

    @Override
    public void onEditEvento(Evento evento) {
        EventoListFragmentDirections.ActionInformacionEventoFragmentToEventoManageFragment action = EventoListFragmentDirections.actionInformacionEventoFragmentToEventoManageFragment(evento);
        NavHostFragment.findNavController(EventoListFragment.this).navigate(action);
    }

    @Override
    public void onDeleteEvento(Evento evento) {
presenter.delete(evento);
    }

    @Override
    public void showProgress() {

    }

    @Override
    public void hideProgress() {

    }

    @Override
    public void onListSuccess(List<Evento> eventos) {
        adapter.update(eventos);
    }

    @Override
    public void onNoData() {

    }
}