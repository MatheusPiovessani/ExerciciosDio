package Exercicio3;

public class Pet {
    private String nome;
    private boolean limpo;

    public Pet(String nome){
        this.nome = nome;
        this.limpo = false;
    }

    public void setLimpo(){
        this.limpo = true;
    }
    public boolean getLimpo(){
        return this.limpo;
    }
    public String toString(){
        StringBuilder sb = new StringBuilder();
        sb.append("Nome: "+this.nome);
        sb.append("Limpo: "+this.limpo);
        return sb.toString();
    }
}
