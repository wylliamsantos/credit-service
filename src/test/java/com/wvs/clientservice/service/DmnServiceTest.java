package com.wvs.clientservice.service;

import org.camunda.bpm.dmn.engine.DmnDecision;
import org.camunda.bpm.dmn.engine.DmnDecisionRuleResult;
import org.camunda.bpm.dmn.engine.DmnEngine;
import org.camunda.bpm.dmn.engine.impl.DmnDecisionRuleResultImpl;
import org.camunda.bpm.dmn.engine.impl.DmnDecisionTableResultImpl;
import org.camunda.bpm.engine.variable.VariableMap;
import org.camunda.bpm.engine.variable.impl.value.AbstractTypedValue;
import org.camunda.bpm.engine.variable.type.ValueType;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertTrue;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@SpringBootTest
@RunWith(MockitoJUnitRunner.class)
public class DmnServiceTest {

    private static final DmnDecisionTableResultImpl DMN_RESULT;
    private static final Integer AGE = 30;
    private static final BigDecimal INCOME = BigDecimal.TEN;

    @Mock
    private DmnEngine dmnEngine;

    @InjectMocks
    private DmnService dmnService;

    static {
        var rule = new DmnDecisionRuleResultImpl();
        rule.putValue("elegibility", new AbstractTypedValue(true, ValueType.BOOLEAN));
        DMN_RESULT = new DmnDecisionTableResultImpl(List.of(rule));
    }

    @Before
    public void setUp() {
        when(this.dmnEngine.evaluateDecisionTable(any(), any(VariableMap.class))).thenReturn(DMN_RESULT);
    }

    @Test
    public void isElegibleTest() {
        var elegible = dmnService.isElegible(AGE, INCOME);
        verify(dmnEngine, times(1)).evaluateDecisionTable(any(), any(VariableMap.class));
        assertTrue(elegible.getSingleEntry());
    }

}
