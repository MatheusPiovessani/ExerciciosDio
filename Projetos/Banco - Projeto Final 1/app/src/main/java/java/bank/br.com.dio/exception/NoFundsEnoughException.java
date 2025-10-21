package main.java.java.bank.br.com.dio.exception;

public class NoFundsEnoughException extends RuntimeException {
    public NoFundsEnoughException(String message){
        super(message);
    }

}
