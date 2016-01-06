package com.drools;

import java.io.IOException;
import java.io.InputStream;

import org.drools.core.io.impl.UrlResource;
//
//import org.drools.compiler.kproject.ReleaseIdImpl;
import org.kie.api.KieServices;
import org.kie.api.builder.KieModule;
import org.kie.api.builder.KieRepository;
import org.kie.api.runtime.KieContainer;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class DroolsApplication {
    
    public static void main(String[] args) {
        SpringApplication.run(DroolsApplication.class, args);
    }

    @Bean
    public KieContainer kieContainer() throws IOException {
        final String jarUrl = "http://localhost:8080/kie-drools-wb-6.3.0.Final-wildfly8/maven2/drools-exercise/drools-proj/1.0/drools-proj-1.0.jar";
        final KieServices kieService = KieServices.Factory.get();
        final KieRepository kieRepo = kieService.getRepository();
        final UrlResource urlResource = (UrlResource) kieService.getResources().newUrlResource(jarUrl);
        urlResource.setUsername("adminadmin");
        urlResource.setPassword("pass1234");
        urlResource.setBasicAuthentication("enabled");
        final InputStream is = urlResource.getInputStream();
        final KieModule kieModule = kieRepo.addKieModule(kieService.getResources().newInputStreamResource(is));
        return kieService.newKieContainer(kieModule.getReleaseId());
    }
}
