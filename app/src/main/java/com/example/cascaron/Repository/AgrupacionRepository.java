package com.example.cascaron.Repository;

import com.example.cascaron.model.Agrupacion;
import com.example.cascaron.ui.base.OnRepositoryListCallback;
import com.example.cascaron.ui.listaAgrupacion.AgrupacionListContract;

import java.util.ArrayList;
import java.util.Collections;

public class AgrupacionRepository implements AgrupacionListContract.Repository{

    private static AgrupacionRepository instance;
    private OnRepositoryListCallback callback;
    private ArrayList<Agrupacion> list;

    private AgrupacionRepository() {
        list = new ArrayList<>();
        initialice();
    }

    public static AgrupacionRepository getInstance(OnRepositoryListCallback callback) {
        if (instance == null) {
            instance = new AgrupacionRepository();
        }
        instance.callback = callback;
        return instance;
    }

    private void initialice() {
        list.add(new Agrupacion(null, null, "BM Cruz Humilladero", 100, "2000", "Jesus Puyana", "a"));
        list.add(new Agrupacion(null, null, "BM La Paz", 100, "1995", "2001", "d"));
        list.add(new Agrupacion(null, null, "BM Miraflores", 100, "1975", "Jose Maria Puyana", "l"));
        list.add(new Agrupacion(null, null, "BM Zamarrilla", 100, "1997", "NPI", "s"));
        list.add(new Agrupacion(null, null, "CCTT Cautivo", 100, "1997", "NPI", "r"));
        list.add(new Agrupacion(null, null, "AM San Lorenzo Martir", 100, "1997", "NPI", "y"));
        list.add(new Agrupacion(null, null, "BM (m)Pena", 100, "2005", "NPI", "f"));
        list.add(new Agrupacion(null, null, "BM Las Flores", 100, "1960", "NPI", "b"));

    }

    @Override
    public void getList() {
        callback.onSuccess(list);
        Collections.sort(list);
    }

    @Override
    public void delete(Agrupacion agrupacion) {
        list.remove(agrupacion);
        callback.onDeleteSuccess("Se ha eliminado la dependencia " + agrupacion);
    }

    @Override
    public void undo(Agrupacion agrupacion) {
        list.add(agrupacion);
        callback.onUndoSuccess("Operacion cancelada");
    }
}
