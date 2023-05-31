package com.example.demo.rule;

import org.springframework.expression.spel.support.StandardEvaluationContext;

public class ConditionDto {
    private String name;
    private StandardEvaluationContext expression;
    private int id;
    private int next;
    private int leval;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public StandardEvaluationContext getExpression() {
        return expression;
    }

    public void setExpression(StandardEvaluationContext expression) {
        this.expression = expression;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getNext() {
        return next;
    }

    public void setNext(int next) {
        this.next = next;
    }

    public int getLeval() {
        return leval;
    }

    public void setLeval(int leval) {
        this.leval = leval;
    }

    public ConditionDto() {
    }

    public ConditionDto(String name, StandardEvaluationContext expression, int id, int next, int leval) {
        this.name = name;
        this.expression = expression;
        this.id = id;
        this.next = next;
        this.leval = leval;
    }
}
