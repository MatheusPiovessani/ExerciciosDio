package HerançaEPolimorfismo.Exercicio2;

import java.util.regex.Pattern;

public class Funcionario {
    protected String nome;
    protected String email;
    protected String senha;
    protected boolean login;
    protected boolean isAdministrador = false;

    protected static final Pattern EMAIL_PATTERN = Pattern.compile("^[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,}$");

    public Funcionario(String nome, String email, String senha) {
        this.nome = nome;
        this.senha = senha;
        setEmail(email);
    }

    public void realizarLogin() {
        if(this.login){
            System.out.println("Vôce ja realizou o login!");
            return;
        }
        System.out.println("Login realizado com sucesso!");
        this.login = true;
    }

    public void realizarLogoff() {
        if(!this.login){
            System.out.println("Vôce ja realizou o logoff!");
            return;
        }
        System.out.println("Logoff realizado com sucesso!");
        this.login = false;
    }
    public void setEmail(String email){
        //Verifica se o email passado por parametro está dentro dos conformes definidos nas propriedades da clasee
        if(email == null || !EMAIL_PATTERN.matcher(email).matches()){
            throw new IllegalArgumentException("Email invalido!");
        }
        this.email = email;
    }

    public void alterarDados(String tipo, String novoValor){
        if("nome".equalsIgnoreCase(tipo)){
            if(!novoValor.equalsIgnoreCase(this.nome)){
                this.nome = novoValor;
                System.out.println("Nome alterado com sucesso!");
            } else {
                System.out.println("Você não pode trocar para o mesmo nome");
            }
        } else if("email".equalsIgnoreCase(tipo)){
            if(!novoValor.equalsIgnoreCase(this.email) && EMAIL_PATTERN.matcher(novoValor).matches()){
                this.email = novoValor;
                System.out.println("Email alterado com sucesso!");
            } else {
                System.out.println("Email inválido ou igual ao atual");
            }
        }
    }

    public void alterarSenha(String senhaNova) {
        if (senhaNova.equalsIgnoreCase(this.senha)) {
            System.out.println("As senhas são iguais. Senha nao alterada");
            return;
        }
        this.senha = senhaNova;
        System.out.println("Senha alterada com sucesso!");
    }
}