public class AppContaBancaria {
    public static void main(String[] args){
        ContaBancaria conta = new ContaBancaria(1000);
        conta.consultarSaldo();
        conta.consultarChequeEspecial();
        conta.sacar(1200);
        conta.consultarSaldo();
        conta.consultarChequeEspecial();
        conta.sacar(500);
        conta.consultarSaldo();
        conta.consultarChequeEspecial();

    }
}
