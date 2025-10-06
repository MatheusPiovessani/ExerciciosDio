public class ContaBancaria {
   
    private double saldo;
    private double chequeEspecial;
    private double saldoUtilizadoChequeEspecial = 0;

    public ContaBancaria(double valor){
        if(valor <= 500){
            this.chequeEspecial = 50;
        }else{
            this.chequeEspecial = valor * 0.5;
        }
        this.saldo = valor;
    }
    public double consultarSaldo(){
        return (this.saldo+this.chequeEspecial);
    }
    public double consultarChequeEspecial(){
        return (this.chequeEspecial - this.saldoUtilizadoChequeEspecial);
    }
    public void depositar(double valor) {
        if (saldoUtilizadoChequeEspecial > 0) {
            double valorParaCobrir = Math.min(valor, saldoUtilizadoChequeEspecial);
            saldoUtilizadoChequeEspecial -= valorParaCobrir;
            valor -= valorParaCobrir;
        }
        this.saldo += valor;
    }
    public void sacar(double valor){
        if(valor > consultarSaldo()){
            throw new IllegalArgumentException("Sem saldo na conta!");
        }
       // if(this.saldoUtilizadoChequeEspecial >= this.chequeEspecial){
         //   System.out.println("Uma taxa de 20% do valor usado do cheque especial será aplicada a voce!");
           // this.saldo -= this.chequeEspecial * 0.20;
        //}
        this.saldo -= valor;
        if(this.saldo <= this.chequeEspecial){
            this.chequeEspecial = this.saldo;
            this.saldo = 0;
        }
    }
    public void pagarBoleto(double valor){
        if(valor > this.saldo){
            throw new IllegalArgumentException("Sem saldo na conta!");
        }
        if(this.saldo <= this.chequeEspecial){
            System.out.println("Uma taxa de 20% do valor usado do cheque especial será aplicada a voce!");
            this.saldo -= this.chequeEspecial * 0.20;
            this.saldo -=valor;
        }
        this.saldo -=valor;
        System.out.println("Boleto pago com sucesso!");
    }
}
