package com.example.cascaron.ui.signup;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.cascaron.databinding.ActivitySignUpBinding;

import org.greenrobot.eventbus.EventBus;

public class SignUpActivity extends AppCompatActivity implements SignUpContract.View{
    ActivitySignUpBinding binding;
    private SignUpContract.Presenter presenter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding=ActivitySignUpBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        /**
         * Se utiliza el metodo OnBackPressed para eliminar la Activity SignUpActivity
         * y restaurar la actividad anterior LoginActivity
         */
        binding.btnSignUp.setOnClickListener(view -> presenter.validateSignUp(binding.tieUsuario.getText().toString(),
                binding.tieEmail.getText().toString(),
                binding.tieContrasena.getText().toString(),
                binding.tieConfirmarContrasena.getText().toString()));
        presenter = new SignUpPresenter(this);
        //EventBus.getDefault().register(this);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        //Se evitaria un futuro memory leaks
        presenter.onDestroy();
        EventBus.getDefault().unregister(this);
    }

    @Override
    public void showProgress() {

    }

    @Override
    public void hideProgress() {

    }

    @Override
    public void onSuccess(String message) {
        finish();
    }

    @Override
    public void onFailure(String message) {

    }

    @Override
    public void setEmailEmptyError() {

    }

    @Override
    public void setPasswordEmptyError() {

    }

    @Override
    public void setPasswordError() {

    }

    @Override
    public void setUserEmptyError() {

    }

    @Override
    public void setConfirmPasswordEmptyError() {

    }

    @Override
    public void setPasswordDontMatch() {

    }

    @Override
    public void setEmailError() {

    }
}