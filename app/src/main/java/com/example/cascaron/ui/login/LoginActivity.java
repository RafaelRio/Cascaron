package com.example.cascaron.ui.login;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.util.Patterns;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.cascaron.MainActivity;
import com.example.cascaron.R;
import com.example.cascaron.model.Usuario;
import com.example.cascaron.ui.base.Event;
import com.example.cascaron.ui.signup.SignUpActivity;
import com.example.cascaron.databinding.ActivityLoginBinding;
import com.example.cascaron.utils.CommonUtils;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;

public class LoginActivity extends AppCompatActivity implements LoginContract.View {

    private ActivityLoginBinding binding;
    private LoginContract.Presenter presenter;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityLoginBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.btnSignUp.setOnClickListener(view -> toSignUpActivity());
        binding.btnSignIn.setOnClickListener(view -> presenter.validateCredentials(new Usuario(binding.tieUsuario.getText().toString(),binding.tieContrasena.getText().toString())));
        binding.tieUsuario.addTextChangedListener(new LoginTextWatcher(binding.tieUsuario));
        binding.tieContrasena.addTextChangedListener(new LoginTextWatcher(binding.tieContrasena));
        presenter = new LoginPresenter(this);
        EventBus.getDefault().register(this);
    }

    private void validatePassword(String password) {

        if (TextUtils.isEmpty(password)){
            binding.tilContrasena.setError(getString(R.string.errorPasswordEmpty));
        } else if (!CommonUtils.isPasswordValid(password)){
            binding.tilContrasena.setError(getString(R.string.errorPassword));
        } else{
            //desaparece el error
            binding.tilContrasena.setError(null);
        }
    }

    public void toSignUpActivity()
    {
        Intent intent = new Intent(this, SignUpActivity.class);
        startActivity(intent);
    }

    public void toMainActivity()
    {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        //Se evitaria un futuro memory leaks
        presenter.onDestroy();
        //Se quita como subcriptor del EventBus
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
        SharedPreferences.Editor editor = PreferenceManager.getDefaultSharedPreferences(this).edit();

        if (binding.ckRemember.isChecked()){
            editor.putString(Usuario.TAG,binding.tieUsuario.getText().toString());
            editor.apply();
            //O BIEN APPLY O BIEN COMMIT QUE SINO NO SE HACEN LOS CAMBIOS EN EK FICHERO

        }

        toMainActivity();
    }
    @Subscribe
    public void onEvent(Event event){
        hideProgress();
        Toast.makeText(this,event.getMessage(),Toast.LENGTH_SHORT).show();
    }


    @Override
    public void onFailure(String message) {
        Toast.makeText(this,message,Toast.LENGTH_SHORT).show();
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

    private void validateEmail(String email) {
        if (TextUtils.isEmpty(email)){
            binding.tieUsuario.setError(getString(R.string.errEmailEmpty));
        }else if (!Patterns.EMAIL_ADDRESS.matcher(email).matches()){
            binding.tieUsuario.setError(getString(R.string.errEmail));
        } else{
            //desaparece el error
            binding.tieUsuario.setError(null);
        }
    }

    class LoginTextWatcher implements TextWatcher {
        private View view;

        private LoginTextWatcher(View view){
            this.view = view;
        }

        @Override
        public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            //se deja vacio
        }

        @Override
        public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
            //se deja vacio
        }

        @Override
        public void afterTextChanged(Editable editable) {
            switch (view.getId()){
                case R.id.tieUsuario:
                    validateEmail(((EditText)view).getText().toString());
                    break;
                case R.id.tieContrasena:
                    validatePassword(((EditText)view).getText().toString());
                    break;
            }
        }
    }


}