import java.sql.Date;
import java.time.LocalDate;
public class CadastroUsuario {
    // variáveis de dados para cadastro dos usuários
    private String nome;
    private String sobrenome;
    private String telefone;
    private String email;
    private String password;
    private Date dataNascimento;
    private String cpf;
    private Endereco endereco;

    // Construtor personalizado para inicializar os campos
    public CadastroUsuario(String nome, String sobrenome, String telefone,
                           String email, String password, LocalDate dataNascimento,
                           String cpf, Endereco endereco) {
        this.nome = nome;
        this.sobrenome = sobrenome;
        this.telefone = telefone;
        this.email = email;
        this.password = password;
        this.dataNascimento = Date.valueOf(dataNascimento);
        this.cpf = cpf;
        this.endereco = endereco;
    }


    // getters and setters
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

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Date getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(LocalDate dataNascimento) {
        this.dataNascimento = java.sql.Date.valueOf(dataNascimento);
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public Endereco getEndereco() {
        return endereco;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }

    public String getCep() {
        return this.endereco.getCep();
    }


}
