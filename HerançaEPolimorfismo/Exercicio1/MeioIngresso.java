package HerançaEPolimorfismo.Exercicio1;
public class MeioIngresso extends Ingresso{

    private double valorMeia;

    public MeioIngresso(double valor, String nomeFilme, String tipo){
        super(valor,nomeFilme,tipo);
        this.valorMeia = valor/2;
    }

    @Override
    public void valor(){
        System.out.println("Valor do meio-ingresso: "+ this.valorMeia);
    }
}
