import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoField;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

import main.java.java.bank.br.com.dio.repository.AccountRepository;

public class Main {

    private final static AccountRepository accountRepository = new AccountRepository();
    private final static InvestmentRepository investimentsRepository = new InvestmentRepository();

    static Scanner in = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("Olá seja bem-vindo ao DIO Bank");
        while (true) {
            System.out.println("Selecione a operação desejada!");
            System.out.println("1 - Criar uma conta");
            System.out.println("2 - Criar um investimento");
            System.out.println("3 - Fazer um investimento");
            System.out.println("4 - Depositar na conta");
            System.out.println("5 - Sacar da conta");
            System.out.println("6 - Transferência entre contas");
            System.out.println("7 - Investir");
            System.out.println("8 - Sacar investimento");
            System.out.println("9 - Listar contas");
            System.out.println("10 - Listar investimentos");
            System.out.println("11 - Listar carteiras de investimento");
            System.out.println("12 - Atualizar investimento");
            System.out.println("13 - Histórico de conta");
            System.out.println("14 - Sair");
            var option = in.nextInt();

            switch (option) {
                case 1:
                    createAccount();
                    break;          
                case 2:
                    createInvestment();
                    break;
                case 3:
                    createWalletInvestment();
                    break;
                case 4:
                    deposit();
                    break;
                case 5:
                    withdraw(); 
                    break;
                case 6:
                    transferToAccount();
                    break;
                case 7:
                    incInvestment();
                    break;
                case 8:
                    rescueInvestment();
                    break;
                case 9:
                    accountRepository.list().forEach(System.out::println);
                    break;
                case 10:
                    investimentsRepository.list().forEach(System.out::println);
                    break;
                case 11:
                    investimentsRepository.listWallet().forEach(System.out::println);
                    break;

                case 12:
                    investimentsRepository.updateAmount();
                    System.out.println("Investimentos reajustados!");
                    break;
                case 13:        
                    break;
                case 14:
                    System.exit(0);
                    break;

                default:
                    System.out.println("Opção invalida!");
                    break;
            }

        }
    }
    private static void createAccount(){
        System.out.println("Informe as chaves pix (separadas por ;)");
        var pix = Arrays.stream(in.next().split(";")).toList();
        System.out.println("Informe o valor incicial de depósito");
        var amount = in.nextLong();
        var wallet = accountRepository.create(pix, amount);
        System.out.println("Conta criada: "+wallet);
    }

    private static void createInvestment(){
        System.out.println("Informe a taxa do investimento:");
        var tax = in.nextInt();
        System.out.println("Informe o valor incicial de depósito");
        var initialFunds = in.nextLong();
        var investment = investimentsRepository.create(tax, initialFunds);
        System.out.println("Investimento criado: "+investment);

    }

    private static void deposit(){
        System.out.println("Informe a chave pix da conta para depósito.");
        var pix = in.next();
        System.out.println("Informe o valor a ser depositado");
        var amount = in.nextLong();
        try{
            accountRepository.deposit(pix, amount);
        }catch(AccountNotFoundException e){
            System.out.println(e.getMessage());
        }
    }

    private static void withdraw(){
        System.out.println("Informe a chave pix da conta para saque.");
        var pix = in.next();
        System.out.println("Informe o valor a ser sacado");
        var amount = in.nextLong();
        try{
            accountRepository.withdraw(pix, amount);
        }catch(NoFundsEnoughException | AccountNotFoundException e){
            System.out.println(e.getMessage());
        }
    }

    private static void transferToAccount(){
        System.out.println("Informe a chave pix da conta de origem.");
        var pixOrigem = in.next();
        System.out.println("Informe a chave pix da conta de destino:");
        var pixDestino = in.next();
        System.out.println("Informe o valor a ser depositado");
        var amount = in.nextLong();
        try{
            accountRepository.transferMoney(pixOrigem,pixDestino,amount);
        }catch(AccountNotFoundException e){
            System.out.println(e.getMessage());
        }
    }

    private static void createWalletInvestment(){
        System.out.println("Informe a chave pix da conta.");
        var pix = in.next();
        var account = accountRepository.findByPix(pix);
        System.out.println("Informe o identificador do investimento!");
        var investmentId = in.nextInt();
        var investmentWallet = investimentsRepository.initInvestment(account, investmentId);
        System.out.println("Conta de investimento criada:" + investmentWallet);
    }
    
    private static void incInvestment(){
        System.out.println("Informe a chave pix da conta para investimento.");
        var pix = in.next();
        System.out.println("Informe o valor a ser investido");
        var amount = in.nextLong();
        try{
            investimentsRepository.deposit(pix, amount);
        }catch(AccountNotFoundException e){
            System.out.println(e.getMessage());
        }
    }

    private static void rescueInvestment(){
        System.out.println("Informe a chave pix da conta para resgate do investimento.");
        var pix = in.next();
        System.out.println("Informe o valor a ser sacado");
        var amount = in.nextLong();
        try{
            investimentsRepository.withdraw(pix, amount);
        }catch(NoFundsEnoughException | AccountNotFoundException e){
            System.out.println(e.getMessage());
        }
    }

    private static void checkHistory(){
        System.out.println("Informe a chave pix da conta para verificar extrato.");
        var pix = in.next();
        AccountWallet wallet; 
        try{
            var sortedHistory = accountRepository.getHistory(pix);
            sortedHistory.forEach((k,v) -> {
                System.out.println(k.format(DateTimeFormatter.ISO_DATE_TIME));
                System.out.println(v.getFirst().transactionId());
                System.out.println(v.getFirst().description());
                System.out.println(v.size());
            });

        }catch(AccountNotFoundException e){
            System.out.println(e.getMessage());
        }
    }
}
