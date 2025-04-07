package com.course.bloco_de_notas.services.exceptions;

public class ResourceNotFoundException extends RuntimeException {
    private static final long SerialVersionUID = 1L;

    public ResourceNotFoundException (Object id) {
        super("Resouce not found. Id: " + id);
    }
}
