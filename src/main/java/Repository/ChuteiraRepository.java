package Repository;

import Classes.Chuteira;

import java.sql.*;

public class ChuteiraRepository {

    public static void inserir(Chuteira chuteira) throws SQLException {

        String sqlProduto = "INSERT INTO Produto(nome, preco, quantidade, marca, tipoProduto) VALUES(?,?,?,?)";

        Connection conn = Conexao.conectar();

        PreparedStatement stmtProduto = conn.prepareStatement(sqlProduto, Statement.NO_GENERATED_KEYS);

        stmtProduto.setString(1, chuteira.getNome());
        stmtProduto.setDouble(2,chuteira.getPreco());
        stmtProduto.setInt(3,chuteira.getQuantidade());
        stmtProduto.setString(4,chuteira.getMarca());
        stmtProduto.setString(5,chuteira.getTipoProduto());
        stmtProduto.executeUpdate();

        ResultSet rs = stmtProduto.getGeneratedKeys();
        int idProduto = 0;
        if (rs.next()) {
            idProduto = rs.getInt(1);
        }

        String sqlChuteira = "INSERT INTO Chuteira (id_Produto, tamanho, tipo, cor) VALUES (?, ?, ?, ?)";
        PreparedStatement stmtChuteira = conn.prepareStatement(sqlChuteira);
        stmtChuteira.setInt(1, idProduto);
        stmtChuteira.setString(2, chuteira.getTamanho());
        stmtChuteira.setString(3, chuteira.getTipo());
        stmtChuteira.setString(4, chuteira.getCor());
        stmtChuteira.executeUpdate();

        conn.close();
    }
}
