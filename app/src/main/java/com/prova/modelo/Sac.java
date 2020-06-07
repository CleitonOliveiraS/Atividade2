package com.prova.modelo;

public class Sac {

    private Double numeroParcela;
    private Double saldoDevedor;
    private Double amortizacao;
    private Double juros;
    private Double prestacao;

    public Sac(Double numeroParcela, Double saldoDevedor, Double amortizacao, Double juros, Double prestacao) {
        this.numeroParcela = numeroParcela;
        this.saldoDevedor = saldoDevedor;
        this.amortizacao = amortizacao;
        this.juros = juros;
        this.prestacao = prestacao;
    }

    public Double getNumeroParcela() {
        return numeroParcela;
    }

    public void setNumeroParcela(Double numeroParcela) {
        this.numeroParcela = numeroParcela;
    }

    public Double getSaldoDevedor() {
        return saldoDevedor;
    }

    public void setSaldoDevedor(Double saldoDevedor) {
        this.saldoDevedor = saldoDevedor;
    }

    public Double getAmortizacao() {
        return amortizacao;
    }

    public void setAmortizacao(Double amortizacao) {
        this.amortizacao = amortizacao;
    }

    public Double getJuros() {
        return juros;
    }

    public void setJuros(Double juros) {
        this.juros = juros;
    }

    public Double getPrestacao() {
        return prestacao;
    }

    public void setPrestacao(Double prestacao) {
        this.prestacao = prestacao;
    }
}
