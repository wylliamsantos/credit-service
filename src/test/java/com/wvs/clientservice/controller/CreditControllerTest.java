package com.wvs.clientservice.controller;

import com.wvs.clientservice.dto.ElegibleDTO;
import com.wvs.clientservice.dto.SimulationDTO;
import com.wvs.clientservice.service.CreditService;
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
public class CreditControllerTest {

    private static final ElegibleDTO mockReturn;

    @Mock
    private CreditService creditService;

    @InjectMocks
    private CreditController creditController;

    static {
        mockReturn = new ElegibleDTO(true);
    }

    @Before
    public void setUp(){
        when(creditService.isElegible(any(SimulationDTO.class))).thenReturn(mockReturn);
    }

    @Test
    public void isElegibleTest() {
        var request = new SimulationDTO(BigDecimal.TEN, new Date());
        var elegible = creditController.isElegible(request);
        verify(creditService, times(1)).isElegible(request);
        assertTrue(elegible.getBody().isEligible());
    }

}
