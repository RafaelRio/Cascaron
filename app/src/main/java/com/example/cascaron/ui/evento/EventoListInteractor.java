package com.example.cascaron.ui.evento;

import com.example.cascaron.Repository.EventoRepository;
import com.example.cascaron.model.Evento;

import java.util.List;

public class EventoListInteractor implements EventoListContract.Interactor {
    private EventoListContract.OnRepositoryCallback listener;

    public EventoListInteractor(EventoListContract.OnRepositoryCallback listener) {
        this.listener = listener;
    }

    @Override
    public void load() {
        EventoRepository.getInstance().getList(this);
    }

    @Override
    public void delete(Evento e) {
        EventoRepository.getInstance().delete(this, e);
    }

    @Override
    public void onListSuccess(List<Evento> eventos) {
        listener.onListSuccess(eventos);
    }

    @Override
    public void onNoData() {
        listener.onNoData();
    }
}
