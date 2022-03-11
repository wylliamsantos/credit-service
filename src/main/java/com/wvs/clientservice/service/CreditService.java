package com.wvs.clientservice.service;

import com.wvs.clientservice.dto.ElegibleDTO;
import com.wvs.clientservice.dto.SimulationDTO;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.Period;
import java.time.ZoneId;

@AllArgsConstructor
@Service
@Slf4j
public class CreditService {

    private final DmnService dmnService;

    public ElegibleDTO isElegible(SimulationDTO dto) {
        int age = Period.between(dto.getBirthDate().toInstant().atZone(ZoneId.systemDefault()).toLocalDate(), LocalDate.now()).getYears();
        var result = this.dmnService.isElegible(age, dto.getIncome());
        log.info("Result of decision table =[{}]", (Object) result.getSingleEntry());
        return new ElegibleDTO(result.getSingleEntry());
    }

}
