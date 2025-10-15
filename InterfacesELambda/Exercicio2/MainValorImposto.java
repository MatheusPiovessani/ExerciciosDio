package InterfacesELambda.Exercicio2;

import java.util.Scanner;
import java.util.Arrays;
import java.util.List;

public class MainValorImposto {
    public static void main(String[] args){
        boolean sair = false;


        List<valorImposto> lista = Arrays.asList(
        valor -> System.out.println("Valor alimentação: " + valor * 0.01),
        valor -> System.out.println("Valor Saude e bem-estar: "+ valor * 0.015),
        valor -> System.out.println("Valor Vestuário: "+ valor * 0.025),
        valor -> System.out.println("Valor cultura: "+ valor*0.04)
        );


        Scanner in = new Scanner(System.in);
        while(!sair){
            System.out.println("========Menu========");
            System.out.println("1 - Alimentação");
            System.out.println("2 - Saúde e bem-estar");
            System.out.println("3 - Vestuário");
            System.out.println("4 - Cultura");
            System.out.println("5 - Sair");
            int opcao = in.nextInt();
                if (opcao >= 1 && opcao <= 4) {
                    System.out.print("Digite o valor do produto: ");
                    int v = in.nextInt();
                lista.get(opcao - 1).calculaImposto(v);
            }
            
            if (opcao == 5) {
                sair = true;
                System.out.println("Saindo do programa!");
            }
            
        }
        in.close();

}
}

