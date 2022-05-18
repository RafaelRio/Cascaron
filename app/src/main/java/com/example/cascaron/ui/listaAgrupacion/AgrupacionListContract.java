package com.example.cascaron.ui.listaAgrupacion;

import com.example.cascaron.model.Agrupacion;
import com.example.cascaron.ui.base.BasePresenter;

import java.util.List;

public interface AgrupacionListContract {
    interface View extends OnRepositoryCallback {
        void showProgress();
        void hideProgress();
    }

    interface Presenter extends BasePresenter, OnRepositoryCallback {
        void load();
        void delete(Agrupacion agrupacion);
    }

    interface Interactor extends OnRepositoryCallback{
        void load();
        void delete(Agrupacion agrupacion);
    }

    interface Repository {
        void delete(OnRepositoryCallback callback, Agrupacion agrupacion);
    }

    interface OnRepositoryCallback {
        void onListSuccess(List<Agrupacion> agrupaciones);
        void onNoData();
    }
}
