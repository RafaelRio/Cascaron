package com.example.cascaron.ui.listaAgrupacion;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.cascaron.R;
import com.example.cascaron.databinding.FragmentAgrupacionListBinding;
import com.example.cascaron.model.Agrupacion;

import java.util.ArrayList;
import java.util.List;

public class AgrupacionListFragment extends Fragment implements AgrupacionListContract.View, AgrupacionAdapter.OnManageAgrupacionListener {

    private FragmentAgrupacionListBinding binding;
    private AgrupacionAdapter adapter;
    private AgrupacionListContract.Presenter presenter;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //1. Se debe indicar a la activity que se quiere modificar el menu
        //setHasOptionsMenu(true);
        //2. Se inicializa el presenter
        presenter = new AgrupacionListPresenter(this);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding = FragmentAgrupacionListBinding.inflate(inflater);
        return binding.getRoot();
    }


    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        binding.floatingActionButton.setOnClickListener(view1 -> {
            NavHostFragment.findNavController(AgrupacionListFragment.this).navigate(R.id.action_agrupacionListFragment_to_agrupacionManageFragment);
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
        adapter = new AgrupacionAdapter(new ArrayList<Agrupacion>(), this);

        //2. OBLIGATORIO -> Se debe indicar que el diseño (layout) tendrá el recyclerView
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity(), RecyclerView.VERTICAL, false);

        //3. Asignar el Layout al recyclerView
        binding.rvAgrupacion.setLayoutManager(linearLayoutManager);

        //4. Asigna a la vista sus datos (modelo)
        binding.rvAgrupacion.setAdapter(adapter);
    }

    private void initFab() {
        binding.floatingActionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AgrupacionListFragmentDirections.ActionAgrupacionListFragmentToAgrupacionManageFragment action = AgrupacionListFragmentDirections.actionAgrupacionListFragmentToAgrupacionManageFragment(null);
                NavHostFragment.findNavController(AgrupacionListFragment.this).navigate(action);
            }
        });
    }


    @Override
    public void onEditAgrupacion(Agrupacion agrupacion) {
        AgrupacionListFragmentDirections.ActionAgrupacionListFragmentToAgrupacionManageFragment action = AgrupacionListFragmentDirections.actionAgrupacionListFragmentToAgrupacionManageFragment(agrupacion);
        NavHostFragment.findNavController(AgrupacionListFragment.this).navigate(action);
    }

    @Override
    public void onDeleteAgrupacion(Agrupacion agrupacion) {
        presenter.delete(agrupacion);
    }

    @Override
    public void showProgress() {

    }

    @Override
    public void hideProgress() {

    }

    @Override
    public void onListSuccess(List<Agrupacion> agrupaciones) {
        adapter.update(agrupaciones);
    }

    @Override
    public void onNoData() {

    }

    /*
    * //2. Sobreescribir el metodo onCreateOptionsMenu para añadir el menu del fragment
    @Override
    public void onCreateOptionsMenu(@NonNull Menu menu, @NonNull MenuInflater inflater) {
        inflater.inflate(R.menu.agrupacionlist_menu, menu);
        super.onCreateOptionsMenu(menu, inflater);

    }

    //3. Implementar las acciones especificas (item) del menu del fragment
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.action_orderAgrupacion:
                //presenter.order();
                return true;
            case R.id.action_order_byDescription:
                //adapter.orderByDescription();
                return true;
            default:
                //Si lsos fragments modifican el menu de la Activity se devuelve false
                return super.onOptionsItemSelected(item);
        }
    }

    * */
}