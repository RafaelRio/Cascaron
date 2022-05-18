package com.example.cascaron.ui.listaAgrupacion.ManageAgrupacion;

import com.example.cascaron.model.Agrupacion;

public interface AgrupacionManageContract {
    interface View extends OnRepositoryCallback{
        void setEmptyName();
        void setEmptyDescription();
    }

    interface Presenter {
        void addAgrupacion(Agrupacion agrupacion);
        void edit(Agrupacion agrupacion);
        void onDestroy();
    }

    interface Interactor extends OnRepositoryCallback{
        void addAgrupacion(Agrupacion agrupacion);
        void edit(Agrupacion agrupacion);
    }

    interface OnInteractorListener extends OnRepositoryCallback{
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
        void add(OnRepositoryCallback callback, Agrupacion a);
        void edit(OnRepositoryCallback callback, Agrupacion a);
    }
}
