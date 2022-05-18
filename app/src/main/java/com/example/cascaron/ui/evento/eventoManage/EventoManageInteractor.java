package com.example.cascaron.ui.evento.eventoManage;

import com.example.cascaron.Repository.AgrupacionRepository;
import com.example.cascaron.Repository.EventoRepository;
import com.example.cascaron.model.Evento;

public class EventoManageInteractor implements EventoManageContract.Interactor, EventoManageContract.OnRepositoryCallback{

    EventoManageContract.OnRepositoryCallback callback;
    EventoManageContract.OnInteractorListener listener;

    public EventoManageInteractor(EventoManageContract.OnInteractorListener listener){
        this.listener = listener;
    }

    @Override
    public void addEvento(Evento e) {
        if (e.getNombre().isEmpty()) {
            listener.onNameEmpty();
            return;
        }
        if (e.getDescripcion().isEmpty()) {
            listener.onDescriptionEmpty();
            return;
        }
        EventoRepository.getInstance().add(listener, e);
    }

    @Override
    public void edit(Evento e) {
        EventoRepository.getInstance().edit(callback, e);
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
