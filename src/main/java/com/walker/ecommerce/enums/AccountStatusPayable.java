package com.walker.ecommerce.enums;

public enum AccountStatusPayable { //StatusContaPagar
    COBRANCA("pagar"),
    VENCIDA("vencida"),
    ABERTA("aberta"),
    QUITADA("quitada"),
    RENEGOCIADA("renegociada");

    private String description; //descrição

    AccountStatusPayable(String description) {
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
