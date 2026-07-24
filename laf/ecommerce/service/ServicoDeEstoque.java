package laf.ecommerce.service;

import laf.ecommerce.model.ItemPedido;
import laf.ecommerce.model.Produto;
import laf.ecommerce.repositorio.BuscaProduto;

import java.util.List;

public class ServicoDeEstoque {

    private final BuscaProduto buscaProdutoRepositorio;

    public ServicoDeEstoque(BuscaProduto buscaProdutoRepositorio){
        this.buscaProdutoRepositorio = buscaProdutoRepositorio;
    }
    public void salvarProdutoEstoque(Produto produto){
        if(buscaProdutoRepositorio.buscarPorId(produto.getId()) == null){
            buscaProdutoRepositorio.salvarProduto(produto);
        }else {
            System.out.println("Produto ja disponivel no Estoque, para adicionar reponha os produtos");
        }
    }
    public void reporProdutoEstoque(Produto produto,int quantidade){
        if(produto!= null && buscaProdutoRepositorio.buscarPorId(produto.getId()) != null){
            buscaProdutoRepositorio.reporProduto(produto,quantidade);
        }
    }
    public void removerProdutoEstoque(Produto produto,int quantidade){
        if(produto!= null && buscaProdutoRepositorio.buscarPorId(produto.getId()) != null){
            buscaProdutoRepositorio.removerProduto(produto,quantidade);
        }
    }
    public void atualizaQuantidadeEmEstoque(List<ItemPedido> itens){
        for(ItemPedido i : itens){
            removerProdutoEstoque(i.getProduto(),i.getQuantidade());
        }
    }
    public boolean isProdutoEmEstoque(int id){
        if( buscaProdutoRepositorio.buscarPorId(id) == null){
            return false;
        }
        return true;
    }
    public int getProdutoQuantidadeEmEstoque(int id){
        return buscaProdutoRepositorio.buscarPorId(id).getQuantidadeProdutoEstoque();
    }

}