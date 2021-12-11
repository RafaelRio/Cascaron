package com.example.cascaron.ui.listaAgrupacion;

import com.example.cascaron.Repository.AgrupacionRepository;
import com.example.cascaron.model.Agrupacion;
import com.example.cascaron.ui.base.OnRepositoryListCallback;

import java.util.ArrayList;
import java.util.List;

public class AgrupacionListInteractor implements OnRepositoryListCallback {

    private AgrupacionListContract.OnInteractorListener listener;

    public AgrupacionListInteractor(AgrupacionListContract.OnInteractorListener listener) {
        this.listener = listener;
    }

    @Override
    public void onFailure(String mensaje) {

    }

    @Override
    public <T> void onSuccess(List<T> list) {
        listener.onSuccess((ArrayList<Agrupacion>) list);
    }

    @Override
    public void onDeleteSuccess(String mensaje) {
        listener.onDeleteSuccess(mensaje);
    }

    @Override
    public void onUndoSuccess(String mensaje) {
        listener.onUndoSuccess(mensaje);
    }

    /**
     * Metodo que pide los datos al repositorio
     */
    public void load() {
        //SIEMPRE SE ACCEDE DE FORMA ESTATICA AL REPOSITORIO
        AgrupacionRepository.getInstance(this).getList();
    }

    /**
     * Elimina la dependencia del repositorio
     *
     * @param dependency
     */
    public void delete(Agrupacion dependency) {
        AgrupacionRepository.getInstance(this).delete(dependency);
    }

    public void undo(Agrupacion dependency) {
        AgrupacionRepository.getInstance(this).undo(dependency);
    }
}
