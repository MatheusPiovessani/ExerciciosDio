package HerançaEPolimorfismo.Exercicio3;
import java.time.LocalTime;

public class RelogioBrasil extends RelogioPai {

    public RelogioBrasil(int a, int b, int c) {
        super(a, b, c);
    }

    @Override
    public void setInformacoes(RelogioPai relogioNovo) {
        this.horas = relogioNovo.getHoras();
        this.minutos = relogioNovo.getMinutos();
        this.segundos = relogioNovo.getSegundos();
        this.horariLocalTime = LocalTime.of(this.horas, this.minutos, this.segundos);
        System.out.println("Novo horário do relógio: " + this.horariLocalTime.toString());
    }
}
