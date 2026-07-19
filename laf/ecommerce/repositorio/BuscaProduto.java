package laf.ecommerce.repositorio;

import laf.ecommerce.model.Produto;
import java.util.List;

public interface BuscaProduto {
    Produto buscarPorId(int id);
    void salvarProduto(Produto produto);
    List<Produto> listarTodos();
    void reporProduto(Produto produto,int quantidade);
    void removerProduto(Produto produto,int quantidade);
}
