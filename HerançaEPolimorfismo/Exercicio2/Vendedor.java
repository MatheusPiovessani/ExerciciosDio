package HerançaEPolimorfismo.Exercicio2;

public class Vendedor extends Funcionario{

    protected static int vendas;

    public Vendedor(String nome, String email, String senha){
        super(nome, email, senha);
        vendas = 0;
    }

    public void realizarVenda(){
        if(!this.login){
            System.out.println("Voce deve realizar o login antes!");
            return;
        }
        System.out.println("Voce realizou uma venda!");
        vendas++;
    }
    public static int getVendas(){
        return vendas;
    }
    public void consultarVendas(){
        System.out.println("Quantidade de vendas: "+vendas);
    }
}
