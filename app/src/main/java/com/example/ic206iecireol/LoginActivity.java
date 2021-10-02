package com.example.ic206iecireol;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.ic206iecireol.controllers.AuthController;
import com.google.android.material.textfield.TextInputLayout;

import java.util.regex.Pattern;

public class LoginActivity extends AppCompatActivity {

    private Button btnLogin, btnRegister;
    private TextInputLayout tilUser, tilPassword;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        btnLogin = findViewById(R.id.activity_login_btn_login);
        btnRegister = findViewById(R.id.activity_login_btn_register);
        tilUser = findViewById(R.id.activity_login_field_user);
        tilPassword = findViewById(R.id.activity_login_field_password);

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(view.getContext(), "Iniciando Sesión", Toast.LENGTH_SHORT).show();

                String user = tilUser.getEditText().getText().toString();
                String password = tilPassword.getEditText().getText().toString();

                boolean userValid = !user.isEmpty();
                boolean passwordValid = !password.isEmpty();

                if (!userValid) {
                     tilUser.setError("El usuario esta vacio");
                } else {
                    tilUser.setError(null);
                    tilUser.setErrorEnabled(false);
                }

                if (!passwordValid) {
                    tilPassword.setError("Campo requerido");
                } else {
                    tilPassword.setError(null);
                    tilPassword.setErrorEnabled(false);
                }

                if (userValid && passwordValid) {
                    AuthController controller = new AuthController(view.getContext());
                    controller.login(user, password);
                } else {
                    Toast.makeText(view.getContext(), "Campos inválidos", Toast.LENGTH_SHORT).show();
                }
            }
        });

        btnRegister.setOnClickListener(view -> {
            Intent i = new Intent(view.getContext(), RegisterActivity.class);
            startActivity(i);
            finish();
        });

    }
}