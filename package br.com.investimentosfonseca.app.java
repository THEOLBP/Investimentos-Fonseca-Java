package br.com.investimentosfonseca.app;

import br.com.investimentosfonseca.service.GerenciadorDeContas;
import br.com.investimentosfonseca.model.Conta;

import java.util.Scanner;

public class Aplicacao {
    public static void main(String[] args) {
        GerenciadorDeContas gerenciador = new GerenciadorDeContas();
        Scanner scanner = new Scanner(System.in);

        System.out.println("Bem-vindo ao sistema da Investimentos Fonseca!");

        boolean rodando = true;

        while (rodando) {
            System.out.println("\nMenu:");
            System.out.println("1. Criar Conta");
            System.out.println("2. Listar Contas");
            System.out.println("3. Realizar Depósito");
            System.out.println("4. Realizar Saque");
            System.out.println("5. Aplicar Rendimento");
            System.out.println("6. Sair");
            System.out.print("Escolha uma opção: ");

            int opcao = scanner.nextInt();
            scanner.nextLine(); // Consumir quebra de linha

            try {
                switch (opcao) {
                    case 1:
                        System.out.print("Nome do cliente: ");
                        String nome = scanner.nextLine();
                        System.out.print("CPF do cliente: ");
                        String cpf = scanner.nextLine();
                        System.out.print("Email do cliente: ");
                        String email = scanner.nextLine();

                        Conta novaConta = gerenciador.criarConta(nome, cpf, email);
                        System.out.println("Conta criada com sucesso! Número: " + novaConta.getNumero());
                        break;

                    case 2:
                        System.out.println("Lista de contas:");
                        gerenciador.listarContas().forEach(System.out::println);
                        break;

                    case 3:
                        System.out.print("Número da conta: ");
                        int numeroDeposito = scanner.nextInt();
                        System.out.print("Valor do depósito: ");
                        double valorDeposito = scanner.nextDouble();

                        Conta contaDeposito = gerenciador.buscarConta(numeroDeposito);
                        contaDeposito.depositar(valorDeposito);
                        System.out.println("Depósito realizado com sucesso.");
                        break;

                    case 4:
                        System.out.print("Número da conta: ");
                        int numeroSaque = scanner.nextInt();
                        System.out.print("Valor do saque: ");
                        double valorSaque = scanner.nextDouble();

                        Conta contaSaque = gerenciador.buscarConta(numeroSaque);
                        contaSaque.sacar(valorSaque);
                        System.out.println("Saque realizado com sucesso.");
                        break;

                    case 5:
                        System.out.print("Número da conta: ");
                        int numeroRendimento = scanner.nextInt();
                        System.out.print("Taxa de rendimento (%): ");
                        double taxa = scanner.nextDouble();

                        Conta contaRendimento = gerenciador.buscarConta(numeroRendimento);
                        contaRendimento.aplicarRendimento(taxa);
                        System.out.println("Rendimento aplicado com sucesso.");
                        break;

                    case 6:
                        rodando = false;
                        System.out.println("Encerrando o sistema. Até logo!");
                        break;

                    default:
                        System.out.println("Opção inválida. Tente novamente.");
                }
            } catch (Exception e) {
                System.out.println("Erro: " + e.getMessage());
            }
        }

        scanner.close();
    }
}
