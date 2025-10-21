package main.java.java.bank.br.com.dio.exception;

public class WalletNotFoundException extends RuntimeException {
    public WalletNotFoundException(String message){
        super(message);
    }
}
