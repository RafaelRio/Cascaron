package com.example.cascaron.Repository;

import android.util.Log;

import androidx.annotation.NonNull;

import com.example.cascaron.model.Usuario;
import com.example.cascaron.ui.base.Event;
import com.example.cascaron.ui.base.OnRepositoryCallback;
import com.example.cascaron.ui.login.LoginContract;
import com.example.cascaron.ui.signup.SignUpContract;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

import org.greenrobot.eventbus.EventBus;

public class LoginRepository implements LoginContract.Repository, SignUpContract.Repository{
    private static final String TAG = LoginRepository.class.getName();
    private static LoginRepository instance;
    private OnRepositoryCallback callback;



    public static LoginRepository getInstance(OnRepositoryCallback listener) {
        if (instance == null) {
            instance = new LoginRepository();
        }
        instance.callback = listener;
        return instance;
    }



    @Override
    public void login(Usuario user) {
        FirebaseAuth mAuth = FirebaseAuth.getInstance();
        mAuth.signInWithEmailAndPassword(user.getEmail(), user.getContrasena())
                .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            // Sign in success, update UI with the signed-in user's information
                            Log.d(TAG, "createUserWithEmail:success");
                            callback.onSuccess("usuario correcto");

                        } else {
                            // If sign in fails, display a message to the user.
                            Log.w(TAG, "createUserWithEmail:failure", task.getException());
                            Event loginEvent = new Event();
                            loginEvent.setEventType(Event.onOnLoginError);
                            loginEvent.setMessage(task.getException().toString());

                            //Publica el evento mediante el metodo post
                            EventBus.getDefault().post(loginEvent);
                        }
                    }
                });
    }

    @Override
    public void SignUp(String user, String email, String password, String comfirmPassword) {

        FirebaseAuth mAuth = FirebaseAuth.getInstance();
        mAuth.createUserWithEmailAndPassword(email, password)
                .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            // Sign in success, update UI with the signed-in user's information
                            Log.d(TAG, "createUserWithEmail:success");
                            callback.onSuccess("usuario correcto");

                        } else {
                            // If sign in fails, display a message to the user.
                            Log.w(TAG, "createUserWithEmail:failure", task.getException());
                            Event SignUpEvent = new Event();
                            SignUpEvent.setEventType(Event.onSignUpError);
                            SignUpEvent.setMessage(task.getException().toString());

                            //Publica el evento mediante el metodo post
                            EventBus.getDefault().post(SignUpEvent);
                        }
                    }
                });
    }
}
