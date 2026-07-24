package laf.ecommerce.model;

import java.util.ArrayList;
import java.util.List;

public class Pedido {
    private int id;
    private Cliente cliente;
    private List<ItemPedido> itensPedidos = new ArrayList<>();
    private StatusPedido status;

    public Pedido(int id, Cliente cliente){
        this.id = id;
        this.cliente = cliente;
        status = StatusPedido.ABERTO;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public List<ItemPedido> getItensPedidos() {
        return List.copyOf(itensPedidos);
    }

    public void adicionaProduto(Produto produto,int quantidade) {
        ItemPedido item = new ItemPedido(produto, quantidade);
        this.itensPedidos.add(item);
    }

    public StatusPedido getStatus() {
        return status;
    }

    public void setStatus(StatusPedido status) {
        this.status = status;
    }
}