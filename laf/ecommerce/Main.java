package laf.ecommerce;
import laf.ecommerce.model.*;
import laf.ecommerce.persistence.BuscaProdutoMemoria;
import laf.ecommerce.service.ServicoDeEstoque;
import laf.ecommerce.service.ServicoDePedido;

public class Main {
    public static void main(String[] args) {

        Cliente c1 = new Cliente(1, "pedro","pedro@gmail.com");
        Cliente c2 = new Cliente(2, "carlos","carlos@gmail.com");
        Cliente c3 = new Cliente(3, "joao","joao@gmail.com");


        Produto p1 = new Produto(1,"banana",4.5,10);
        Produto p2 = new Produto(2,"Picanha",40,10);
        Produto p3 = new Produto(3,"Costela",38.8,10);

        BuscaProdutoMemoria bancomemoria = new BuscaProdutoMemoria();
        bancomemoria.salvarProduto(p1);
        bancomemoria.salvarProduto(p2);
        bancomemoria.salvarProduto(p3);

        ServicoDeEstoque estoque = new ServicoDeEstoque(bancomemoria);

        ItemPedido item1 = new ItemPedido(p1,3);
        ItemPedido item2 = new ItemPedido(p2,3);
        ItemPedido item3 = new ItemPedido(p3,3);
        ItemPedido item4 = new ItemPedido(p1,9);

        ServicoDePedido servicoDePedido = new ServicoDePedido(estoque);

        Pedido pedido1 = servicoDePedido.criarPedido(item1,c1);
        servicoDePedido.adicionaItemAoPedido(item2,pedido1);
        servicoDePedido.mudaStatusPedido(pedido1, StatusPedido.CONFIRMADO);
        servicoDePedido.retiraProdutoDoPedidoDeEstoque(pedido1);

        Pedido pedido2 = servicoDePedido.criarPedido(item3,c2);
        Pedido pedido3 = servicoDePedido.criarPedido(item4,c3);


        servicoDePedido.adicionaItemAoPedido(item3,pedido2);

        for(ItemPedido p : pedido1.getItensPedidos()){
            System.out.println(p.getProduto().getNome() + p.getProduto().getQuantidadeProdutoEstoque());
            System.out.println(estoque.getProdutoQuantidadeEmEstoque(p.getProduto().getId()));
        }
        for(ItemPedido p : pedido2.getItensPedidos()){
            System.out.println(p.getProduto().getNome() + p.getProduto().getQuantidadeProdutoEstoque());
            System.out.println(estoque.getProdutoQuantidadeEmEstoque(p.getProduto().getId()));
        }

    }
}
