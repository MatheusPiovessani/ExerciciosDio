package main.java.java.bank.br.com.dio.model;

import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class AccountWallet extends Wallet {
    
    @Getter
    private final List<String> pix;

    public AccountWallet(final List<String> pix){
        super(BankService.ACCOUNT);
        this.pix = pix;
    }

    public AccountWallet(final long amount, final List<String> pix){
        super(BankService.ACCOUNT);
        this.pix = pix;

    }

    public void addMoney(final long amount, final String description){
        var money = generateMoney(amount, description);
        this.money.addAll(money);
    }

    public List<String> getPix(){
        return Collections.unmodifiableList(pix);
    }

    @Override
    public String toString(){
        return super.toString() + "AccountWallet" + "pix="+pix+"}";
    }

}
