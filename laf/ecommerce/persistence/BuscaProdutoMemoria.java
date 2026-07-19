package laf.ecommerce.persistence;

import laf.ecommerce.model.Produto;
import laf.ecommerce.repositorio.BuscaProduto;

import java.util.List;

public class BuscaProdutoMemoria implements BuscaProduto {
    private List<Produto> produtos;

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
}
