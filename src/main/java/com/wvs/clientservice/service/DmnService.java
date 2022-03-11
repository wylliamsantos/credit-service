package com.wvs.clientservice.service;

import lombok.AllArgsConstructor;
import org.camunda.bpm.dmn.engine.DmnDecision;
import org.camunda.bpm.dmn.engine.DmnDecisionRuleResult;
import org.camunda.bpm.dmn.engine.DmnEngine;
import org.camunda.bpm.engine.variable.VariableMap;
import org.camunda.bpm.engine.variable.Variables;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
@AllArgsConstructor
public class DmnService {

    private final DmnEngine dmnEngine;
    private final DmnDecision elegibilityDecision;

    public DmnDecisionRuleResult isElegible(final Integer age, final BigDecimal income) {
        VariableMap variables = Variables.createVariables();
        variables.put("age", age);
        variables.put("income", income);

        final var result = this.dmnEngine.evaluateDecisionTable(elegibilityDecision, variables);
        return result.getFirstResult();
    }

}
