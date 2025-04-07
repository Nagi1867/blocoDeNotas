package com.course.bloco_de_notas.enums;

public enum Status {
    TERMINADO(1),
    NAO_TERMINADO(2);

    private Integer code;

    Status(Integer code) {
        this.code = code;
    }

    public Integer getCode() {
        return code;
    }

    public static Status valueOf(int code) {
        for (Status value : Status.values()) {
            if (value.getCode() == code) {
                return value;
            }
        }
        throw new IllegalArgumentException("Invalid Status code");
    }
}
