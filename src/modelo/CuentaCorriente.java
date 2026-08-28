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
public class CuentaCorriente extends Cuenta {

    private BigDecimal limiteSobregiro;

    public CuentaCorriente(String numero, BigDecimal saldoInicial, BigDecimal limiteSobregiro) {
        super(numero, "Titular Cuenta Corriente", saldoInicial);
        this.limiteSobregiro = limiteSobregiro;
    }

    public BigDecimal getLimiteSobregiro() {
        return limiteSobregiro;
    }

    @Override
    public void debitar(BigDecimal monto) {
        BigDecimal nuevoSaldo = this.saldo.subtract(monto);
        BigDecimal limiteNegativo = this.limiteSobregiro.negate();
        if (nuevoSaldo.compareTo(limiteNegativo) < 0) {
            throw new RuntimeException(
                    "Se ha superado el límite de sobregiro permitido.");
        }
        this.saldo = nuevoSaldo;
    }
}
