package laf.ecommerce.exceptions;

public class EstoqueInsuficienteException extends RuntimeException{

    public EstoqueInsuficienteException(String mensagem) {
        super(mensagem);
    }
}
