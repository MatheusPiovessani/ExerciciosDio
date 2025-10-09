package Abstração.Exercicio3;
import java.util.Scanner;

public class AppPetShop {
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        Pet pet = new Pet("Pepeu");
        MaquinaBanho maquina = new MaquinaBanho();
        boolean sair  = false;
        int option;

        while(!sair){
            System.out.println("========= Menu inicial =========");
            System.out.println("1 - Dar banho");
            System.out.println("2 - Abastecer com água");
            System.out.println("3 - Abastecer com Shampoo");
            System.out.println("4 - Verificar nível de água");
            System.out.println("5 - Verificar nível de shampoo");
            System.out.println("6 - Verificar se tem pet no banho");
            System.out.println("7 - Colocar pet na maquina");
            System.out.println("8 - Retirar pet da maquina");
            System.out.println("9 - Limpar maquina");
            System.out.println("0 - Sair do programa");
            option = in.nextInt(); 

            switch (option) {
                case 1:
                    maquina.darBanho(pet);
                    break;
                case 2:
                    System.out.println("Quantos litros de água voce deseja abastecer?");
                    double qntd = in.nextDouble();
                    maquina.abastecerAgua(qntd);
                    break;
                case 3:
                    System.out.println("Quantos litros de shampoo voce deseja abastecer?");
                    double qntd2 = in.nextDouble();
                    maquina.abastecerShampoo(qntd2);
                    break;
                case 4:
                    maquina.verificarAgua();
                    break;
                case 5:
                    maquina.verificarShampoo();
                    break;
                case 6:
                    maquina.verificarPetBanho();
                    break;
                case 7:
                    maquina.colocarPetMaquina(pet);
                    break;
                case 8:
                    maquina.retirarPetMaquina(pet);
                    break;
                case 9:
                    maquina.limparMaquina();
                    break;
                case 0:
                    sair = true;
                    System.out.println("Saindo do programa...");
                    break;
                default:
                    break;
            }
        }
        in.close();
    }
}
