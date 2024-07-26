package com.walker.ecommerce.model.dto;

import java.io.Serializable;

public class DtoErrorObject implements Serializable {
    private String error;
    private String errorCode;

    public DtoErrorObject() {

    }
    public DtoErrorObject(String error, String errorCode) {
        this.error = error;
        this.errorCode = errorCode;
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }

    public String getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(String errorCode) {
        this.errorCode = errorCode;
    }
}
