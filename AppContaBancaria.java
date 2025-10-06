public class AppContaBancaria {
    public static void main(String[] args){
        ContaBancaria conta = new ContaBancaria(1000);
        conta.consultarSaldo();
        conta.consultarChequeEspecial();
        conta.sacar(1000);
        System.out.println(conta.consultarSaldo());
        System.out.println(conta.consultarChequeEspecial());
    }
}
