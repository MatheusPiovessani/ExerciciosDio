package InterfacesELambda.Exercicio1;
import java.util.Arrays;
import java.util.List;

public class MainMensagem {
    public static void main(String[] args){

        //Essa forma abaixo é a mais otimizada para realizar o processo, mas não é a unica;
        //Inves de ter feito em forma de lista e percorrido com foreach, eu poderia ter feito uma por uma
        //e ao fim enviar uma de cada vez.
        List<Menssageiro> lista = Arrays.asList(
        msg -> System.out.println("Enviando SMS: " + msg),
        msg -> System.out.println("Enviando E-mail: "+msg),
        msg -> System.out.println("Enviado para Redes Sociais: "+msg),
        msg -> System.out.println("Enviando para Whatsapp: "+msg)
        );

        String msg = "Desconto de 50%";

        //Para cada menbro 's' da lista "lista", enviar a msg acima;
        //'s' é um nome generico 
        lista.forEach(s -> s.enviar(msg));
    }
}  
