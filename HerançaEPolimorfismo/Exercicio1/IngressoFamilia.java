package HerançaEPolimorfismo.Exercicio1;
import java.util.Scanner;
public class IngressoFamilia extends Ingresso {
    public IngressoFamilia(double valor, String nome, String tipo){
        super(valor,nome,tipo);
    }

    
    @Override
    public void valor(){
        Scanner in = new Scanner(System.in);
        System.out.print("Quantidade: ");
        int qntd = in.nextInt();
        if(qntd > 3){
            double valor = (this.valor * qntd) * 0.95;
            System.out.println("Valor total: "+valor);
            System.out.println("Desconto de 5% aplicado ao valor total!");
            in.close();
            return;
        }
        System.out.println("Valor total: "+this.valor *qntd);
        in.close();
    }
}
