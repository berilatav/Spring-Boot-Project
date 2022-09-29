package com.demo.readingisgood.configuration.properties;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Getter
@Setter
@Component
@ConfigurationProperties(prefix = "general.cache")
public class GeneralProperties {

    private Long denemeCountsInSeconds;
}