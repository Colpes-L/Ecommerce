package laf.ecommerce.model;

public class Produto {
    private int id;
    private String nome;
    private double preco;

    public Produto(int id,String nome,double preco){
        if(this.id <= 0){
            throw new IllegalArgumentException("O id deve ser maior que 0.");
        }
        if(this.nome == null || this.nome.isBlank()){
            throw new IllegalArgumentException("O nome do produto nao pode ser vazio.");
        }
        if(this.preco <= 0){
            throw new IllegalArgumentException("O preco deve ser maior que 0.");
        }
        this.id = id;
        this.nome = nome;
        this.preco = preco;
    }

    public Produto(Produto outro){
        this.id = outro.getId();
        this.nome = outro.getNome();
        this.preco = outro.getPreco();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

}