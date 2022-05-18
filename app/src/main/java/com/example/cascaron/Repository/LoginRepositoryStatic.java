package com.example.cascaron.Repository;

import com.example.cascaron.model.Usuario;
import com.example.cascaron.ui.base.OnRepositoryCallback;
import com.example.cascaron.ui.login.LoginContract;
import com.example.cascaron.ui.signup.SignUpContract;

import java.util.ArrayList;

public class LoginRepositoryStatic implements LoginContract.Repository, SignUpContract.Repository{
    private static LoginRepositoryStatic instance;
    private OnRepositoryCallback callback;
    private ArrayList<Usuario> users;  //usuarios autorizados en mi app

    private LoginRepositoryStatic() {
        users = new ArrayList<Usuario>();
        initialice();
    }

    /**
     * Es un metodo privado que inicializa  la estructura de datos de una clase
     */
    private void initialice() {
        users.add(new Usuario("a@gmail.com","Rafa123&&"));
        users.add(new Usuario("abc@gmail.com","Pablo123&&"));
    }


    public static LoginRepositoryStatic getInstance(OnRepositoryCallback listener) {
        if (instance == null) {
            instance = new LoginRepositoryStatic();
        }
        instance.callback = listener;
        return instance;
    }

    /**
     * Este es el metodo que comprueba si el usuario existe o no. Para ello hay que recorrer el arraylist
     * @param u
     */
    @Override
    public void login(Usuario u) {
        for(Usuario user : users){
            if (user.getEmail().equals(u.getEmail()) && user.getContrasena().equals(u.getContrasena())){
                callback.onSuccess("usuario correcto");
                return;
            }
        }
        //En caso contrario no existe
        callback.onFailure("Error en la autenticacion");
    }

    @Override
    public void SignUp(String user, String email, String password, String comfirmPassword) {
        for (Usuario u : users){
            if (u.getEmail().equals(email) && u.getContrasena().equals(password)){
                callback.onFailure("usuario ya existente");
                return;
            }else{
                users.add(new Usuario(email,password));
                callback.onSuccess("usuario creado");
                return;
            }
        }
    }



}
