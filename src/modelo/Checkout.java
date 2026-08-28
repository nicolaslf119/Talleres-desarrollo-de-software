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
public class Checkout {

    public void finalizarCompra(Pedido pedido, Pago pago) {
        pago.procesar(pedido.getTotal());
        System.out.println(pago.getDescripcion());
        System.out.println("Compra finalizada para el pedido "
                + pedido.getId());
    }
}
