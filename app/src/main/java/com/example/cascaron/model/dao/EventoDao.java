package com.example.cascaron.model.dao;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.example.cascaron.model.Evento;

import java.util.List;

@Dao
public interface EventoDao {
    @Insert
    long insert(Evento e);

    @Update
    void update(Evento e);

    @Query("SELECT * FROM Evento")
    List<Evento> selectAll();

    @Query("DELETE FROM Evento")
    void deleteAll();

    @Query("SELECT * FROM Evento where nombre=:nombre")
    Evento findByName(String nombre);

    @Query("SELECT * FROM Evento ORDER BY nombre ASC")
    List<Evento> getAlphabetizeEvento();

    @Delete
    void deleteEvento(Evento e);
}
