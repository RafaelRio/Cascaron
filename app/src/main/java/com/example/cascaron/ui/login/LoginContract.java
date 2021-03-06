package com.example.cascaron.ui.login;


import com.example.cascaron.model.Usuario;
import com.example.cascaron.ui.base.BasePresenter;
import com.example.cascaron.ui.base.IProgressView;
import com.example.cascaron.ui.base.OnRepositoryCallback;

/**
 * Esta interfaz es el contrato entre la vista y el presentador de Login
 */
public interface LoginContract {
    /**
     * Interfaz que debe implementar la vista
     */
    interface View extends OnRepositoryCallback, IProgressView {
        //Alternativas del caso de uso ,,set porque se modifica elementos de la vista
        void setEmailEmptyError();
        void setPasswordEmptyError();
        void setPasswordError();
    }

    /**
     * Interfaz que debe implementar el presenter
     */
    interface Presenter extends BasePresenter {
        void validateCredentials(Usuario user);
    }

    /**
     * Toda clase que quiera ser un repositorio para login
     */
    interface Repository {
        void login(Usuario user);
    }

    /**
     * Interfaz que debe implementar el listener de interactor
     * esta interfaz es las posibles alternativas del caso de uso de LOGIN
     */
    interface OnInteractorListener extends OnRepositoryCallback {
        //Alternativa del caso de uso
        void onEmailEmptyError();
        void onPasswordEmptyError();
        void onPasswordError();
    }


}
