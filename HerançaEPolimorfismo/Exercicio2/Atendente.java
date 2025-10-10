package HerançaEPolimorfismo.Exercicio2;

public class Atendente extends Funcionario {

    protected static int valorCaixa;
    protected boolean caixaAberto = false;

    public Atendente(String nome, String email, String senha) {
        super(nome, email, senha);
        valorCaixa = 0;
    }

    public static int getValorCaixa(){
        return valorCaixa;
    }
    public void receberPagamentos(int valor) {
        if (!this.login) {
            System.out.println("Primeiro voce deve fazer o login");
            return;
        }

        valorCaixa += valor;
        System.out.println("Valor adicioando no caixa!");
    }

    public void fecharCaixa() {
        if (!this.caixaAberto) {
            System.out.println("O caixa já está fechado!");
            return;
        }
        System.out.println("Caixa fechado com sucesso!");
        this.caixaAberto = false;
    }
}
