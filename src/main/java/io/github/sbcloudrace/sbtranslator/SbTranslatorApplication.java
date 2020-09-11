package io.github.sbcloudrace.sbtranslator;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@SpringBootApplication
@EnableWebMvc
public class SbTranslatorApplication {

    public static void main(String[] args) {
        SpringApplication.run(SbTranslatorApplication.class, args);
    }

}
