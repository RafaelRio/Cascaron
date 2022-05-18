package com.example.cascaron.ui.listaAgrupacion.ManageAgrupacion;

import com.example.cascaron.model.Agrupacion;

public class AgrupacionManagePresenter implements AgrupacionManageContract.Presenter, AgrupacionManageContract.OnInteractorListener {
    private AgrupacionManageContract.View view;
    private AgrupacionManageContract.Interactor interactor;

    public AgrupacionManagePresenter(AgrupacionManageContract.View view) {
        this.view = view;
        this.interactor = new AgrupacionManageInteractor(this);
    }

    @Override
    public void onNameEmpty() {
        view.setEmptyName();
    }

    @Override
    public void onDescriptionEmpty() {
        view.setEmptyDescription();
    }

    @Override
    public void onAddSuccess() {
        view.onAddSuccess();
    }

    @Override
    public void onEditSuccess() {
        view.onEditSuccess();
    }

    @Override
    public void onAddFailure() {
        view.onAddFailure();
    }

    @Override
    public void onEditFailure() {
    }

    @Override
    public void addAgrupacion(Agrupacion agrupacion) {
        interactor.addAgrupacion(agrupacion);
    }

    @Override
    public void edit(Agrupacion agrupacion) {
        interactor.edit(agrupacion);
    }

    @Override
    public void onDestroy() {
        this.view = null;
        this.interactor = null;
    }
}
