package com.wvs.clientservice.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class SimulationDTO implements Serializable {

    @NotNull
    private BigDecimal income;
    @NotNull
    private Date birthDate;

}
