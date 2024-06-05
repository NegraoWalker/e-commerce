package com.walker.ecommerce.enums;

public enum AccountStatusReceivable { //StatusContaReceber
    COBRANCA("pagar"), VENCIDA("vencida"), ABERTA("aberta"), QUITADA("quitada");

    private String description; //descrição

    AccountStatusReceivable(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }
    @Override
    public String toString() {
        return this.description;
    }
}
