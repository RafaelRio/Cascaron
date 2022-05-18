package com.example.cascaron.ui.evento;

import com.example.cascaron.model.Evento;

import java.util.List;

public class EventoListPresenter implements EventoListContract.Presenter {
    private EventoListContract.Interactor interactor;
    private EventoListContract.View view;

    public EventoListPresenter(EventoListContract.View view) {
        this.view = view;
        this.interactor = new EventoListInteractor(this);
    }
    @Override
    public void onDestroy() {
        this.interactor = null;
        this.view = null;
    }

    @Override
    public void load() {
        view.showProgress();
        interactor.load();
    }

    @Override
    public void delete(Evento e) {
        interactor.delete(e);
    }

    @Override
    public void onListSuccess(List<Evento> eventos) {
        view.hideProgress();
        view.onListSuccess(eventos);
    }

    @Override
    public void onNoData() {

    }
}
