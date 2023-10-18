package com.app.demo.model.response.error;
import lombok.Getter;
import java.io.Serializable;

@Getter
public class ErrorResponse implements Serializable {
    private String message;
    private Short status;

    public ErrorResponse(String _message, Short _status) {
        this.message = _message;
        this.status = _status;
    }
}
