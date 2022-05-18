package com.example.cascaron.ui.evento;

import com.example.cascaron.model.Agrupacion;
import com.example.cascaron.model.Evento;
import com.example.cascaron.ui.base.BasePresenter;
import com.example.cascaron.ui.listaAgrupacion.AgrupacionListContract;

import java.util.List;

public interface EventoListContract {
    interface View extends OnRepositoryCallback {
        void showProgress();
        void hideProgress();
    }

    interface Presenter extends BasePresenter, OnRepositoryCallback {
        void load();
        void delete(Evento e);
    }

    interface Interactor extends OnRepositoryCallback {
        void load();
        void delete(Evento e);
    }

    interface Repository {
        void delete(OnRepositoryCallback callback, Evento evento);
    }

    interface OnRepositoryCallback {
        void onListSuccess(List<Evento> agrupaciones);
        void onNoData();
    }
}
