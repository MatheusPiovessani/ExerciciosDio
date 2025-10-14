package HerançaEPolimorfismo.Exercicio3;
public class AppRelogio {
    public static void main(String[] args){
        RelogioPai relogioBrasil = new RelogioBrasil(23, 25, 30);
        RelogioPai relogioUsa = new RelogioEstadosUnidos(20, 12, 1);
        RelogioPai relogioNovo = new RelogioBrasil(15,50,12);
        System.out.println(relogioBrasil.toString());
        relogioBrasil.setInformacoes(relogioNovo);
        System.out.println(relogioUsa.toString());
        relogioUsa.setInformacoes(relogioNovo);

    }
}
