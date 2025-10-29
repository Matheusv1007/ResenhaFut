package Repository;

import java.sql.*;

public class Conexao {

    private static final String URL = "jdbc:sqlite:Resenha_Fut.db";

    public static Connection conectar() throws SQLException {
        Connection con = DriverManager.getConnection(URL);
        try (Statement stmt = con.createStatement())
        {
            stmt.execute("PRAGMA foreign_keys = ON");
        }
        criarTabelas(con);
        return con;
    }

    public static void criarTabelas(Connection con) throws SQLException {
        Statement stmt = con.createStatement();

        String sqlCadastro = """
            CREATE TABLE IF NOT EXISTS Cadastro(
                id_cadastro INTEGER PRIMARY KEY AUTOINCREMENT,
                nome TEXT NOT NULL,
                email TEXT NOT NULL,
                senha TEXT NOT NULL,
                idade INTEGER NOT NULL,
                cpf TEXT NOT NULL
            )
        """;

        String sqlProduto = """
            CREATE TABLE IF NOT EXISTS Produto (
                id_produto INTEGER PRIMARY KEY AUTOINCREMENT,
                nome TEXT NOT NULL,
                tipoProduto TEXT NOT NULL,
                preco NUMERIC(10,2) NOT NULL
            )
        """;

        String sqlCamisa = """
            CREATE TABLE IF NOT EXISTS Camisa (
                id_camisa INTEGER PRIMARY KEY AUTOINCREMENT,
                id_produto INTEGER NOT NULL,
                material TEXT NOT NULL,
                timeCamisa TEXT NOT NULL,
                tamanho TEXT NOT NULL,
                FOREIGN KEY (id_produto) REFERENCES Produto(id_produto)
            )
        """;

        String sqlBola = """
            CREATE TABLE IF NOT EXISTS Bola (
                id_bola INTEGER PRIMARY KEY AUTOINCREMENT,
                id_produto INTEGER NOT NULL,
                cor TEXT NOT NULL,
                modelo TEXT NOT NULL,
                tipo TEXT NOT NULL,
                FOREIGN KEY (id_produto) REFERENCES Produto(id_produto)
            )
        """;

        String sqlChuteira = """
            CREATE TABLE IF NOT EXISTS Chuteira (
                id_chuteira INTEGER PRIMARY KEY AUTOINCREMENT,
                id_produto INTEGER NOT NULL,
                tamanho INTEGER NOT NULL,
                tipo TEXT NOT NULL,
                cor TEXT NOT NULL,
                FOREIGN KEY (id_produto) REFERENCES Produto(id_produto)
            )
        """;

        stmt.executeUpdate(sqlProduto);
        stmt.executeUpdate(sqlCamisa);
        stmt.executeUpdate(sqlBola);
        stmt.executeUpdate(sqlChuteira);
        stmt.executeUpdate(sqlCadastro);
    }

    public static boolean executarSql(String sql, Object... parametros) {
        try (Connection conn = conectar();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            for (int i = 0; i < parametros.length; i++) {
                Object param = parametros[i];
                if (param instanceof String) stmt.setString(i + 1, (String) param);
                else if (param instanceof Integer) stmt.setInt(i + 1, (Integer) param);
                else if (param instanceof Double) stmt.setDouble(i + 1, (Double) param);
            }

            stmt.executeUpdate();
            return true;

        } catch (SQLException e) {
            System.out.println("Erro ao executar SQL: " + e.getMessage());
        }
        return false;
    }

    public static ResultSet executarQuery(String sql, Connection conn) throws SQLException {
        Statement stmt = conn.createStatement();
        return stmt.executeQuery(sql);
    }
}
