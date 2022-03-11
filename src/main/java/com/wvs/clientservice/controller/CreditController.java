package com.wvs.clientservice.controller;

import com.wvs.clientservice.dto.ElegibleDTO;
import com.wvs.clientservice.dto.SimulationDTO;
import com.wvs.clientservice.service.CreditService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@Slf4j
@AllArgsConstructor
@RestController
@RequestMapping(path="/v1/credit", consumes = {MediaType.APPLICATION_JSON_VALUE}, produces = {MediaType.APPLICATION_JSON_VALUE})
public class CreditController {

    @Autowired
    private final CreditService creditService;

    @PostMapping("/eligibility")
    public ResponseEntity<ElegibleDTO> isElegible(@RequestBody @Valid SimulationDTO dto) {
        return ResponseEntity.ok(this.creditService.isElegible(dto));
    }

}
