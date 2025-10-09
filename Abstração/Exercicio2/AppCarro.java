import java.util.Scanner;
public class AppCarro {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        Carro carro = new Carro();
        boolean sair = false;
        int option;


        while(!sair){
            System.out.println("========= Menu inicial =========");
            System.out.println("1 - Ligar carro");
            System.out.println("2 - Subir marcha");
            System.out.println("3 - Acelerar");
            System.out.println("4 - Freiar");
            System.out.println("5 - Descer marcha");
            System.out.println("6 - Virar a esquerda");
            System.out.println("7 - Virar a direita");
            System.out.println("8 - Desligar carro");
            System.out.println("9 - Status do carro");
            System.out.println("0 - Sair do programa");
            option = in.nextInt(); 

            switch (option) {
                case 1:
                    carro.ligar();
                    break;
                case 2:
                    carro.subirMarcha();
                    break;
                case 3:
                    carro.acelerar();
                    break;
                case 4:
                    carro.freiar();
                    break;
                case 5:
                    carro.descerMarcha();
                    break;
                case 6:
                    carro.virarEsquerda();
                    break;
                case 7:
                    carro.virarDireita();
                    break;
                case 8:
                    carro.desligar();
                    break;
                case 9:
                    carro.status();
                    break;
                case 0:
                    sair = true;
                    break;
                default:
                    break;
            }
        }
        in.close();
        
    }
}
