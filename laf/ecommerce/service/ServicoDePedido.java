package laf.ecommerce.service;
import laf.ecommerce.model.*;
import laf.ecommerce.repositorio.BuscaProduto;
import laf.ecommerce.service.ServicoDeEstoque;

import java.util.ArrayList;
import java.util.List;

public class ServicoDePedido {

    private ServicoDeEstoque servicoDeEstoque;
    private static int quantidadePedidos = 0;
    private List<Pedido> pedidos = new ArrayList<>();

    public ServicoDePedido(ServicoDeEstoque servico){
        this.servicoDeEstoque = servico;
    }

    public Pedido criarPedido(ItemPedido item, Cliente cliente){
            if(item != null){
                Produto produto = new Produto(item.getProduto());

                if(item.getQuantidade() == 0)
                    return null;

                if(item.getQuantidade() <= servicoDeEstoque.getProdutoQuantidadeEmEstoque(produto.getId())){
                    Pedido pedido = new Pedido(quantidadePedidos+1,cliente);
                    pedido.adicionaProduto(item.getProduto(), item.getQuantidade());
                    pedidos.add(pedido);

                    return pedido;
                }else {
                    System.out.println("Quantidade Indisponivel no Estoque");
                }

            }
            System.out.println("item inexistente");
            return null;

    }
    public void adicionaItemAoPedido(ItemPedido item,Pedido pedido){

        if(item != null && pedido != null){

            Produto produto = new Produto(item.getProduto());

            if(item.getQuantidade() == 0)
                return;

            if(item.getQuantidade() <= servicoDeEstoque.getProdutoQuantidadeEmEstoque(produto.getId())){
                pedido.adicionaProduto(item.getProduto(), item.getQuantidade());
                pedidos.add(pedido);
            }

        }

    }
    public void removeItemDoPedido(ItemPedido item,int idDoPedido){
        Pedido pedido = buscarPedido(idDoPedido);
        if(item != null && pedido != null){

            Produto produto = new Produto(item.getProduto());
            pedidos.remove(pedido);

        }
    }
    public void cancelaPedido(Pedido pedido){
    }
    public void mudaStatusPedido(Pedido pedido, StatusPedido status){
        pedido.setStatus(status);
    }

    public void retiraProdutoDoPedidoDeEstoque(Pedido pedido){
        if(pedido.getStatus() == StatusPedido.CONFIRMADO){
            List<ItemPedido> itens = pedido.getItensPedidos();
            servicoDeEstoque.atualizaQuantidadeEmEstoque(itens);
        }else{
            System.out.println("Pedido não esta em situação confirmado para continuar a operação");
        }
    }

    public Pedido buscarPedido(int idDoPedido){
        for (Pedido p : pedidos){
            if(p.getId() == idDoPedido)
                return p;
        }
        return null;
    }

}

