package HerançaEPolimorfismo.Exercicio1;
public class Ingresso {
    protected double valor;
    protected String nomeFilme;
    protected String tipo;

    public Ingresso(double valor, String nomeFilme,String tipo){
        this.valor = valor;
        this.nomeFilme = nomeFilme;
        if(tipo.equalsIgnoreCase("dublado") || tipo.equalsIgnoreCase("legendado")){
            this.tipo = tipo;
        }else{
            //Aqui o uso de 'throw new' é necessario para que a operação pare e nao deixe o objeto ser instanciado
            throw new IllegalArgumentException("Tipo invalido: Informe 'Dublado' ou 'Legendado'");
        }
    }
    public void valor(){
        System.out.println("Valor: "+ this.valor);
    }
}
