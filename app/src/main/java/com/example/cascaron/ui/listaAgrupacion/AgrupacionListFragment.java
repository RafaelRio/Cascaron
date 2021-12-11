package com.example.cascaron.ui.listaAgrupacion;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.cascaron.R;
import com.example.cascaron.databinding.FragmentAgrupacionListBinding;
import com.example.cascaron.model.Agrupacion;
import com.google.android.material.snackbar.BaseTransientBottomBar;
import com.google.android.material.snackbar.Snackbar;

import java.util.ArrayList;
import java.util.List;

public class AgrupacionListFragment extends Fragment implements AgrupacionListContract.View, AgrupacionAdapter.OnManageAgrupacionListener {

    private FragmentAgrupacionListBinding binding;
    private AgrupacionAdapter adapter;
    private AgrupacionListContract.Presenter presenter;
    private Agrupacion deleted;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //1. Se debe indicar a la activity que se quiere modificar el menu
        setHasOptionsMenu(true);
        //2. Se inicializa el presenter
        presenter = new AgrupacionListPresenter(this);
    }

    //2. Sobreescribir el metodo onCreateOptionsMenu para añadir el menu del fragment
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
                presenter.order();
                return true;
            case R.id.action_order_byDescription:
                adapter.orderByDescription();
                return true;
            default:
                //Si lsos fragments modifican el menu de la Activity se devuelve false
                return super.onOptionsItemSelected(item);
        }
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
        initRvDependency();
    }

    private void initRvDependency() {
        //1. Inicializar adapter
        adapter = new AgrupacionAdapter(new ArrayList<>(), this);

        //2. OBLIGATORIO -> Se debe indicar que el diseño (layout) tendrá el recyclerView
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity(), RecyclerView.VERTICAL, false);

        //3. Asignar el Layout al recyclerView
        binding.rvAgrupacion.setLayoutManager(linearLayoutManager);

        //4. Asigna a la vista sus datos (modelo)
        binding.rvAgrupacion.setAdapter(adapter);
    }

    @Override
    public void onStart() {
        super.onStart();
        presenter.load();
    }

    @Override
    public void onFailure(String mensaje) {

    }

    @Override
    public <T> void onSuccess(List<T> list) {

    }

    @Override
    public void onDeleteSuccess(String mensaje) {

    }

    @Override
    public void onUndoSuccess(String mensaje) {

    }

    @Override
    public void hideProgressBar() {

    }

    @Override
    public void showProgressBar() {

    }

    @Override
    public void onEditAgrupacion(Agrupacion agrupacion) {

    }

    @Override
    public void onDeleteAgrupacion(Agrupacion agrupacion) {

    }

    @Override
    public void showData(ArrayList<Agrupacion> list) {
        adapter.update(list);
    }

    @Override
    public void showNoData() {
        Toast.makeText(getActivity(), "Hola", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void showDataOrder() {
        adapter.order();
    }

    @Override
    public void showDataInverseOrder() {
        adapter.inverseOrder();
    }


}