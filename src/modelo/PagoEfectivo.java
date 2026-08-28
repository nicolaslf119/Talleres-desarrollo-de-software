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
public class PagoEfectivo implements Pago {
    private String descripcion;

    public PagoEfectivo() {
    }

    @Override
    public void procesar(BigDecimal monto) {
        this.descripcion = "Pago en efectivo por $" + monto;
    }

    @Override
    public String getDescripcion() {
        return descripcion;
    }
}
