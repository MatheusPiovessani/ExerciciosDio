package HerançaEPolimorfismo.Exercicio2;
public class AppSistema {
    public static void main(String[] args){
        Gerente gerente = new Gerente("Pedro", "p@ex.com", "123");
        Atendente atendente = new Atendente("Matheus", "a@ex.com", "123");
        Vendedor vendedor = new Vendedor("Gustavo", "v@ex.com", "123");

        vendedor.realizarLogin();
        vendedor.realizarVenda();

        atendente.realizarLogin();
        atendente.receberPagamentos(100);

        gerente.gerarRelatorioFinanceiro();
    }
 }
