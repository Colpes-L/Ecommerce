package laf.ecommerce.model;

public class Cliente {
    private int id;
    private String nome;
    private String email;

    public Cliente(int id,String nome, String email){
        if(this.id <= 0){
            throw new IllegalArgumentException("O id deve ser maior que 0.");
        }
        if(this.nome == null || this.nome.isBlank()){
            throw new IllegalArgumentException("O nome do cliente nao pode ser vazio.");
        }
        if(this.email == null || this.email.isBlank()){
            throw new IllegalArgumentException("O email do cliente nao pode ser vazio.");
        }
        this.id = id;
        this.nome = nome;
        this.email = email;

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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}