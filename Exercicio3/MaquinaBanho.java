package Exercicio3;

public class MaquinaBanho {
    private boolean maquinaEmUso;
    private double agua;
    private double shampoo;
    private boolean maquinaLimpa;

    //Definição das constantes para facilitar a manipulação das variaveis depois
    private static final double AGUA_POR_BANHO = 10.0;
    private static final double SHAMPOO_POR_BANHO = 2.0;
    private static final double MAX_AGUA = 30.0;
    private static final double MAX_SHAMPOO = 10.0;

    public MaquinaBanho() {
        this.maquinaEmUso = false;
        this.agua = 0;
        this.shampoo = 0;
        this.maquinaLimpa = true;
    }

    public void darBanho(Pet pet) {
        if (!maquinaEmUso) {
            System.out.println("Coloque o pet na máquina antes de iniciar o banho!");
            return;
        }

        if (!maquinaLimpa) {
            System.out.println("A máquina precisa ser limpa antes de um novo banho!");
            return;
        }

        if (agua < AGUA_POR_BANHO || shampoo < SHAMPOO_POR_BANHO) {
            System.out.println("Quantidade insuficiente de água ou shampoo.");
            return;
        }

        if (pet.getLimpo()) {
            System.out.println("O pet já está limpo.");
            return;
        }

        agua -= AGUA_POR_BANHO;
        shampoo -= SHAMPOO_POR_BANHO;
        pet.setLimpo();
        System.out.println("Banho realizado com sucesso!");
    }

    public void abastecerAgua(double quantidade) {
        abastecer("água", quantidade, MAX_AGUA);
    }

    public void abastecerShampoo(double quantidade) {
        abastecer("shampoo", quantidade, MAX_SHAMPOO);
    }

    //Método private pois ele só é usado dentro da própria classe;
    private void abastecer(String tipo, double quantidade, double capacidadeMaxima) {
        if (quantidade <= 0 || quantidade > 2) {
            System.out.println("Você pode abastecer até 2 litros de " + tipo + " por vez.");
            return;
        }

        double atual = tipo.equals("água") ? agua : shampoo;
        if (atual + quantidade > capacidadeMaxima) {
            System.out.println("Capacidade máxima de " + tipo + " atingida!");
            return;
        }

        if (tipo.equals("água"))
            agua += quantidade;
        else
            shampoo += quantidade;

        System.out.println("Abastecido " + quantidade + " litros de " + tipo + ".");
    }

    public void verificarAgua() {
        System.out.println("Água : " + this.agua);
    }

    public void verificarShampoo() {
        System.out.println("Shampoo: " + this.shampoo);
    }

    public void verificarPetBanho() {
        if (this.maquinaEmUso) {
            System.out.println("Há um pet no banho!");
        } else {
            System.out.println("Não há nenhum pet no banho!");
        }
    }

    public void colocarPetMaquina(Pet pet) {
        if (this.maquinaEmUso) {
            System.out.println("A maquina já está em uso no momento");
        } else if (!this.maquinaEmUso) {
            System.out.println("Seu pet foi posto na maquina!");
            this.maquinaEmUso = true;
        }
    }

    public void retirarPetMaquina(Pet pet) {
        if (this.maquinaEmUso && !pet.getLimpo()) {
            this.maquinaLimpa = false;
            this.maquinaEmUso = false;
            System.out.println("Pet retirado antes do banho. Voce deve limpar a maquina para continuar usando!");
        } else if (!this.maquinaEmUso) {
            System.out.println("Não há nenhum pet na maquina para retirar");
        } else {
            System.out.println("Parabens pela retirada!");
            this.maquinaEmUso = false;
            pet.setLimpo();
        }
    }

    public void limparMaquina() {
        if (maquinaEmUso) {
            System.out.println("A máquina está em uso. Aguarde o fim do banho para limpá-la.");
            return;
        }

        if (maquinaLimpa) {
            System.out.println("A máquina já está limpa.");
            return;
        }

        if (agua < 3 || shampoo < 1) {
            System.out.println("Níveis insuficientes para limpeza (mínimo: 3L água e 1L shampoo).");
            return;
        }

        agua -= 3;
        shampoo -= 1;
        maquinaLimpa = true;
        System.out.println("Máquina limpa com sucesso!");
    }
}
