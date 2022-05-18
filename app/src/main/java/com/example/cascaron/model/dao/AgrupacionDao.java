package com.example.cascaron.model.dao;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.example.cascaron.model.Agrupacion;

import java.util.List;

@Dao
public interface AgrupacionDao {
    @Insert
    long insert(Agrupacion a);

    @Update
    void update(Agrupacion a);

    @Query("SELECT * FROM Agrupacion")
    List<Agrupacion> selectAll();

    @Query("DELETE FROM Agrupacion")
    void deleteAll();

    @Query("SELECT * FROM Agrupacion where nombre=:nombre")
    Agrupacion findByName(String nombre);

    @Query("SELECT * FROM Agrupacion ORDER BY nombre ASC")
    List<Agrupacion> getAlphabetizeAgrupacion();

    @Delete
    void deleteTask(Agrupacion task);
}
