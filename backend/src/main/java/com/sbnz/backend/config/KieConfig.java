package com.sbnz.backend.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.kie.api.KieServices;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;

@Configuration
public class KieConfig {
	
	@Bean
    public KieServices getKieServices() {
        return KieServices.Factory.get();
    }

	@Bean
    public KieContainer getKieContainer() {
        return getKieServices().getKieClasspathContainer();
    }
	
}
