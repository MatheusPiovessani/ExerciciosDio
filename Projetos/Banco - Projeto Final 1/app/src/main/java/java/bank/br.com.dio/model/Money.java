package main.java.java.bank.br.com.dio.model;


import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Money {
    private final List<MoneyAudit> history = new ArrayList<>();

    public Money(final MoneyAudit history){
        this.history.add(history);
    }

    public void addHistory(final MoneyAudit history){
        this.history.add(history);
    }
    public List<MoneyAudit> getHistory(){
        return Collections.unmodifiableList(history);
    }
}
