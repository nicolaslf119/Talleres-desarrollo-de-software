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
public class Pedido {

    private String id;
    private BigDecimal total;

    public Pedido(String id, BigDecimal total) {
        this.id = id;
        this.total = total;
    }

    public String getId() {
        return id;
    }

    public BigDecimal getTotal() {
        return total;
    }
}
