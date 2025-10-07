public class ContaBancaria {

    private double saldo;
    private double chequeEspecial;
    private boolean usandoChequeEspecial;
    private double limiteTotal;

    public ContaBancaria(double valor) {
        if (valor <= 500) {
            this.chequeEspecial = 50;
        } else {
            this.chequeEspecial = valor * 0.5;
        }
        this.saldo = valor;
        this.limiteTotal = this.saldo + this.chequeEspecial;
    }

    public void consultarSaldo() {
        System.out.printf("Saldo disponível: R$ %.2f%n", saldo);
        System.out.printf("Cheque especial disponível: R$ %.2f%n", chequeEspecial);
    }

    public void consultarChequeEspecial() {
        System.out.printf("Limite do cheque especial: R$ %.2f%n", chequeEspecial);
    }
     private double definirChequeEspecial(double saldoInicial) {
        if (saldoInicial <= 500) {
            return 50.0;
        } else {
            return saldoInicial * 0.5;
        }
    }

    public void depositar(double valor) {
        if (usandoChequeEspecial) {
            double valorUsado = limiteTotal - (saldo + chequeEspecial);
            double taxa = 0.2 * valorUsado; // taxa de 20% sobre o valor usado
            System.out.printf("Taxa de R$ %.2f cobrada pelo uso do cheque especial.%n", taxa);
            valor -= taxa;
            usandoChequeEspecial = false;
            chequeEspecial = definirChequeEspecial(saldo + valor); // reajusta limite
        }
        saldo += valor;
        System.out.printf("Depósito de R$ %.2f realizado com sucesso.%n", valor);
    }

    public void sacar(double valor) {
        if (valor <= saldo) {
            saldo -= valor;
        } else if (valor <= saldo + chequeEspecial) {
            double diferenca = valor - saldo;
            saldo = 0;
            chequeEspecial -= diferenca;
            usandoChequeEspecial = true;
            System.out.println("Usando cheque especial!");
        } else {
            System.out.println("Saldo insuficiente para realizar o saque.");
            return;
        }
        System.out.printf("Saque de R$ %.2f realizado com sucesso.%n", valor);
    }

    public void pagarBoleto(double valor) {
        if (valor > this.saldo) {
            throw new IllegalArgumentException("Sem saldo na conta!");
        }
        System.out.println("Pagando boleto...");
        sacar(valor);
    }
}
