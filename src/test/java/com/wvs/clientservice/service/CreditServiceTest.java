package com.wvs.clientservice.service;

import com.wvs.clientservice.dto.SimulationDTO;
import io.github.benas.randombeans.api.EnhancedRandom;
import org.camunda.bpm.dmn.engine.DmnDecisionRuleResult;
import org.camunda.bpm.dmn.engine.impl.DmnDecisionRuleResultImpl;
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
import java.util.Date;

import static org.junit.Assert.assertTrue;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@SpringBootTest
@RunWith(MockitoJUnitRunner.class)
public class CreditServiceTest {

    private static final DmnDecisionRuleResult dmnResult;

    @Mock
    private DmnService dmnService;

    @InjectMocks
    private CreditService creditService;

    static {
        dmnResult = EnhancedRandom.random(DmnDecisionRuleResultImpl.class);
        ((DmnDecisionRuleResultImpl) dmnResult).putValue("elegibility", new AbstractTypedValue(true, ValueType.BOOLEAN));
    }

    @Before
    public void setUp(){
        when(dmnService.isElegible(any(Integer.class), any(BigDecimal.class))).thenReturn(dmnResult);
    }

    @Test
    public void isElegibleTest() {
        Date age = new Date();
        BigDecimal income = BigDecimal.TEN;
        var request = new SimulationDTO(income, age);
        var elegible = creditService.isElegible(request);
        verify(dmnService, times(1)).isElegible(any(Integer.class), eq(income));
        assertTrue(elegible.isEligible());
    }

}
