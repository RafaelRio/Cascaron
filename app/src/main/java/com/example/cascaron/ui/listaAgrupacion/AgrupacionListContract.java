package com.example.cascaron.ui.listaAgrupacion;

import com.example.cascaron.model.Agrupacion;
import com.example.cascaron.ui.base.BasePresenter;
import com.example.cascaron.ui.base.OnRepositoryListCallback;
import com.example.cascaron.ui.base.iProgressView;

import java.util.ArrayList;

public interface AgrupacionListContract {
    interface View extends OnRepositoryListCallback, iProgressView {
        void showData(ArrayList<Agrupacion> list);
        void showNoData();

        //Ordena de la A-Z
        void showDataOrder();

        //Ordena de la Z-A
        void showDataInverseOrder();
    }

    interface Presenter extends BasePresenter {
        //1. Cargar los datos
        void load();

        //2. Cuando se realiza una pulsacion larga se elimina
        void delete(Agrupacion agrupacion);

        //3. Cuando el usuario pulsa la opcion undo del SnackBar
        void undo(Agrupacion agrupacion);

        //4. La lista se ordena por nombre
        void order();
    }

    interface Repository {
        //1. Cargar los datos
        void getList();

        //2. Cuando se realiza una pulsacion larga se elimina
        void delete(Agrupacion agrupacion);

        //3. Cuando el usuario pulsa la opcion undo del SnackBar
        void undo(Agrupacion agrupacion);
    }

    interface OnInteractorListener extends OnRepositoryListCallback {
    }
}
