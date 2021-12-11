package com.example.cascaron.model;

import androidx.annotation.Nullable;

public class Agrupacion implements Comparable{
    String foto;
    String banner;
    String nombre;
    Integer nMiembros;
    String anioCreacion;
    String director;
    String descripcion;

    public Agrupacion(String foto, String banner, String nombre, Integer nMiembros, String anioCreacion, String director, String descripcion) {
        this.foto = foto;
        this.banner = banner;
        this.nombre = nombre;
        this.nMiembros = nMiembros;
        this.anioCreacion = anioCreacion;
        this.director = director;
        this.descripcion = descripcion;
    }

    public String getFoto() {
        return foto;
    }

    public void setFoto(String foto) {
        this.foto = foto;
    }

    public String getBanner() {
        return banner;
    }

    public void setBanner(String banner) {
        this.banner = banner;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Integer getnMiembros() {
        return nMiembros;
    }

    public void setnMiembros(Integer nMiembros) {
        this.nMiembros = nMiembros;
    }

    public String getAnioCreacion() {
        return anioCreacion;
    }

    public void setAnioCreacion(String anioCreacion) {
        this.anioCreacion = anioCreacion;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
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
                ", nMiembros=" + nMiembros +
                ", anioCreacion='" + anioCreacion + '\'' +
                ", director='" + director + '\'' +
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
