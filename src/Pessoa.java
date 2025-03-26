import java.time.LocalDate; // Importa a classe LocalDate para trabalhar com datas.
import java.time.Period; // Importa a classe Period para calcular a diferença entre datas.

public class Pessoa {
    // Declaração dos atributos privados da classe Pessoa.
    private String nome, sobrenome, email;
    private LocalDate dataNasc; // Armazena a data de nascimento.

    // Construtor da classe que inicializa os atributos ao criar um objeto Pessoa.
    public Pessoa(String nome, String sobrenome, String email, LocalDate dataNasc) { 
        this.nome = nome;
        this.sobrenome = sobrenome;
        adicionarEmail(email); // Chama o método para validar e definir o email.
        this.dataNasc = dataNasc;
    }  

    // Método privado para calcular a idade da pessoa com base na data de nascimento.
    private int idade() {
        LocalDate dataAtual = LocalDate.now(); // Obtém a data atual do sistema.
        int idade = dataAtual.getYear() - dataNasc.getYear(); // Calcula a diferença de anos.

        // Verifica se ainda não chegou o mês ou o dia do aniversário neste ano.
        if (dataAtual.getMonthValue() < dataNasc.getMonthValue() || 
           (dataAtual.getMonthValue() == dataNasc.getMonthValue() && dataAtual.getDayOfMonth() < dataNasc.getDayOfMonth())) {
            idade--; // Se ainda não fez aniversário este ano, subtrai 1 da idade.
        }

        // Alternativa mais precisa para calcular a idade usando a classe Period.
        Period periodo = Period.between(dataNasc, dataAtual);
        return periodo.getYears(); // Retorna a idade corretamente calculada.
    }

    // Método privado para validar se um e-mail é válido antes de adicioná-lo.
    private boolean validaEmail(String email) {
        // Verifica se contém "@" e "." e se o "@" vem antes do último "." no email.
        return email.contains("@") && email.contains(".") && email.indexOf("@") < email.lastIndexOf("."); 
    }

    // Método público para adicionar um email após validação.
    public void adicionarEmail(String email) {
        if (validaEmail(email)) this.email = email; // Se o email for válido, ele é salvo.
    }

    // Método para obter as informações da pessoa em formato de string.
    public String getInformacoes() {
        return "Informações de " + nome + " " + sobrenome + " " + email + " " + idade() + " anos."; 
    }

    // Métodos getters e setters para acessar e modificar os atributos da classe.

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSobrenome() {
        return sobrenome;
    }

    public void setSobrenome(String sobrenome) {
        this.sobrenome = sobrenome;
    }

    public String getEmail() {
        return email;
    }

    public LocalDate getDataNasc() {
        return dataNasc;
    }

    public void setDataNasc(LocalDate dataNasc) {
        this.dataNasc = dataNasc;
    }

    // Método toString para retornar uma representação textual do objeto.
    @Override
    public String toString() {
        return "Pessoa [nome=" + nome + ", sobrenome=" + sobrenome + ", email=" + email + ", dataNasc=" + dataNasc + "]";
    }
}
