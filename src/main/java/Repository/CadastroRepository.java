package Repository;

import Classes.Cadastro;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class CadastroRepository {

    public static void inserir(Cadastro cadastro) throws SQLException {
        String sql = "INSERT INTO Cadastro (nome, email, senha, idade, cpf) VALUES (?, ?, ?, ?, ?)";
        Connection conn = Conexao.conectar();
        PreparedStatement stmt = conn.prepareStatement(sql);

        stmt.setString(1, cadastro.getNome());
        stmt.setString(2, cadastro.getEmail());
        stmt.setString(3, cadastro.getSenha());
        stmt.setInt(4, cadastro.getIdade());
        stmt.setString(5, cadastro.getCpf());

        stmt.executeUpdate();

        stmt.close();
        conn.close();
    }

}
