package HerançaEPolimorfismo.Exercicio1;
public class AppIngressos {
    public static void main(String[] args){
        Ingresso familia = new IngressoFamilia(10, "Pequeno principe", "Legendado");
        Ingresso meia = new MeioIngresso(10, "Madagascar", "dublado");
        familia.valor();
        meia.valor();
    }
}
