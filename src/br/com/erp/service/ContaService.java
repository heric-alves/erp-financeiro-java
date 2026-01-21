package br.com.erp.service;

import br.com.erp.model.Conta;
import br.com.erp.model.TipoConta;
import br.com.erp.repository.BancoDadosFake;

public class ContaService {

    public static void cadastrarConta(int id, String nome, TipoConta tipo) {
        BancoDadosFake.contas.add(new Conta(id, nome, tipo));
        System.out.println("Conta cadastrada com sucesso!");
    }

    public static Conta buscarConta(int id) {
        return BancoDadosFake.contas.stream()
                .filter(c -> c.getId() == id)
                .findFirst()
                .orElse(null);
    }

    public static void listarContas() {
        BancoDadosFake.contas.forEach(System.out::println);
    }
}