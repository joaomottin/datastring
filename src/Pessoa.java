import java.time.LocalDate;
import java.time.Period;

public class Pessoa {
    private String nome, sobrenome, email;
    private LocalDate dataNasc;

    public Pessoa(String nome, String sobrenome,String email, LocalDate dataNasc) { //Constructor
        this.nome = nome;
        this.sobrenome = sobrenome;
        adicionarEmail(email);
        this.dataNasc = dataNasc;
    }  

    private int idade(){
        LocalDate dataAtual = LocalDate.now();
        int idade = dataAtual.getYear() - dataNasc.getYear();

            if(dataAtual.getMonthValue()<dataNasc.getMonthValue() || (dataAtual.getMonthValue()==dataNasc.getMonthValue())  && (dataAtual.getDayOfMonth() <dataNasc.getDayOfMonth())){
                idade--;
            }

        //return idade;
        Period periodo = Period.between(dataNasc, dataAtual);
        return periodo.getYears();
    }



    private boolean validaEmail(String email){ //Esse metodo é necessario pois é preciso VALIDAR antes de adicionar, caso contrario se mostra inutil a função.
        return email.contains("@") && email.contains(".") && email.indexOf("@") <email.lastIndexOf("."); //Pega o index (posição) do @ e verifica, se o ULTIMO . for antes do @, é invalido
    }

    public void adicionarEmail(String email){
        if(validaEmail(email)) this.email=email; //Se o email for válido, ele adiciona.
    }


    public String getInformacoes(){
        return "Informações de "+ nome + " " + sobrenome + " " + email + " " + idade() + " anos."; 
    }




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

    @Override
    public String toString() {
        return "Pessoa [nome=" + nome + ", sobrenome=" + sobrenome + ", email=" + email + ", dataNasc=" + dataNasc
                + "]";
    }
        
}
