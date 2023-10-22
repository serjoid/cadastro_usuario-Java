import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        Scanner leitura = new Scanner(System.in);

        System.out.println("APLICAÇÃO DE TESTE - CADASTRO DE USUÁRIO JAVA");
        System.out.println("Nome: ");
        String nome = leitura.nextLine();

        System.out.println("Sobrenome: ");
        String sobrenome = leitura.nextLine();

        System.out.println("Telefone com DDD: ");
        String telefone = "+55" + leitura.nextLine();

        System.out.println("Email: ");
        String email = leitura.nextLine();
        if (!ValidaEmail.isEmailValido(email)) {
            System.out.println("Endereço de e-mail inválido. Por favor, insira um endereço de e-mail válido.");
            return;
        }

        System.out.println("Senha: ");
        String senha = leitura.nextLine();

        System.out.println("Dia de nascimento (DD): ");
        String diaNascimentoString = leitura.next();
        while (diaNascimentoString.length() != 2 || !diaNascimentoString.matches("\\d+")) {
            System.out.println("Dia de nascimento inválido. Insira novamente (DD): ");
            diaNascimentoString = leitura.next();
        }
        int diaNascimento = Integer.parseInt(diaNascimentoString);

        System.out.println("Mês de nascimento (MM): ");
        String mesNascimentoString = leitura.next();
        while (mesNascimentoString.length() != 2 || !mesNascimentoString.matches("\\d+")) {
            System.out.println("Mês de nascimento inválido. Insira novamente (MM): ");
            mesNascimentoString = leitura.next();
        }
        int mesNascimento = Integer.parseInt(mesNascimentoString);

        System.out.println("Ano de nascimento (AAAA): ");
        String anoNascimentoString = leitura.next();
        while (anoNascimentoString.length() != 4 || !anoNascimentoString.matches("\\d+")) {
            System.out.println("Ano de nascimento inválido. Insira novamente (AAAA): ");
            anoNascimentoString = leitura.next();
        }
        int anoNascimento = Integer.parseInt(anoNascimentoString);

        LocalDate dataNascimento = LocalDate.of(anoNascimento, mesNascimento, diaNascimento);
        leitura.nextLine(); // Limpar o buffer após a leitura de inteiros

// Verificação da data de nascimento
        LocalDate dataAtual = LocalDate.now();
        LocalDate dataNascimentoVerificada = dataNascimento.plusYears(18);
        if (dataNascimentoVerificada.isAfter(dataAtual)) {
            System.out.println("Você deve ter pelo menos 18 anos para se cadastrar. Por favor, insira uma data de nascimento válida.");
            return;
        }

        System.out.println("CPF: ");
        String cpf = leitura.nextLine();
// Limitar a entrada do CPF para 11 caracteres
        cpf = cpf.substring(0, Math.min(cpf.length(), 11));
        if (!ValidaCPF.validarCPF(cpf)) {
            System.out.println("CPF inválido. Por favor, insira um CPF válido.");
            return;
        }

        System.out.println("CEP: ");
        String cep = leitura.nextLine();
        cep = cep.length() > 8 ? cep.substring(0, 8) : cep;

// Código para buscar e definir valores para cep, tipoLogradouro, logradouro, bairro, cidade e estado usando a API VIA-CEP
        Endereco endereco = null;
        try {
            endereco = ViaCEPIntegration.buscarEnderecoPorCEP(cep);
            System.out.println(endereco.getLogradouro());
            System.out.println(endereco.getBairro());
            System.out.println(endereco.getLocalidade());
            System.out.println(endereco.getUf());
            System.out.println("Número de residência: ");
            String numeroResidencia = leitura.nextLine(); // Captura o número da residência
            endereco.setNumeroResidencia(numeroResidencia); // Define o número da residência no objeto de endereço
            CadastroUsuario usuario = new CadastroUsuario(nome, sobrenome, telefone, email, senha, dataNascimento, cpf, endereco);
            // Restante do seu código para inserir o usuário no banco de dados usando UsuarioDAO
            // ...
        } catch (Exception e) {
            System.out.println("Erro ao buscar o CEP. Insira manualmente os dados do endereço.");
        }


// Verificando se o objeto endereco foi inicializado corretamente
        if (endereco != null) {
            // Instanciando o usuário com os dados fornecidos
            CadastroUsuario usuario = new CadastroUsuario(nome, sobrenome, telefone, email, senha, dataNascimento, cpf, endereco);

            // Inserindo o usuário no banco de dados usando o UsuarioDAO
            UsuarioDAO usuarioDAO = new UsuarioDAO();
            usuarioDAO.inserirUsuario(usuario);
        }
    }
}
