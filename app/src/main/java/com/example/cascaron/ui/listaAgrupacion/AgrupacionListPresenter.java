package com.example.cascaron.ui.listaAgrupacion;

import com.example.cascaron.model.Agrupacion;

import java.util.ArrayList;
import java.util.List;

public class AgrupacionListPresenter implements AgrupacionListContract.Presenter, AgrupacionListContract.OnInteractorListener {
    private AgrupacionListContract.View view;
    private AgrupacionListInteractor interactor;
    private Boolean order = false;

    public AgrupacionListPresenter(AgrupacionListContract.View view) {
        this.view = view;
        this.interactor = new AgrupacionListInteractor(this);
    }

    @Override
    public void load() {
        view.showProgressBar();
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
    public void undo(Agrupacion agrupacion) {
        interactor.undo(agrupacion);
    }

    @Override
    public void order() {
        if (order == true) {
            order = false;
            view.showDataInverseOrder();
        } else {
            order = true;
            view.showDataOrder();
        }
    }

    @Override
    public void onFailure(String mensaje) {

    }

    @Override
    public <T> void onSuccess(List<T> list) {
        if (list.size() == 0) {
            view.showNoData();
        } else {
            view.showData((ArrayList<Agrupacion>) list);
        }
        view.hideProgressBar();
    }

    @Override
    public void onDeleteSuccess(String mensaje) {
        view.onDeleteSuccess(mensaje);
    }

    @Override
    public void onUndoSuccess(String mensaje) {
        view.onUndoSuccess(mensaje);
    }

    @Override
    public void onDestroy() {
        this.interactor = null;
        this.view = null;
    }
}
