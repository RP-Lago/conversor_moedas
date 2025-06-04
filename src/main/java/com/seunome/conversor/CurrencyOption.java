package com.seunome.conversor;
public enum CurrencyOption {
    USD_BRL("Dólar (USD) para Real (BRL)"),
    BRL_USD("Real (BRL) para Dólar (USD)"),
    EUR_BRL("Euro (EUR) para Real (BRL)"),
    BRL_EUR("Real (BRL) para Euro (EUR)"),
    GBP_BRL("Libra Esterlina (GBP) para Real (BRL)"),
    BRL_GBP("Real (BRL) para Libra Esterlina (GBP)");

    private final String description;

    CurrencyOption(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

    public String getBaseCurrency() {
        return this.name().substring(0, 3);
    }

    public String getTargetCurrency() {
        return this.name().substring(4, 7);
    }
}