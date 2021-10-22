package com.example.ic206iecireol;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import com.example.ic206iecireol.controllers.AuthController;
import com.example.ic206iecireol.models.User;
import com.example.ic206iecireol.ui.DatePickerFragment;
import com.google.android.material.textfield.TextInputLayout;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;


public class RegisterActivity extends AppCompatActivity {

    private String DATE_PATTERN = "yyyy-MM-dd";
    private TextInputLayout tilBirthday, tilUserName, tilFirstName, tilLastName, tilPassword, tilheight;
    private Button btnRegister, btnLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        tilUserName = findViewById(R.id.activity_register_field_user);
        tilFirstName = findViewById(R.id.activity_register_field_first_name);
        tilLastName = findViewById(R.id.activity_register_field_last_name);
        tilPassword = findViewById(R.id.activity_register_field_password);
        tilBirthday = findViewById(R.id.activity_register_field_birth_date);
        tilheight = findViewById(R.id.activity_register_field_height);
        btnRegister = findViewById(R.id.activity_register_btn_register);
        btnLogin = findViewById(R.id.activity_register_btn_login);

        tilBirthday.getEditText().setOnClickListener(view -> {
            DatePickerFragment.showDatePickerDialog(this, tilBirthday, new Date());
        });

        btnRegister.setOnClickListener(view -> {
            String userName = tilUserName.getEditText().getText().toString();
            String firstName = tilFirstName.getEditText().getText().toString();
            String lastName = tilLastName.getEditText().getText().toString();
            String password = tilPassword.getEditText().getText().toString();
            String birthday = tilBirthday.getEditText().getText().toString();
            String height = tilheight.getEditText().getText().toString();

            SimpleDateFormat dateFormatter = new SimpleDateFormat(DATE_PATTERN);

            Date birthdayDate = null;
            try {
                birthdayDate = dateFormatter.parse(birthday);
            } catch (ParseException e) {
                e.printStackTrace();
            }

            User user = new User(userName, firstName, lastName, birthdayDate, Double.parseDouble(height));
            user.setPassword(password);

            AuthController controller = new AuthController(view.getContext());
            controller.register(user);

        });
    

        btnLogin.setOnClickListener(view -> {
            Intent i = new Intent(view.getContext(), LoginActivity.class);
            startActivity(i);
            finish();
        });

    }
}