package com.example.cascaron.ui.listaAgrupacion;

import com.example.cascaron.model.Agrupacion;

import java.util.ArrayList;
import java.util.List;

public class AgrupacionListPresenter implements AgrupacionListContract.Presenter {
    private AgrupacionListContract.View view;
    private AgrupacionListInteractor interactor;

    public AgrupacionListPresenter(AgrupacionListContract.View view) {
        this.view = view;
        this.interactor = new AgrupacionListInteractor(this);
    }

    @Override
    public void load() {
        view.showProgress();
        interactor.load();
    }

    /**
     * Este metodo elimina una agrupacion de toda la aplicacion (BD, repositorio...)
     *
     * @param agrupacion
     */
    @Override
    public void delete(Agrupacion agrupacion) {
        interactor.delete(agrupacion);
    }

    @Override
    public void onDestroy() {
        this.interactor = null;
        this.view = null;
    }

    @Override
    public void onListSuccess(List<Agrupacion> agrupaciones) {
        view.hideProgress();
        view.onListSuccess(agrupaciones);
    }

    @Override
    public void onNoData() {

    }
}
