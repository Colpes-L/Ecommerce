package laf.ecommerce.repositorio;

import laf.ecommerce.model.Produto;
import java.util.List;

public interface BuscaPedido {
    Produto buscarPorId(int id);
    void salvarProduto(Produto produto);
    List<Produto> listarTodos();
}
