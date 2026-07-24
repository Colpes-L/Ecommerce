package laf.ecommerce.model;

public class ItemPedido {
    private Produto produto;
    private int quantidade;


    public ItemPedido(Produto produto, int quantidade){
        this.produto = new Produto(produto);
        this.quantidade = quantidade;
    }
    public Produto getProduto() {
        return produto;
    }

    public void setProduto(Produto produto) {
        this.produto = new Produto(produto);
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }
}