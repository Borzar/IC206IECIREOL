package com.example.ic206iecireol;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.ic206iecireol.controllers.EvaluationController;
import com.example.ic206iecireol.models.Evaluation;

public class DetailEvaluationActivity extends AppCompatActivity {
    private TextView tvId, tvDate, tvWeight, tvImc;
    private Button btnDelete, btnBack;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_evaluation);

        Evaluation evaluation = (Evaluation) getIntent().getSerializableExtra("evaluation");

        tvId = findViewById(R.id.activity_detail_evaluation_tv_id);
        tvDate = findViewById(R.id.activity_detail_evaluation_tv_date);
        tvWeight = findViewById(R.id.activity_detail_evaluation_tv_weight);
        btnBack = findViewById(R.id.activity_detail_evaluation_btn_back);
        btnDelete = findViewById(R.id.activity_detail_evaluation_btn_delete);

        tvId.setText(Long.toString(evaluation.getId()));
        tvDate.setText(evaluation.getStringDate());
        tvWeight.setText(Double.toString(evaluation.getWeight()));


        btnDelete.setOnClickListener(view -> {
            EvaluationController controller = new EvaluationController(view.getContext());
            controller.delete(evaluation.getId());
        });

        btnBack.setOnClickListener(view -> {
            super.onBackPressed();
        });

    }




}