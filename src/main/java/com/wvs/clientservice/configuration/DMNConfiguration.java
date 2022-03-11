package com.wvs.clientservice.configuration;

import org.camunda.bpm.dmn.engine.DmnDecision;
import org.camunda.bpm.dmn.engine.DmnEngine;
import org.camunda.bpm.dmn.engine.DmnEngineConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DMNConfiguration {

    @Bean
    public DmnEngine dmnEngine() {
        return DmnEngineConfiguration.createDefaultDmnEngineConfiguration().buildEngine();
    }

    @Bean
    public DmnDecision elegibilityDecision(DmnEngine dmnEngine) {
        return dmnEngine.parseDecision("Elegibility", getClass().getClassLoader().getResourceAsStream("dmn/Elegibility.dmn"));
    }

}
