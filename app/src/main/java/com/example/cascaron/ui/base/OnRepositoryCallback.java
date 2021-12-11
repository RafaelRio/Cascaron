package com.example.cascaron.ui.base;

/**
 * Interfaz que debe implementar toda clase que esté relacionada con la respuesta
 * del repositorio (SECUENCIA NORMAL Y FALLO) del login y el signUp
 */
public interface OnRepositoryCallback {
    void onSuccess(String message);
    void onFailure(String message);
}
