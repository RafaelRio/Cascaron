package com.example.cascaron.ui.listaAgrupacion.ManageAgrupacion;

import com.example.cascaron.Repository.AgrupacionRepository;
import com.example.cascaron.model.Agrupacion;

public class AgrupacionManageInteractor implements AgrupacionManageContract.OnRepositoryCallback, AgrupacionManageContract.Interactor {
    AgrupacionManageContract.OnRepositoryCallback callback;
    private AgrupacionManageContract.OnInteractorListener listener;

    public AgrupacionManageInteractor(AgrupacionManageContract.OnInteractorListener listener) {
        this.listener = listener;
    }

    @Override
    public void addAgrupacion(Agrupacion agrupacion) {
        if (agrupacion.getNombre().isEmpty()) {
            listener.onNameEmpty();
            return;
        }
        if (agrupacion.getDescripcion().isEmpty()) {
            listener.onDescriptionEmpty();
            return;
        }
        AgrupacionRepository.getInstance().add(listener, agrupacion);
    }

    @Override
    public void edit(Agrupacion agrupacion) {
        AgrupacionRepository.getInstance().edit(callback, agrupacion);
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
