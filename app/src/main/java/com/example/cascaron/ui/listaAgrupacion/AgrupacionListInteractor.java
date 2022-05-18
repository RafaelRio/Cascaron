package com.example.cascaron.ui.listaAgrupacion;

import com.example.cascaron.Repository.AgrupacionRepository;
import com.example.cascaron.model.Agrupacion;

import java.util.List;

public class AgrupacionListInteractor implements AgrupacionListContract.Interactor {

    private AgrupacionListContract.OnRepositoryCallback listener;

    public AgrupacionListInteractor(AgrupacionListContract.OnRepositoryCallback listener) {
        this.listener = listener;
    }

    @Override
    public void onListSuccess(List<Agrupacion> agrupaciones) {
        listener.onListSuccess(agrupaciones);
    }

    @Override
    public void onNoData() {
        listener.onNoData();
    }

    @Override
    public void load() {
        AgrupacionRepository.getInstance().getList(this);
    }

    @Override
    public void delete(Agrupacion agrupacion) {
        AgrupacionRepository.getInstance().delete(this, agrupacion);
    }
}
