package java.bank.br.com.dio.exception;

public class AccountNotFoundException extends RuntimeException {

    public AccountNotFoundException(String message){
        super(message);
    }
}
