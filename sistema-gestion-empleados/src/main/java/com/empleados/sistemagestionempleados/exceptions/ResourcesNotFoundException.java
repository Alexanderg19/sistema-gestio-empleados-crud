package com.empleados.sistemagestionempleados.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class ResourcesNotFoundException extends RuntimeException {
    private static final long serialVersionID = 1L;

    public ResourcesNotFoundException(String mensaje){
        super(mensaje);
    }
}
