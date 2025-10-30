package Repository;

import Classes.Produto;
import java.sql.*;

public class ProdutoRepository {

    public static int inserir(Produto produto) throws SQLException {
        String sql = "INSERT INTO Produto (nome, preco, quantidade, marca, tipoProduto) VALUES (?, ?, ?, ?)";
        Connection conn = Conexao.conectar();
        PreparedStatement stmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);

        stmt.setString(1, produto.getNome());
        stmt.setDouble(2, produto.getPreco());
        stmt.setInt(3, produto.getQuantidade());
        stmt.setString(4, produto.getMarca());
        stmt.setString(5,produto.getTipoProduto());

        stmt.executeUpdate();

        ResultSet rs = stmt.getGeneratedKeys();
        int idGerado = 0;
        if (rs.next()) {
            idGerado = rs.getInt(1);
        }

        rs.close();
        stmt.close();
        conn.close();

        return idGerado;
    }
}
