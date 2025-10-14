package HerançaEPolimorfismo.Exercicio3;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public abstract class RelogioPai {
    protected int horas;
    protected int minutos;
    protected int segundos;
    protected LocalTime horariLocalTime;

    public RelogioPai(int horas, int minutos, int segundos){
        this.horas = horas;
        this.minutos = minutos;
        this.segundos = segundos;
        horariLocalTime = LocalTime.of(this.horas, this.minutos, this.segundos);
    }
    public void setHoras(int horas){
        if(this.horas < 0 || this.horas >= 24){
            throw new IllegalArgumentException("Valores fornecidos inválidos!");
        }

        this.horas = horas;
        this.horariLocalTime = LocalTime.of(this.horas, this.minutos, this.segundos);
    }
    public void setMinutos(int minutos){
        if(this.minutos < 0 || this.minutos >= 60){
            throw new IllegalArgumentException("Valores fornecidos inválidos!");
        }

        this.minutos = minutos;
        this.horariLocalTime = LocalTime.of(this.horas, this.minutos, this.segundos);

    }
    public void setSegundos(int segundos){
        if(this.segundos < 0 || this.segundos >= 60){
            throw new IllegalArgumentException("Valores fornecidos inválidos!");
        }

        this.segundos = segundos;
        this.horariLocalTime = LocalTime.of(this.horas, this.minutos, this.segundos);
    }
    public int getHoras(){
        return this.horas;
    }
    public int getMinutos(){
        return this.minutos;
    }
    public int getSegundos(){
        return this.segundos;
    }
    public String toString(){
        DateTimeFormatter formatacao = DateTimeFormatter.ofPattern("HH:mm:ss");
        return horariLocalTime.format(formatacao);
    }
    public abstract void setInformacoes(RelogioPai relogio);
}
