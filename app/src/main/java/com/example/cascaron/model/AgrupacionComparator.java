package com.example.cascaron.model;

import java.util.Comparator;

public class AgrupacionComparator implements Comparator {
    @Override
    public int compare(Object o, Object t1) {
        return ((Agrupacion)o).getDescripcion().compareTo(((Agrupacion) t1).getDescripcion());
    }
}
