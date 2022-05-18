package com.example.cascaron.model;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import java.io.Serializable;

@Entity (tableName = "Agrupacion")
public class Agrupacion implements Comparable, Serializable {
    @PrimaryKey
    @NonNull
    String nombre;
    @NonNull
    String descripcion;

    public Agrupacion() {
    }

    public Agrupacion(String nombre, String descripcion) {
        this.nombre = nombre;
        this.descripcion = descripcion;
    }


    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }


    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    @Override
    public String toString() {
        return "Agrupacion{" +
                "nombre='" + nombre + '\'' +
                ", descripcion='" + descripcion + '\'' +
                '}';
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }

    @Override
    public boolean equals(@Nullable Object obj) {
        return super.equals(obj);
    }

    @Override
    public int compareTo(Object o) {
        if (((Agrupacion) o).getNombre().equals(getNombre())) {
            return ((Agrupacion) o).getDescripcion().compareTo(getDescripcion());
        } else {
            return ((Agrupacion) o).getNombre().compareTo(getNombre());
        }
    }
}
