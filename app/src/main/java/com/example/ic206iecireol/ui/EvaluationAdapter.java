package com.example.ic206iecireol.ui;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.List;

import com.example.ic206iecireol.R;
import com.example.ic206iecireol.controllers.AuthController;
import com.example.ic206iecireol.models.Evaluation;
import com.example.ic206iecireol.models.User;

import java.util.List;

public class EvaluationAdapter extends BaseAdapter {
    private Context ctx;
    private List<Evaluation> evaluationList;

    public EvaluationAdapter(Context ctx, List<Evaluation> evaluationList) {
        this.ctx = ctx;
        this.evaluationList = evaluationList;
    }

    @Override
    public int getCount() {
        return evaluationList.size();
    }

    @Override
    public Object getItem(int i) {
        return evaluationList.get(i);
    }

    @Override
    public long getItemId(int i) {
        return evaluationList.get(i).getId();
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        LayoutInflater inflater = LayoutInflater.from(ctx);

        view = inflater.inflate(R.layout.item_evaluation, null);

        AuthController authController = new AuthController(view.getContext());
        User user = authController.getUserSession();

        Evaluation evaluation = evaluationList.get(i);

        TextView tvId= view.findViewById(R.id.item_evaluation_tv_id);
        TextView tvWeight= view.findViewById(R.id.item_evaluation_tv_weight);
        TextView tvDate= view.findViewById(R.id.item_evaluation_tv_date);
        TextView tvImc = view.findViewById(R.id.item_evaluation_tv_imc);

        tvId.setText(Long.toString(evaluation.getId()));
        tvWeight.setText(Double.toString(evaluation.getWeight()));
        tvImc.setText(evaluation.calculateImcString(user.getHeight()));
        tvDate.setText(String.format("Fecha Evaluacion: %s", evaluation.getStringDate()));

        return view;
    }
}
