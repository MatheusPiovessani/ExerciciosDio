public class ContaBancaria {

    private double saldo;
    private double chequeEspecial;
    protected boolean usandoChequeEspecial = false;
    private double limiteTotal;

    public ContaBancaria(double valor) {
        if (valor <= 500) {
            this.chequeEspecial = 50;
        } else {
            this.chequeEspecial = valor * 0.5;
        }
        this.saldo = valor;
        this.limiteTotal = this.chequeEspecial;
    }

    public boolean getUsandoChequeEspecial(){
        return this.usandoChequeEspecial;
    }

    public void consultarSaldo() {
        System.out.println("Saldo disponível: "+this.saldo+ " e R$ "+this.chequeEspecial+ " são do Cheque Especial");
    }

    public void consultarChequeEspecial() {
        System.out.printf("Limite do cheque especial: R$ %.2f%n", this.chequeEspecial);
    }
   
    public void depositar(double valor) {
        if (usandoChequeEspecial) {
            double valorUsado = limiteTotal - (saldo + chequeEspecial);
            double taxa = 0.2 * valorUsado; // taxa de 20% sobre o valor usado
            System.out.printf("Taxa de R$ %.2f cobrada pelo uso do cheque especial.%n", taxa);
            valor -= taxa;
            usandoChequeEspecial = false;
            chequeEspecial = this.limiteTotal; // reajusta limite
        }
        saldo += valor - chequeEspecial;
        System.out.printf("Depósito de R$ %.2f realizado com sucesso.%n", valor);
    }

    public void sacar(double valor) {
        if (valor <= this.saldo) {
            this.saldo -= valor;
        } else if (valor >= this.saldo) {
            double diferenca = valor - this.saldo;
            this.saldo = 0;
            this.chequeEspecial -= diferenca;
            this.usandoChequeEspecial = true;
            System.out.println("Usando cheque especial!");
        } else {
            System.out.println("Saldo insuficiente para realizar o saque.");
            return;
        }
        System.out.printf("Saque de R$ %.2f realizado com sucesso.%n", valor);
    }

    public void pagarBoleto(double valor) {
        if (valor > this.saldo + this.limiteTotal) {
            throw new IllegalArgumentException("Sem saldo na conta!");
        }
        System.out.println("Pagando boleto...");
        sacar(valor);
    }
}
