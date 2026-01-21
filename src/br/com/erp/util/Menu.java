package br.com.erp.util;

import java.util.Scanner;

import br.com.erp.model.*;
import br.com.erp.service.*;

public class Menu {

    private static Scanner sc = new Scanner(System.in);

    public static void exibir() {
        int opcao;
        do {
            System.out.println("\n=== ERP FINANCEIRO ===");
            System.out.println("1 - Cadastrar conta");
            System.out.println("2 - Listar contas");
            System.out.println("3 - Lançar débito/crédito");
            System.out.println("4 - Listar lançamentos");
            System.out.println("0 - Sair");
            System.out.print("Opção: ");
            opcao = sc.nextInt();
            sc.nextLine();

            switch (opcao) {
                case 1 -> cadastrarConta();
                case 2 -> ContaService.listarContas();
                case 3 -> lançar();
                case 4 -> LancamentoService.listarLancamentos();
            }
        } while (opcao != 0);
    }

    private static void cadastrarConta() {
        System.out.print("ID: ");
        int id = sc.nextInt();
        sc.nextLine();

        System.out.print("Nome: ");
        String nome = sc.nextLine();

        System.out.print("Tipo (ATIVO, PASSIVO, RECEITA, DESPESA): ");
        TipoConta tipo = TipoConta.valueOf(sc.nextLine().toUpperCase());

        ContaService.cadastrarConta(id, nome, tipo);
    }

    private static void lançar() {
        System.out.print("ID da conta: ");
        int id = sc.nextInt();
        sc.nextLine();

        Conta conta = ContaService.buscarConta(id);
        if (conta == null) {
            System.out.println("Conta não encontrada.");
            return;
        }

        System.out.print("Tipo (DEBITO ou CREDITO): ");
        TipoLancamento tipo = TipoLancamento.valueOf(sc.nextLine().toUpperCase());

        System.out.print("Valor: ");
        double valor = sc.nextDouble();
        sc.nextLine();

        System.out.print("Descrição: ");
        String desc = sc.nextLine();

        LancamentoService.lançar(conta, tipo, valor, desc);
    }
}