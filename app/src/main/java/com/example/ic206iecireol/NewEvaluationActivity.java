package com.example.ic206iecireol;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.ic206iecireol.controllers.AuthController;
import com.example.ic206iecireol.controllers.EvaluationController;
import com.example.ic206iecireol.models.Evaluation;
import com.example.ic206iecireol.models.User;
import com.example.ic206iecireol.ui.DatePickerFragment;
import com.google.android.material.textfield.TextInputLayout;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class NewEvaluationActivity extends AppCompatActivity {
    private String DATE_PATTERN = "yyyy-MM-dd";
    private TextInputLayout tilWeight, tilDate;
    private Button btnRegister, btnBack;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_evaluation);

        tilWeight = findViewById(R.id.activity_new_evaluation_field_weight);
        tilDate = findViewById(R.id.activity_new_evaluation_field_date);
        btnRegister = findViewById(R.id.activity_new_evaluation_btn_register);
        btnBack = findViewById(R.id.activity_new_evaluation_btn_back);

        tilDate.getEditText().setOnClickListener(view -> {
            DatePickerFragment.showDatePickerDialog(this, tilDate, new Date());
        });

        btnRegister.setOnClickListener(view -> {
            String weight = tilWeight.getEditText().getText().toString();
            String date = tilDate.getEditText().getText().toString();

            //TODO: VALIDACIONES!

            SimpleDateFormat dateFormatter = new SimpleDateFormat(DATE_PATTERN);

            Date evDate = null;
            try {
                evDate = dateFormatter.parse(date);
            } catch (ParseException e) {
                e.printStackTrace();
            }

            AuthController authController = new AuthController(view.getContext());

            User user = authController.getUserSession();

            Evaluation evaluation = new Evaluation(evDate, Double.parseDouble(weight), user.getId());

            EvaluationController controller = new EvaluationController(view.getContext());
            controller.register(evaluation);

            Toast.makeText(view.getContext(), "Registrar", Toast.LENGTH_SHORT).show();
        });

        btnBack.setOnClickListener(view -> {
            super.onBackPressed();
        });

    }
}