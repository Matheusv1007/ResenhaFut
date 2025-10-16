package Repository;

import Classes.Camisa;

import java.sql.*;

public class CamisaRepository {
    public static void inserir(Camisa camisa)throws SQLException{

       String sqlProduto = "INSERT INTO Produtos(nome, preco, quantidade, marca, tipoProduto) VALUES(?,?,?,?)";
       Connection conn = Conexao.conectar();

       PreparedStatement stmtProduto = conn.prepareStatement(sqlProduto, Statement.RETURN_GENERATED_KEYS);

       stmtProduto.setString(1, camisa.getNome());
       stmtProduto.setDouble(2,camisa.getPreco());
       stmtProduto.setString(3,camisa.getMarca());
       stmtProduto.setInt(4,camisa.getQuantidade());
       stmtProduto.setString(5, camisa.getTipoProduto());
       stmtProduto.executeUpdate();

       ResultSet rs = stmtProduto.getGeneratedKeys();
       int idProduto = 0;
        if (rs.next()) {
            idProduto = rs.getInt(1);
        }


        String sqlCamisa = "INSERT INTO Camisa(id_produto, material, timeCamisa, tamanho)VALUES(?,?,?,?)";

        PreparedStatement stmtCamisa = conn.prepareStatement(sqlCamisa);

        stmtCamisa.setInt(1,idProduto);
        stmtCamisa.setString(2,camisa.getMaterial());
        stmtCamisa.setString(3, camisa.getTimeCamisa());
        stmtCamisa.setString(4,camisa.getTamanho());
        stmtCamisa.executeUpdate();

        conn.close();

    }
}
