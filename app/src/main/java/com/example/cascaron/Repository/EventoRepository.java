package com.example.cascaron.Repository;

import com.example.cascaron.AgrupacionDatabase;
import com.example.cascaron.model.Evento;
import com.example.cascaron.model.dao.EventoDao;
import com.example.cascaron.ui.evento.EventoListContract;
import com.example.cascaron.ui.evento.eventoManage.EventoManageContract;

import java.util.List;

public class EventoRepository implements EventoListContract.Repository, EventoManageContract.Repository {
    private static EventoRepository instance;

    static {
        instance = new EventoRepository();
    }

    private EventoDao eventoDao;
    private List<Evento> eventos;

    private EventoRepository() {
        AgrupacionDatabase agrupacionDB = AgrupacionDatabase.getDatabase();
        eventoDao = agrupacionDB.EventoDao();
    }


    public static EventoRepository getInstance() {
        if (instance == null) {
            instance = new EventoRepository();
        }
        return instance;
    }

    public void getList(EventoListContract.OnRepositoryCallback callback) {
        eventos = eventoDao.selectAll();
        if (eventos.isEmpty()) {
            callback.onNoData();
        } else {
            callback.onListSuccess(eventos);
        }
    }

    @Override
    public void add(EventoManageContract.OnRepositoryCallback callback, Evento e) {
        AgrupacionDatabase.databaseWriteExecutor.execute(() -> eventoDao.insert(e));
    }

    @Override
    public void edit(EventoManageContract.OnRepositoryCallback callback, Evento e) {
        AgrupacionDatabase.databaseWriteExecutor.execute(() -> eventoDao.update(e));
    }

    @Override
    public void delete(EventoListContract.OnRepositoryCallback callback, Evento evento) {
        AgrupacionDatabase.databaseWriteExecutor.execute(() -> eventoDao.deleteEvento(evento));
    }
}
