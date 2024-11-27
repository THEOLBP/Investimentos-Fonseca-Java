package br.com.investimentosfonseca.model;

public class Conta {
    private static int contadorContas = 1;

    private int numero;
    private Cliente cliente;
    private double saldo;

    public Conta(Cliente cliente) {
        this.numero = contadorContas++;
        this.cliente = cliente;
        this.saldo = 0.0;
    }

    public int getNumero() {
        return numero;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public double getSaldo() {
        return saldo;
    }

    public void depositar(double valor) {
        if (valor > 0) {
            saldo += valor;
        } else {
            throw new IllegalArgumentException("Valor de depósito deve ser positivo.");
        }
    }

    public void sacar(double valor) {
        if (valor > 0 && saldo >= valor) {
            saldo -= valor;
        } else {
            throw new IllegalArgumentException("Saldo insuficiente ou valor inválido.");
        }
    }

    public void aplicarRendimento(double percentual) {
        if (percentual > 0) {
            saldo += saldo * (percentual / 100);
        } else {
            throw new IllegalArgumentException("Percentual de rendimento deve ser positivo.");
        }
    }

    @Override
    public String toString() {
        return String.format("Conta: %d | Cliente: %s | Saldo: R$ %.2f", numero, cliente.getNome(), saldo);
    }
}
