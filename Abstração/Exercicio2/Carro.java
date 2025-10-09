public class Carro {
    private boolean ligado;
    private int velocidade;
    private int marcha;

    //Definição dos valores minimos de maximo de cada marcha; A marcha se refere ao index dos valores dos vetores
    private final int[] velocidade_max = {0 , 20 , 40 , 60 , 80 , 100 , 120};
    private final int[] velocidade_min = {0 , 0 , 21 , 41 , 61 , 81 , 101};

    public Carro() {
        this.ligado = false;
        this.velocidade = 0;
        this.marcha = 0;
    }

    public boolean getLigado() {
        return this.ligado;
    }

    public void ligar() {
        if (!this.ligado) {
            this.ligado = true;
            System.out.println("Seu carro foi ligado.");
        }else{
            System.out.println("O carro já está ligado.");
        }
    }

    public void acelerar() {
        if(!this.ligado){
            System.out.println("Primeiro voce deve ligar o veiculo!");
            return;
        }
        if(this.marcha == 0){
            System.out.println("Voce nao pode acelerar no ponto morto");
            return;
        }

        //Defini as velocidades maximas e minimias de acordo com a marcha que o carro está
        int vmax = velocidade_max[this.marcha];
        int vmin = velocidade_min[this.marcha];

        if(this.velocidade <= vmax && this.velocidade >= vmin){
            this.velocidade++;
            System.out.println("Velocidade: "+this.velocidade+" km/h");
        }else{
            System.out.println("Suba a marcha para continuar acelerando!");
        }
    }

    public void freiar() {
        if(!this.ligado){
            System.out.println("Primeiro voce deve ligar o veiculo!");
            return;
        }
        if(this.marcha == 0){
            System.out.println("Voce nao pode freiar no ponto morto");
            return;
        }

        //Mesma ideia da aceleração com uma pincelada no if abaixo
        int vmax = velocidade_max[this.marcha];
        int vmin = velocidade_min[this.marcha];

        if(this.velocidade <= vmax + 1 && this.velocidade > vmin){
            this.velocidade--;
            System.out.println("Velocidade: "+this.velocidade+" km/h");
        }else{
            System.out.println("Desca a marcha para continuar freiando!");
        }
    }

    public void subirMarcha() {
        if(!ligado){
            System.out.println("Primeiro ligue o carro!");
            return;
        }
        if(marcha == 6){
            System.out.println("O carro já está na ultima marcha");
            return;
        }
        
        //O carro só pode trocar de marcha se estiver na velocidade maxima + 1, isso é considerado de acordo com a proposta do exercicio
        if(this.velocidade == velocidade_max[this.marcha] + 1 || (this.marcha == 0 && velocidade ==0)){
            this.marcha++;
            System.out.println("Marcha "+this.marcha+ " engatada!");
        }else{
            System.out.println("Ainda não é hora de trocar de marcha!");
        }


    }

    public void descerMarcha() {
        if(!ligado){
            System.out.println("Primeiro ligue o carro!");
            return;
        }
        if(marcha == 0){
            System.out.println("O carro já está na primeira marcha");
            return;
        }
        
        //Só é permitido descer de marcha quando a velocidade minima é atingida pelo veiculo
        if(this.velocidade == velocidade_min[this.marcha]){
            this.marcha--;
            System.out.println("Marcha "+this.marcha+ " engatada!");
        }else{
            System.out.println("Ainda não é hora de trocar de marcha!");
        }
    }

    public void desligar() {
        if(!this.ligado){
            System.out.println("O carro já está desligado.");
        }else if(this.marcha == 0 && this.velocidade == 0){
            this.ligado = false;
            System.out.println("O carro foi desligado com segurança!");
        }else{
            System.out.println("Voce deve parar o carro e colocar em ponto morto antes de desligar!");
        }
    }

    public void virarEsquerda(){
        if(!this.ligado){
            System.out.println("Voce deve ligar o carro primeiro");
            return;
        }
        if(this.marcha == 1 || this.marcha == 2){
            System.out.println("O carro virou a esquerda!");
        }
        
    }
    public void virarDireita(){
        if(!this.ligado){
            System.out.println("Voce deve ligar o carro primeiro");
            return;
        }
        if(this.marcha == 1 || this.marcha == 2){
            System.out.println("O carro virou a direita!");
        }
        
    }
    public void status(){
    System.out.println("Ligado: " + this.ligado + " | Marcha: " + this.marcha + " | Velocidade: " + this.velocidade + " km/h");
}

}
