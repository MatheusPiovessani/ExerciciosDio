package main.java.java.bank.br.com.dio.repository;

import java.time.OffsetDateTime;
import java.util.List;
import java.util.UUID;
import java.util.stream.Stream;

import main.java.java.bank.br.com.dio.exception.NoFundsEnoughException;
import main.java.java.bank.br.com.dio.model.BankService;
import main.java.java.bank.br.com.dio.model.Money;
import main.java.java.bank.br.com.dio.model.MoneyAudit;
import main.java.java.bank.br.com.dio.model.Wallet;
    public final class CommonsRepository {

        public static void checkFundsForTransaction(final Wallet source, final long amount){
            if(source.getFunds() < amount){
                throw new NoFundsEnoughException("Sua conta não tem dinheiro suficiente para realizar essa transação");
            }
        }
        public static List<Money> generateMoney(final UUID transactionId, final long funds, final String description){
            var history = new MoneyAudit(transactionId, BankService.ACCOUNT, description, OffsetDateTime.now());
            return Stream.generate(() -> new Money(history)).limit(funds).toList();
        }
}
