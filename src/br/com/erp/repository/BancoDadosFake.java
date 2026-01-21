package br.com.erp.repository;

import java.util.ArrayList;
import java.util.List;

import br.com.erp.model.Conta;
import br.com.erp.model.Lancamento;

public class BancoDadosFake {

    public static List<Conta> contas = new ArrayList<>();
    public static List<Lancamento> lancamentos = new ArrayList<>();
}