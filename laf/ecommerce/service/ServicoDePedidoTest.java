package laf.ecommerce.service;

import org.junit.jupiter.api.Test;
import laf.ecommerce.model.*;
import laf.ecommerce.persistence.BuscaProdutoMemoria;
import laf.ecommerce.exceptions.EstoqueInsuficienteException;
import org.junit.jupiter.api.BeforeEach;
import static org.junit.jupiter.api.Assertions.*;

class ServicoDePedidoTest {

    private ServicoDePedido servicoDePedido;
    private ServicoDeEstoque servicoDeEstoque;
    private BuscaProdutoMemoria banco;
    private Produto produtoBanana;
    private Produto produtoCarne;
    private Cliente cliente;

    @BeforeEach
    void configurarCenario() {
        // ARRANGE (preparação que se repete em todo teste)
        banco = new BuscaProdutoMemoria();
        produtoBanana = new Produto(1, "banana", 4.5);
        produtoCarne = new Produto(2,"Carne",50);
        banco.salvarProduto(produtoBanana, 10); // 10 unidades em estoque
        banco.salvarProduto(produtoCarne,20);

        servicoDeEstoque = new ServicoDeEstoque(banco);
        servicoDePedido = new ServicoDePedido(servicoDeEstoque);

        cliente = new Cliente(1, "pedro", "pedro@gmail.com");
    }

    @Test
    void deveCriarPedidoQuandoHaEstoqueSuficiente() {
        // ARRANGE (específico deste teste)
        ItemPedido item = new ItemPedido(produtoBanana, 3);

        // ACT
        Pedido pedido = servicoDePedido.criarPedido(item, cliente);

        // ASSERT
        assertNotNull(pedido);
        assertEquals(1, pedido.getItensPedidos().size());
    }
    @Test
    void lançarExceçãoItemNulo(){
        ItemPedido item = null;

        assertThrows(IllegalArgumentException.class,()->{
            servicoDePedido.criarPedido(item,cliente);
        });
    }

    @Test
    void deveLancarExceçãoPorQuantidadeForaDeEstoque(){
        ItemPedido item = new ItemPedido(produtoBanana,15);

        assertThrows(EstoqueInsuficienteException.class,() -> {
            servicoDePedido.criarPedido(item, cliente);
        },"Quantidade Indisponivel no Estoque");
    }

    @Test
    void deveLancarExceçãoPorIdZeroEmProduto(){

        assertThrows(IllegalArgumentException.class,() ->{
            Produto produto = new Produto(0,"carne",100);
        },"O id não deve ser negativo");
    }

    @Test
    void exceçãoAoAdicionarItemNulo(){
        ItemPedido item1 = new ItemPedido(produtoBanana, 3);
        Pedido pedido = servicoDePedido.criarPedido(item1, cliente);

        ItemPedido item2 = null;

        assertThrows(IllegalArgumentException.class,()->{
            servicoDePedido.adicionaItemAoPedido(item2,pedido);
        });
    }

    @Test
    void exceçãoAoAdicionarItemAPedidoNulo(){
        ItemPedido item = new ItemPedido(produtoBanana, 3);

        Pedido pedido = null;

        assertThrows(IllegalArgumentException.class,()->{
            servicoDePedido.adicionaItemAoPedido(item,pedido);
        });
    }

    @Test
    void exceçãoDeItemForaEstoqueAoAdicionar(){
        ItemPedido item1 = new ItemPedido(produtoBanana,1);
        ItemPedido item2 = new ItemPedido(produtoCarne,23);

        Pedido pedido = servicoDePedido.criarPedido(item1,cliente);

        assertThrows(EstoqueInsuficienteException.class,()->{
            servicoDePedido.adicionaItemAoPedido(item2,pedido);
        });

    }




}