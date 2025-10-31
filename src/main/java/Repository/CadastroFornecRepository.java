package Repository;

import Classes.Fornecedor;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class CadastroFornecRepository {


        public static void inserir(Fornecedor fornecedor)throws SQLException {
            String sql = "INSERT INTO CadastroFornecedor(nome, cnpj,telefone, email, endereco, cidade, estado, senha)VALUES(?,?,?,?,?,?,?,?)";
            Connection conn = Conexao.conectar();
            PreparedStatement stmt = conn.prepareStatement(sql);

            stmt.setString(1, fornecedor.getNome());
            stmt.setString(2, fornecedor.getCnpj());
            stmt.setString(3, fornecedor.getTelefone());
            stmt.setString(4, fornecedor.getEmail());
            stmt.setString(5, fornecedor.getEndereco());
            stmt.setString(6, fornecedor.getCidade());
            stmt.setString(7, fornecedor.getEstado());
            stmt.setString(8, fornecedor.getSenha());

            stmt.executeUpdate();

            stmt.close();
            conn.close();

        }
    }

