package java.bank.br.com.dio.repository;

import java.util.ArrayList;
import java.util.List;

import main.java.java.bank.br.com.dio.exception.AccountWithInvestmentException;
import main.java.java.bank.br.com.dio.exception.InvestmentNotFoundException;
import main.java.java.bank.br.com.dio.exception.WalletNotFoundException;
import main.java.java.bank.br.com.dio.model.AccountWallet;
import main.java.java.bank.br.com.dio.model.Investment;
import main.java.java.bank.br.com.dio.model.InvestmentWallet;
import main.java.java.bank.br.com.dio.model.Wallet; 

import static main.java.java.bank.br.com.dio.repository.CommonsRepository.checkFundsForTransaction;

public class InvestmentRepository {

    private long nextId;
    private final List<Investment> investments = new ArrayList<>();
    private final List<InvestmentWallet> wallets = new ArrayList<>();

    public Investment create(final long tax, final long initialFunds){
        this.nextId++;
        var investment = new Investment(this.nextId, tax, initialFunds);
        investments.add(investment);
        return investment;

    }

    public InvestmentWallet initInvestment(final AccountWallet account,final long id){
        var accountsInUse = wallets.stream().map(InvestmentWallet :: getAccount).toList();
            if(accountsInUse.contains(account)){
                throw new AccountWithInvestmentException("A conta: "+ account + " já possui um investimento");
            }
        var investment = findById(id);
        checkFundsForTransaction(account,investment.initialFunds());
        var wallet = new InvestmentWallet(investment, account, investment.initialFunds());
        wallets.add(wallet);
        return wallet;
    }

    public InvestmentWallet deposit(final String pix, final long funds){
        var wallet = findWalletByAccountPix(pix);
        wallet.addMoney(((Wallet) wallet.getAccount()).reduceMoney(funds), wallet.getService(), "Investimento");
        return wallet;
    }

    public InvestmentWallet withdraw(final String pix, final long funds){
        var wallet = findWalletByAccountPix(pix);
        checkFundsForTransaction(wallet, funds);
        ((Wallet) wallet.getAccount()).addMoney(wallet.reduceMoney(funds), wallet.getService(), "Saque de investimentos");
        if(wallet.getFunds() == 0){
            wallets.remove(wallet);
        }
        return wallet;

    }

    public void updateAmount(final long percent){
        wallets.forEach(w -> w.updateAmount(percent));
    }

    public Investment findById(final long id){
        return investments.stream().filter(a -> a.id() == id)
        .findFirst()
        .orElseThrow(
            () -> new InvestmentNotFoundException("O investimento "+id+" não foi encontrado!")
        );
    }

    public InvestmentWallet findWalletByAccountPix(final String pix){
        return wallets.stream()
        .filter(w -> ((AccountWallet) w.getAccount()).getPix().contains(pix))
        .findFirst()
        .orElseThrow(
            () -> new WalletNotFoundException("A carteira nao foi encontrada!")
        );
    }

    public List<InvestmentWallet> listWallet(){
        return this.wallets;
    }


    public List<Investment> list(){
        return this.investments;
    }
}
