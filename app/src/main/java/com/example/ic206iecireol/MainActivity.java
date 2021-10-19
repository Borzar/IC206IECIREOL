package com.example.ic206iecireol;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.ic206iecireol.controllers.AuthController;
import com.example.ic206iecireol.controllers.EvaluationController;
import com.example.ic206iecireol.models.Evaluation;
import com.example.ic206iecireol.models.User;
import com.example.ic206iecireol.ui.DatePickerFragment;
import com.example.ic206iecireol.ui.EvaluationAdapter;
import com.google.android.material.textfield.TextInputLayout;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private TextView tvTitle;
    private TextInputLayout tilFrom, tilTo;
    private ListView lvAllEvaluations;
    private Button btnLogout, btnNewEvaluation;
    private AuthController authController;
    private EvaluationController evaluationController;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        authController = new AuthController(this);
        evaluationController = new EvaluationController(this);


        tvTitle = findViewById(R.id.activity_main_tv_title);
        tilFrom = findViewById(R.id.activity_main_til_from);
        tilTo = findViewById(R.id.activity_main_til_to);
        lvAllEvaluations = findViewById(R.id.activity_main_lv_all_evaluations);
        btnLogout = findViewById(R.id.activity_main_btn_logout);
        btnNewEvaluation = findViewById(R.id.activity_main_btn_new_evaluation);

        User user = authController.getUserSession();

        tvTitle.setText(String.format("Evaluacion de %s", user.getFirsName()));

        List<Evaluation> evaluationList = evaluationController.getAll();
        EvaluationAdapter adapter = new EvaluationAdapter(this, evaluationList);

        lvAllEvaluations.setAdapter(adapter);

        lvAllEvaluations.setOnItemClickListener(((adapterView, view, index, id) -> {
            Evaluation evaluation = evaluationList.get(index);

            Intent i = new Intent(view.getContext(), DetailEvaluationActivity.class);
            i.putExtra("evaluation", evaluation);
            view.getContext().startActivity(i);
        } ));

        btnNewEvaluation.setOnClickListener(view -> {
            Intent i = new Intent(view.getContext(), NewEvaluationActivity.class);
            view.getContext().startActivity(i);
        });

        btnLogout.setOnClickListener(view -> { authController.logout(); });
    }

    @Override
    protected void onResume() {
        super.onResume();
        List<Evaluation> evaluationList = evaluationController.getAll();
        EvaluationAdapter adapter = new EvaluationAdapter(this, evaluationList);

        lvAllEvaluations.setAdapter(adapter);

        lvAllEvaluations.setOnItemClickListener(((adapterView, view, index, id) -> {
            Evaluation evaluation = evaluationList.get(index);

            Intent i = new Intent(view.getContext(), DetailEvaluationActivity.class);
            i.putExtra("evaluation", evaluation);
            view.getContext().startActivity(i);
        } ));
    }
}