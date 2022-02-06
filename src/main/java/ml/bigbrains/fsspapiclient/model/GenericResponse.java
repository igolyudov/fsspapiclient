package ml.bigbrains.fsspapiclient.model;

import lombok.Data;

@Data
public class GenericResponse<T> {
    private String status;
    private Integer code;
    private String exception;
    private T response;
}
