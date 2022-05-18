package com.example.cascaron.ui.login;

import android.os.Handler;
import android.text.TextUtils;

import com.example.cascaron.Repository.LoginRepository;
import com.example.cascaron.Repository.LoginRepositoryStatic;
import com.example.cascaron.model.Usuario;
import com.example.cascaron.ui.base.OnRepositoryCallback;
import com.example.cascaron.utils.CommonUtils;

public class LoginInteractor implements OnRepositoryCallback {

    private LoginContract.Repository repository;
    private LoginContract.OnInteractorListener listener;

    //El presentar que quiera utilizar esta clase debe implementar esta interfaz
    public LoginInteractor(LoginContract.OnInteractorListener listener) {
        this.listener = listener;
        //this.repository = LoginRepositoryStatic.getInstance(this);
    }

    public void validateCredentials(Usuario user){
        //En base a lo que suceda avisara a su Listener//Presentador
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                // A gestionar las alternativas del caso de uso
                if (TextUtils.isEmpty(user.getEmail())){
                    listener.onEmailEmptyError();
                    return;
                }
                if (TextUtils.isEmpty(user.getContrasena())){
                    listener.onPasswordEmptyError();
                    return;
                }
                if (!CommonUtils.isPasswordValid(user.getContrasena())){
                    listener.onPasswordError();
                    return;
                }
                LoginRepository.getInstance(LoginInteractor.this).login(user);


            }
        }, 2000);
    }


    //Estos metodos vienen de la respuesta que nos da el Repositorio
    @Override
    public void onSuccess(String message) {
        listener.onSuccess(message);
    }

    @Override
    public void onFailure(String message) {
        listener.onFailure(message);
    }
}
