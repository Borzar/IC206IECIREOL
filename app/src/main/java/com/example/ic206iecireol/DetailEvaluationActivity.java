package com.example.ic206iecireol;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.ic206iecireol.models.Evaluation;

public class DetailEvaluationActivity extends AppCompatActivity {
    private TextView tvId, tvDate, tvWeight, tvImc;
    private Button btnDelete;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_evaluation);

        Evaluation evaluation = (Evaluation) getIntent().getSerializableExtra("evaluation");

        tvId = findViewById(R.id.activity_detail_evaluation_tv_id);

        tvId.setText(Long.toString(evaluation.getId()));

    }




}