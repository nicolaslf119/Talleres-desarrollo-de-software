/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

import java.math.BigDecimal;

/**
 *
 * @author Usuario
 */
public class Cuenta {

    protected String numero;
    protected String titular;
    protected BigDecimal saldo;

    public Cuenta(String numero, String titular, BigDecimal saldoInicial) {
        this.numero = numero;
        this.titular = titular;
        this.saldo = saldoInicial;
    }

    public String getNumero() {
        return numero;
    }

    public String getTitular() {
        return titular;
    }

    public BigDecimal getSaldo() {
        return saldo;
    }

    public void depositar(BigDecimal monto) {
        this.saldo = this.saldo.add(monto);
    }

    public void debitar(BigDecimal monto) throws SaldoInsuficienteException {
        if (monto.compareTo(this.saldo) > 0) {
            throw new SaldoInsuficienteException(
                    "Saldo insuficiente para realizar el débito.");
        }
        this.saldo = this.saldo.subtract(monto);
    }
}
