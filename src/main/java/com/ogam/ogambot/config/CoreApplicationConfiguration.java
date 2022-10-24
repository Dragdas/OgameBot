package com.ogam.ogambot.config;

import lombok.Getter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

@Configuration
@Getter
public class CoreApplicationConfiguration {

    @Value("${ogame.username}")
    private String username;

    @Value("${ogame.password}")
    private String password;

}
