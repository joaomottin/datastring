import java.time.LocalDate; // Importa a classe LocalDate para trabalhar com datas.

public class App {
    public static void main(String[] args) throws Exception { // Método principal que inicia a execução do programa.

        // Criação de um objeto da classe Pessoa, com nome, sobrenome, email e data de nascimento.
        Pessoa pessoa = new Pessoa("João", "Mottin", "teste@teste", LocalDate.parse("2006-07-06"));

        // Exibe as informações iniciais da pessoa (incluindo idade calculada e email inválido).
        System.out.println(pessoa.getInformacoes());

        // Tenta adicionar um novo email válido.
        pessoa.adicionarEmail("teste@teste.com");

        // Exibe as informações novamente, agora com o email atualizado.
        System.out.println(pessoa.getInformacoes());
    }
}
