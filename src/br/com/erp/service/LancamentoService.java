package br.com.erp.service;

import br.com.erp.model.Lancamento;
import br.com.erp.model.TipoLancamento;
import br.com.erp.repository.BancoDadosFake;
import br.com.erp.model.Conta;

public class LancamentoService {

    public static void lançar(Conta conta, TipoLancamento tipo, double valor, String descricao) {
        conta.aplicarLancamento(tipo, valor);
        BancoDadosFake.lancamentos.add(new Lancamento(conta, tipo, valor, descricao));
        System.out.println("Lançamento realizado com sucesso!");
    }

    public static void listarLancamentos() {
        BancoDadosFake.lancamentos.forEach(System.out::println);
    }
}