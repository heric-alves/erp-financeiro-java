package br.com.erp.model;

import java.time.LocalDate;

public class Lancamento {

    private LocalDate data;
    private Conta conta;
    private TipoLancamento tipo;
    private double valor;
    private String descricao;

    public Lancamento(Conta conta, TipoLancamento tipo, double valor, String descricao) {
        this.data = LocalDate.now();
        this.conta = conta;
        this.tipo = tipo;
        this.valor = valor;
        this.descricao = descricao;
    }

    public Conta getConta() { return conta; }
    public TipoLancamento getTipo() { return tipo; }
    public double getValor() { return valor; }

    @Override
    public String toString() {
        return data + " | " + conta.getNome() + " | " + tipo +
               " | R$ " + valor + " | " + descricao;
    }
}