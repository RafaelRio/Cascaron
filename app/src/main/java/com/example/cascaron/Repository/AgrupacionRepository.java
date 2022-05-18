package com.example.cascaron.Repository;

import com.example.cascaron.AgrupacionDatabase;
import com.example.cascaron.model.Agrupacion;
import com.example.cascaron.model.dao.AgrupacionDao;
import com.example.cascaron.ui.listaAgrupacion.AgrupacionListContract;
import com.example.cascaron.ui.listaAgrupacion.ManageAgrupacion.AgrupacionManageContract;

import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class AgrupacionRepository implements AgrupacionListContract.Repository, AgrupacionManageContract.Repository {

    private static AgrupacionRepository instance;

    static {
        instance = new AgrupacionRepository();
    }

    private AgrupacionDao agrupacionDao;
    private List<Agrupacion> agrupaciones;

    private AgrupacionRepository() {
        AgrupacionDatabase agrupacionDB = AgrupacionDatabase.getDatabase();
        agrupacionDao = agrupacionDB.AgrupacionDao();
    }


    public static AgrupacionRepository getInstance() {
        if (instance == null) {
            instance = new AgrupacionRepository();
        }
        return instance;
    }

    public void getList(AgrupacionListContract.OnRepositoryCallback callback) {
        agrupaciones = agrupacionDao.selectAll();
        if (agrupaciones.isEmpty()) {
            callback.onNoData();
        } else {
            callback.onListSuccess(agrupaciones);
        }
    }

    @Override
    public void add(AgrupacionManageContract.OnRepositoryCallback callback, Agrupacion a) {
        AgrupacionDatabase.databaseWriteExecutor.execute(() -> agrupacionDao.insert(a));
    }

    @Override
    public void edit(AgrupacionManageContract.OnRepositoryCallback callback, Agrupacion a) {
        AgrupacionDatabase.databaseWriteExecutor.execute(() -> agrupacionDao.update(a));
    }


    @Override
    public void delete(AgrupacionListContract.OnRepositoryCallback callback, Agrupacion agrupacion) {
        AgrupacionDatabase.databaseWriteExecutor.execute(() -> agrupacionDao.deleteTask(agrupacion));
    }
}
