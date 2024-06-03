package com.walker.ecommerce.enums;

public enum AddressType { //TipoEndereco
    COBRANCA("cobrança"), ENTREGA("entrega");

    private String description;

    AddressType(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

    @Override
    public String toString() {
        return "addressType{" +
                "description='" + description + '\'' +
                '}';
    }
}
