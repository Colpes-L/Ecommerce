package laf.ecommerce.persistence;

import laf.ecommerce.model.Produto;
import laf.ecommerce.repositorio.BuscaProduto;

import java.util.ArrayList;
import java.util.List;

public class BuscaProdutoMemoria implements BuscaProduto {
    private List<Produto> produtos = new ArrayList<>();

    @Override
    public Produto buscarPorId(int id) {
        for(Produto p: produtos){
            if(p.getId() == id){
                return p;
            }
        }
        return null;
    }

    @Override
    public void salvarProduto(Produto produto) {
        if(produto != null){
            produtos.add(produto);
        }
    }

    @Override
    public List<Produto> listarTodos() {
        return List.copyOf(produtos);
    }

    @Override
    public void reporProduto(Produto produto, int quantidade) {
        if(quantidade > 0){
            for(Produto p: produtos){
                if(p.getId() == produto.getId()){
                    p.setQuantidadeProdutoEstoque(quantidade);
                }
            }
        }
    }

    @Override
    public void removerProduto(Produto produto, int quantidade) {
        if(quantidade > 0) {
            for (Produto p : produtos) {
                if (p.getId() == produto.getId()) {
                    p.setQuantidadeProdutoEstoque(p.getQuantidadeProdutoEstoque() - quantidade);
                }
            }
        }
    }
}
