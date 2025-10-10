package HerançaEPolimorfismo.Exercicio2;

public class Gerente extends Funcionario{
    public Gerente (String nome, String email, String senha) {
        super(nome, email, senha);
        this.isAdministrador = true;
    }

    public void gerarRelatorioFinanceiro() {
        System.out.println("Relatório financeiro básico: ");
        try {
            System.out.println("Valor em caixa: " + Atendente.getValorCaixa());
            System.out.println("Valor total em vendas: " + Vendedor.getVendas());
        } catch (NoClassDefFoundError | Exception e) {
            System.out.println("Classe Vendedor ou Atendente ausente");
        }

    }

    public void consultarVendas() {
        System.out.print("Quantidade total de vendas: " + Vendedor.getVendas());
    }
}
