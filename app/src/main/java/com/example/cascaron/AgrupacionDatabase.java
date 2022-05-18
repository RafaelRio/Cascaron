package com.example.cascaron;

import android.content.Context;

import androidx.annotation.NonNull;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.sqlite.db.SupportSQLiteDatabase;

import com.example.cascaron.model.Agrupacion;
import com.example.cascaron.model.Evento;
import com.example.cascaron.model.dao.AgrupacionDao;
import com.example.cascaron.model.dao.EventoDao;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Database(entities = {Agrupacion.class, Evento.class}, version = 2, exportSchema = false)
public abstract class AgrupacionDatabase extends RoomDatabase{
    private static volatile AgrupacionDatabase INSTANCE;
    private static final int NUMBER_OF_THREADS = 4;
    public static final ExecutorService databaseWriteExecutor =
            Executors.newFixedThreadPool(NUMBER_OF_THREADS);

    //Crear el metodo de obtencion de los DAO
    public abstract AgrupacionDao AgrupacionDao();
    public abstract EventoDao EventoDao();


    //Esta version es de google
    private static AgrupacionDatabase getDatabase(final Context context) {
        if (INSTANCE == null) {
            synchronized (AgrupacionDatabase.class) {
                if (INSTANCE == null) {
                    INSTANCE = Room.databaseBuilder(context.getApplicationContext(),
                            AgrupacionDatabase.class, "agrupacion")
                            .fallbackToDestructiveMigration()
                            .build();
                }
            }
        }
        return INSTANCE;
    }


    public static void create(final Context context) {
        if (INSTANCE == null) {
            synchronized (AgrupacionDatabase.class) {
                if (INSTANCE == null) {
                    INSTANCE = Room.databaseBuilder(context.getApplicationContext(),
                            AgrupacionDatabase.class, "agrupacion")
                            .addCallback(new Callback() {
                                @Override
                                public void onCreate(@NonNull SupportSQLiteDatabase db) {
                                    super.onCreate(db);
                                    //databaseWriteExecutor.execute(() -> prepopulate(context));
                                }
                            })
                            .fallbackToDestructiveMigration()
                            .allowMainThreadQueries()
                            .build();
                }
            }
        }
    }

    public static AgrupacionDatabase getDatabase() {
        return INSTANCE;
    }
}
