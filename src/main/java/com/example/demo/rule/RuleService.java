package com.example.demo.rule;

public interface RuleService<I, O> {
    O evaluate(I input, ICondition conditions);
}
