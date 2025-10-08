import java.util.Scanner;
public class AppContaBancaria {
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int option;
        double valorConta;
        boolean on = false;

        System.out.println("Com quanto voce deseja instanciar a Conta Bancaria ?");
        valorConta = in.nextDouble();

        ContaBancaria conta = new ContaBancaria(valorConta);

        on = true;
    while (on) {
        System.out.println("========= Menu inicial =========");
        System.out.println("1 - Consultar Saldo");
        System.out.println("2 - Consultar Cheque Especial");
        System.out.println("3 - Depositar Dinheiro");
        System.out.println("4 - Sacar Dinheiro");
        System.out.println("5 - Pagar um boleto");
        System.out.println("6 - Verificar se a contá está usando Cheque Especial");
        System.out.println("7 - Sair do programa");
        option = in.nextInt(); 
      
        switch (option) {
                case 1:
                    conta.consultarSaldo();
                    break;

                case 2:
                    conta.consultarChequeEspecial();
                    break;

                case 3:
                    System.out.println("Quanto voce deseja depositar? ");
                    double valorDeposito = in.nextDouble();
                    conta.depositar(valorDeposito);
                    break;

                case 4:
                    System.out.println("Quanto voce deseja sacar? ");
                    double valorSaque = in.nextDouble();
                    conta.sacar(valorSaque);
                    break;

                case 5:
                    System.out.println("Qual o valor do boleto que voce deseja pagar? ");
                    double valorBoleto = in.nextDouble();
                    conta.pagarBoleto(valorBoleto);
                    break;

                case 6:
                    if(conta.getUsandoChequeEspecial()){
                        System.out.println("Usando limite do Cheque Especial");
                    }else{
                        System.out.println("Não está usando o limite do Cheque Especial");
                    };
                    break;
                
                case 7:
                    System.out.println("Saindo do programa...");
                    on = false;
                    break;
                default:
                    System.out.println("Número invalido, tente outro!");
                    break;
            }
        }
         in.close();
    }
}
