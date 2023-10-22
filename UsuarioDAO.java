import java.sql.*;

public class UsuarioDAO {
    private final String url = "jdbc:postgresql://localhost:5432/seu-bd";
    private final String user = "seu-usuario";
    private final String password = "sua-senha";

    public void inserirUsuario(CadastroUsuario usuario) {
        String query = "INSERT INTO usuarios (nome, sobrenome, telefone, email, senha, data_nascimento, cpf, cep, logradouro, numero_residencia, bairro, cidade, estado) " +
                "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        try (Connection connection = DriverManager.getConnection(url, user, password)) {
            connection.setAutoCommit(false); // Desativar o autoCommit

            try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
                preparedStatement.setString(1, usuario.getNome());
                preparedStatement.setString(2, usuario.getSobrenome());
                preparedStatement.setString(3, usuario.getTelefone());
                preparedStatement.setString(4, usuario.getEmail());
                String senhaCriptografada = EncriPass.hashPassword(usuario.getPassword());
                preparedStatement.setString(5, senhaCriptografada);
                preparedStatement.setDate(6, usuario.getDataNascimento());
                preparedStatement.setString(7, usuario.getCpf());
                preparedStatement.setString(8, usuario.getCep());
                Endereco endereco = usuario.getEndereco();
                preparedStatement.setString(9, endereco.getLogradouro());
                preparedStatement.setString(10, endereco.getNumeroResidencia());
                preparedStatement.setString(11, endereco.getBairro());
                preparedStatement.setString(12, endereco.getLocalidade());
                preparedStatement.setString(13, endereco.getUf());

                preparedStatement.executeUpdate();

                connection.commit(); // Realizar o commit manualmente
            } catch (SQLException e) {
                if (e.getSQLState().equals("23505")) { // Código para violação de restrição de chave única
                    System.out.println("Não é possível prosseguir! CPF já cadastrado!.");
                } else {
                    e.printStackTrace(); // Outras exceções SQL serão impressas para fins de depuração
                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
