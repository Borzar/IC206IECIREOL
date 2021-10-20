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

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private String DATE_PATTERN = "yyyy-MM-dd";
    private TextView tvTitle, tvClearFilter;
    private TextInputLayout tilFrom, tilTo;
    private ListView lvAllEvaluations;
    private Button btnLogout, btnNewEvaluation, btnFilter;
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
        tvClearFilter = findViewById(R.id.activity_main_tv_clear_filter);
        lvAllEvaluations = findViewById(R.id.activity_main_lv_all_evaluations);
        btnFilter = findViewById(R.id.activity_main_btn_filter);
        btnLogout = findViewById(R.id.activity_main_btn_logout);
        btnNewEvaluation = findViewById(R.id.activity_main_btn_new_evaluation);

        tilFrom.getEditText().setOnClickListener(view -> {
            DatePickerFragment.showDatePickerDialog(this, tilFrom, new Date());
        });

        tilTo.getEditText().setOnClickListener(view -> {
            DatePickerFragment.showDatePickerDialog(this, tilTo, new Date());
        });

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

        btnFilter.setOnClickListener(view -> {
            String fromStr = tilFrom.getEditText().getText().toString();
            String toStr = tilTo.getEditText().getText().toString();

            boolean validFrom = !fromStr.isEmpty();
            boolean validTo = !toStr.isEmpty();

            if (validFrom && validTo) {
                SimpleDateFormat dateFormatter = new SimpleDateFormat(DATE_PATTERN);
                try {
                    Date from = dateFormatter.parse(fromStr);
                    Date to = dateFormatter.parse(toStr);

                    List<Evaluation> evaluationRangeList = evaluationController.getRange(from, to);
                    EvaluationAdapter rangeAdapter = new EvaluationAdapter(this, evaluationRangeList);

                    lvAllEvaluations.setAdapter(rangeAdapter);

                    lvAllEvaluations.setOnItemClickListener(((adapterView, rangView, index, id) -> {
                        Evaluation evaluation = evaluationRangeList.get(index);

                        Intent i = new Intent(rangView.getContext(), DetailEvaluationActivity.class);
                        i.putExtra("evaluation", evaluation);
                        rangView.getContext().startActivity(i);
                    } ));

                } catch (ParseException e) {
                    e.printStackTrace();
                }
            }
        });

        tvClearFilter.setOnClickListener(view -> {
            tilFrom.getEditText().setText("");
            tilTo.getEditText().setText("");
            lvAllEvaluations.setAdapter(adapter);
        });
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