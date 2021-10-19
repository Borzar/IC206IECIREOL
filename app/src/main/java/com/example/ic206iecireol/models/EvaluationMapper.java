package com.example.ic206iecireol.models;

public class EvaluationMapper {
    private IEvaluation evaluation;

    public EvaluationMapper(IEvaluation evaluation) {
        this.evaluation = evaluation;
    }

    public Evaluation toBase() {
        Evaluation baseEvaluation = new Evaluation(
                this.evaluation.getId(),
                this.evaluation.getDate(),
                this.evaluation.getWeight()
        );
        baseEvaluation.setId(this.evaluation.getId());
        return baseEvaluation;
    }

    public EvaluationEntity toEntity() {
        return new EvaluationEntity(
                this.evaluation.getId(),
                this.evaluation.getDate(),
                this.evaluation.getWeight()
        );
    }
}
