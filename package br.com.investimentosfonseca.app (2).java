package br.com.investimentosfonseca.service;

import br.com.investimentosfonseca.model.Cliente;
import br.com.investimentosfonseca.model.Conta;

import java.util.ArrayList;
import java.util.List;

public class GerenciadorDeContas {
    private List<Conta> contas = new ArrayList<>();

    public Conta criarConta(String nome, String cpf, String email) {
        Cliente cliente = new Cliente(nome, cpf, email);
        Conta conta = new Conta(cliente);
        contas.add(conta);
        return conta;
    }

    public Conta buscarConta(int numero) {
        return contas.stream()
                .filter(conta -> conta.getNumero() == numero)
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("Conta não encontrada."));
    }

    public List<Conta> listarContas() {
        return new ArrayList<>(contas);
    }
}
