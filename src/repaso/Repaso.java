/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package repaso;

import java.math.BigDecimal;
import modelo.*;

/**
 *
 * @author Usuario
 */
public class Repaso {

    public static void main(String[] args) {
        // ==========================================
        // 1. CREAR UNA CUENTA
        // ==========================================
        Cuenta cuenta = new Cuenta("001", "Nicolas", new BigDecimal("100000"));
        System.out.println("Saldo inicial: $" + cuenta.getSaldo());
        // Depositar
        cuenta.depositar(new BigDecimal("50000"));
        System.out.println("Despues de depositar: $" + cuenta.getSaldo());
        
        
        // ==========================================
        // 2. DEBITAR DE UNA CUENTA
        // ==========================================
        try {
            cuenta.debitar(new BigDecimal("30000"));
            System.out.println("Despues de debitar: $" + cuenta.getSaldo());
        } catch (SaldoInsuficienteException e) {
            System.out.println(e.getMessage());
        }
        
        
        // ==========================================
        // 3. CUENTA CORRIENTE
        // ==========================================
        CuentaCorriente cuentaCorriente
                = new CuentaCorriente(
                        "002",
                        new BigDecimal("100000"),
                        new BigDecimal("50000")
                );
        System.out.println("\nCuenta corriente");
        System.out.println("Saldo inicial: $" + cuentaCorriente.getSaldo());
        // Puede quedar en negativo hasta el límite
        cuentaCorriente.debitar(new BigDecimal("120000"));
        System.out.println("Saldo despues del debito: $"
                + cuentaCorriente.getSaldo());
        
        
        // ==========================================
        // 4. POLIMORFISMO CON PAGO
        // ==========================================
        Pago pagoTarjeta = new PagoTarjeta("123456789");
        Pago pagoTransferencia
                = new PagoTransferencia("987654321");
        Pago pagoEfectivo = new PagoEfectivo();
        // Procesar los diferentes tipos de pago
        pagoTarjeta.procesar(new BigDecimal("50000"));
        System.out.println(pagoTarjeta.getDescripcion());
        pagoTransferencia.procesar(new BigDecimal("75000"));
        System.out.println(pagoTransferencia.getDescripcion());
        pagoEfectivo.procesar(new BigDecimal("30000"));
        System.out.println(pagoEfectivo.getDescripcion());
        
        
        // ==========================================
        // 5. CHECKOUT 
        // ==========================================
        Checkout checkout = new Checkout();
        /*
         * El mismo método puede recibir diferentes
         * implementaciones de Pago.
         */
        // checkout.finalizarCompra(pedido, pagoTarjeta);
        // checkout.finalizarCompra(pedido, pagoTransferencia);
        // checkout.finalizarCompra(pedido, pagoEfectivo);
    }
}
