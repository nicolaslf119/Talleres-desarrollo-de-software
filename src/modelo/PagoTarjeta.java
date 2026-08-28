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
public class PagoTarjeta implements Pago {
    private String numeroTarjeta;
    private String descripcion;

    public PagoTarjeta(String numeroTarjeta) {
        this.numeroTarjeta = numeroTarjeta;
    }

    @Override
    public void procesar(BigDecimal monto) {
        this.descripcion = "Pago con tarjeta " + numeroTarjeta
                + " por $" + monto;
    }

    @Override
    public String getDescripcion() {
        return descripcion;
    }
}
