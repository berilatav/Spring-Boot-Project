package com.demo.readingisgood.configuration;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public class RestApiException extends RuntimeException{

    private final EnumMessages errorCode;

    public RestApiException(EnumMessages errorCode) {
        super();
        this.errorCode = errorCode;
    }
}
