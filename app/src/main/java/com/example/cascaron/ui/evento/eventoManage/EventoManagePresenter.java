package com.example.cascaron.ui.evento.eventoManage;

import com.example.cascaron.model.Evento;

public class EventoManagePresenter implements EventoManageContract.Presenter, EventoManageContract.OnInteractorListener {
    private EventoManageContract.View view;
    private EventoManageContract.Interactor interactor;

    public EventoManagePresenter(EventoManageContract.View view) {
        this.view = view;
        this.interactor = new EventoManageInteractor(this);
    }

    @Override
    public void addEvento(Evento e) {
        interactor.addEvento(e);
    }

    @Override
    public void edit(Evento e) {
        interactor.edit(e);
    }

    @Override
    public void onDestroy() {
        this.interactor = null;
        this.view = null;
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
        view.onEditFailure();
    }
}
