package com.example.cascaron.ui.base;

import java.util.List;

public interface OnRepositoryListCallback {

    void onFailure(String mensaje);

    <T> void onSuccess(List<T> list);

    void onDeleteSuccess(String mensaje);

    void onUndoSuccess(String mensaje);
}
