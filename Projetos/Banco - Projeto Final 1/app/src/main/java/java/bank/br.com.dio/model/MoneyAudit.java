package main.java.java.bank.br.com.dio.model;

import java.time.OffsetDateTime;
import java.util.UUID;

public record MoneyAudit(
    UUID transactionId, //Id de transação
    BankService targetService, //Servico que foi utilizado nessa transação
    String description, //Descrição
    OffsetDateTime createAt) //Data e hora que isso ocorreu
{

}
