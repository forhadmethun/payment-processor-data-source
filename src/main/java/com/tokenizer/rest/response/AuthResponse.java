package com.tokenizer.rest.response;

public class AuthResponse {
    private boolean success;
    private String transactionId;

    public boolean isSuccess() {
        return success;
    }

    public AuthResponse setSuccess(boolean success) {
        this.success = success;
        return this;
    }

    public String getTransactionId() {
        return transactionId;
    }

    public AuthResponse setTransactionId(String transactionId) {
        this.transactionId = transactionId;
        return this;
    }
}
