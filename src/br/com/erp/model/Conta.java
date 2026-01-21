package br.com.erp.model;

public class Conta {

    private int id;
    private String nome;
    private TipoConta tipo;
    private double saldo;

    public Conta(int id, String nome, TipoConta tipo) {
        this.id = id;
        this.nome = nome;
        this.tipo = tipo;
        this.saldo = 0.0;
    }

    public void aplicarLancamento(TipoLancamento tipoLancamento, double valor) {
        if (tipo == TipoConta.ATIVO || tipo == TipoConta.DESPESA) {
            saldo += (tipoLancamento == TipoLancamento.DEBITO ? valor : -valor);
        } else {
            saldo += (tipoLancamento == TipoLancamento.CREDITO ? valor : -valor);
        }
    }

    public int getId() { return id; }
    public String getNome() { return nome; }
    public TipoConta getTipo() { return tipo; }
    public double getSaldo() { return saldo; }

    @Override
    public String toString() {
        return id + " - " + nome + " (" + tipo + ") | Saldo: R$ " + saldo;
    }
}