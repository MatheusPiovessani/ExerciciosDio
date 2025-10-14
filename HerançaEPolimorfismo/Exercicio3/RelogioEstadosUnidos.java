package HerançaEPolimorfismo.Exercicio3;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class RelogioEstadosUnidos extends RelogioPai {

    public RelogioEstadosUnidos(int a, int b, int c) {
        super(a, b, c);
    }

    @Override
    public void setInformacoes(RelogioPai relogioNovo) {
        // copia valores do relógio fornecido e aplica deslocamento de fuso (-10 horas)
        LocalTime base = LocalTime.of(relogioNovo.getHoras(), relogioNovo.getMinutos(), relogioNovo.getSegundos());
        LocalTime novo = base.minusHours(10); //Subtrai para a utlizicacao de AM e PM de forma corrta
        this.horariLocalTime = novo;
        this.horas = novo.getHour();
        this.minutos = novo.getMinute();
        this.segundos = novo.getSecond();
        System.out.println("Novo horário (EUA): " + this.horariLocalTime.toString());
    }
    @Override
    public String toString(){
        //hh minusculo determina as horas de acordo com AM e PM
        DateTimeFormatter formatacao = DateTimeFormatter.ofPattern("hh:mm:ssa");
        return horariLocalTime.format(formatacao);
    }
}
