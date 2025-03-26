import java.time.LocalDate;

public class App {
    public static void main(String[] args) throws Exception {


    Pessoa pessoa = new Pessoa("João", "Mottin", "teste@teste", LocalDate.parse("2006-07-06"));

    System.out.println(pessoa.getInformacoes());
    pessoa.adicionarEmail("teste@teste.com");
    System.out.println(pessoa.getInformacoes());
    }
}
