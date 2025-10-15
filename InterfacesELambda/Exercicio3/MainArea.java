package InterfacesELambda.Exercicio3;


public class MainArea{
    public static void main(String[] args){

    calculaArea areaQuadrado = lado -> System.out.println("Área do quadrado: " + (lado[0]*lado[0]));
    calculaArea areaRetangulo = lado -> System.out.println("Área do retangulo : "+ (lado[0] * lado[1]));
    calculaArea areaCirculo = raio -> System.out.println("Área do circulo: "+ ((raio[0]*raio[0])*Math.PI));

    areaQuadrado.calcula(1);
    areaRetangulo.calcula(1, 2);
    areaCirculo.calcula(1);



    }
}
