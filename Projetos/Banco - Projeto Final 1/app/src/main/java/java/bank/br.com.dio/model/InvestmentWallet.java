package main.java.java.bank.br.com.dio.model;

import java.time.OffsetDateTime;
import java.util.UUID;
import java.util.stream.Stream;

public class InvestmentWallet extends Wallet {
    private final Investment investment;
    private final AccountWallet account;
    
    public InvestmentWallet(final Investment investment, final AccountWallet account, final long amount){
        super(INVESTMENT);
        this.investment = investment;
        this.account = account;
        addMoney(account.reduceMoney(amount), getService(),"Investimento");
    }
    
    public void updateAmount(final long percent){
        var amount = getFunds * percent / 100;
        var history = new MoneyAudit(UUID.randomUUID(), getService(), "Rendimento", OffsetDateTime.now());
        var money = Stream.generate(() -> new Money(history)).limit(amount).toList();
        this.money.addAll(money);
    }

    public Object getAccount() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getAccount'");
    }

    public BankService getService() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getService'");
    }
}
