package com.example.cascaron.ui.evento.eventoManage;

import com.example.cascaron.model.Agrupacion;
import com.example.cascaron.model.Evento;

public interface EventoManageContract {
    interface View extends OnRepositoryCallback {
        void setEmptyName();
        void setEmptyDescription();
    }

    interface Presenter {
        void addEvento(Evento e);
        void edit(Evento e);
        void onDestroy();
    }

    interface Interactor extends OnRepositoryCallback {
        void addEvento(Evento e);
        void edit(Evento e);
    }

    interface OnInteractorListener extends OnRepositoryCallback {
        void onNameEmpty();
        void onDescriptionEmpty();
    }

    interface OnRepositoryCallback{
        void onAddSuccess();
        void onEditSuccess();

        void onAddFailure();
        void onEditFailure();
    }

    interface Repository{
        void add(OnRepositoryCallback callback, Evento e);
        void edit(OnRepositoryCallback callback, Evento e);
    }
}
