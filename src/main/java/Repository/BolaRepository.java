package Repository;

import Classes.Bola;

import java.sql.*;

public class BolaRepository {

    public static void inserir(Bola bola)throws SQLException{

        String sqlProduto = "INSERT INTO Produto(nome, preco, quantidade, marca, tipoProduto) VALUES(?,?,?,?)";

        Connection conn = Conexao.conectar();

        PreparedStatement stmtProduto = conn.prepareStatement(sqlProduto, Statement.NO_GENERATED_KEYS);

        stmtProduto.setString(1, bola.getNome());
        stmtProduto.setDouble(2,bola.getPreco());
        stmtProduto.setInt(3,bola.getQuantidade());
        stmtProduto.setString(4,bola.getMarca());
        stmtProduto.setString(5,bola.getTipoProduto());
        stmtProduto.executeUpdate();

        ResultSet rs = stmtProduto.getGeneratedKeys();
        int idProduto = 0;
        if (rs.next()) {
            idProduto = rs.getInt(1);
        }

        String sqlBola = "INSERT INTO Bola(id_produto, cor,modelo,tipo) VALUES()?,?,?,? ";

        PreparedStatement stmtBola = conn.prepareStatement(sqlBola);

        stmtBola.setInt(1, idProduto);
        stmtBola.setString(2,bola.getCor());
        stmtBola.setString(3, bola.getModelo());
        stmtBola.setString(4,bola.getTipo());
        stmtBola.executeUpdate();

        conn.close();

    }
}
