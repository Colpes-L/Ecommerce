package laf.ecommerce.persistence;
import java.util.HashMap;

import laf.ecommerce.model.Produto;
import laf.ecommerce.repositorio.BuscaProduto;

import java.util.ArrayList;
import java.util.List;

public class BuscaProdutoMemoria implements BuscaProduto {
    private List<Produto> produtos = new ArrayList<>();
    private HashMap<Integer,Integer> quantidadeDeProdutos = new HashMap<Integer, Integer>();

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
        salvarProduto(produto,1);
    }

    @Override
    public void salvarProduto(Produto produto, int quantidade) {
        if(produto == null){
            System.out.println("Produto Invalido");
            return;
        }
        if(quantidade < 0) {
            System.out.println("Quantidade Invalida, deve ser maior que 0");
            return;
        }
        produtos.add(produto);
        quantidadeDeProdutos.put(produto.getId(), quantidade);
    }

    @Override
    public List<Produto> listarTodos() {
        return List.copyOf(produtos);
    }

    @Override
    public void reporProduto(Produto produto, int quantidade) {
        if(quantidade > 0 && produto != null){
            quantidadeDeProdutos.put(produto.getId(), quantidadeDeProdutos.get(produto.getId()) + quantidade);
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
