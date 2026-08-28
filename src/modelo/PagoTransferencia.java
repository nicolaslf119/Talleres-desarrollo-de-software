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
public class PagoTransferencia implements Pago {
    private String numeroCuenta;
    private String descripcion;

    public PagoTransferencia(String numeroCuenta) {
        this.numeroCuenta = numeroCuenta;
    }

    @Override
    public void procesar(BigDecimal monto) {
        this.descripcion = "Transferencia a la cuenta " + numeroCuenta
                + " por $" + monto;
    }

    @Override
    public String getDescripcion() {
        return descripcion;
    }
}

