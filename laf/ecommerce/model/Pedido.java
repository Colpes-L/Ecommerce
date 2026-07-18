package laf.ecommerce.model;

public class Pedido {
    private int id;
    private Cliente cliente;
    private ItemPedido item;
    private StatusPedido status;

    public Pedido(){
        status = StatusPedido.ABERTO;
    }
}