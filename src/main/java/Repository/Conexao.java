package Repository;

import java.sql.*;

public class Conexao {

  /*  private static final String URL = "jdbc:sqlite:Resenha_Fut.db";

    public static Connection conectar() throws SQLException {
        Connection con = DriverManager.getConnection(URL);
        cirarTabelas(con);
        return con;
    }

    public static void cirarTabelas(Connection con) throws SQLException{

        Statement stmt = con.createStatement();

        String sqlProduto = """
                CREATE TABLE IF NOT EXISTS produtos (
                    id_Produto    INTEGER PRIMARY KEY AUTOINCREMENT,
                    Nome          TEXT NOT NULL,
                    Tipo          TEXT NOT NULL,
                    Preco         NUMERIC(10,2) NOT NULL,
                    Categoria     TEXT NOT NULL
                )
                """;

        String sqlCamisa = """
            CREATE TABLE IF NOT EXISTS Camisa (
                id_Camisa       INTEGER PRIMARY KEY AUTOINCREMENT,
                Material        TEXT    NOT NULL,
                TimeCamisa      TEXT NOT NULL,
                Tamanho         TEXT NOT NULL,
                Marca           TEXT NOT NULL,
                Preco           NUMERIC(10,2) NOT NULL
            )
        """;

        String sqlBola = """
            CREATE TABLE IF NOT EXISTS Bola (
                id_Bola         INTEGER PRIMARY KEY,
                Cor             TEXT NOT NULL,
                Marca           TEXT NOT NULL,
                Modelo          TEXT NOT NULL,
                Tipo            TEXT NOT NULL,
                Preco           NUMERIC(10,2) NOT NULL
            )
        """;

        String sqlChuteira = """
            CREATE TABLE IF NOT EXISTS Chuteira (
                id_Chuteira   INTEGER PRIMARY KEY,
                Marca           TEXT NOT NULL,
                Tamanho         INTEGER NOT NULL,
                Tipo            TEXT NOT NULL,
                Cor             TEXT NOT NULL,
                Preco           NUMERIC(10,2) NOT NULL
            )
        """;

        //O nome executeUpdate() pode parecer confuso, mas ele é usado para qualquer comando SQL que altere a estrutura ou os dados
        // Executa a criação de cada tabela
        stmt.executeUpdate(sqlProduto);
        stmt.executeUpdate(sqlCamisa);
        stmt.executeUpdate(sqlBola);
        stmt.executeUpdate(sqlChuteira);

    }

    // Metodo genérico para comandos SQL sem retorno
    // (DDL/DML: CREATE, INSERT, UPDATE, DELETE).
    public static boolean executarSql(String sql) {
        try{
            // Abre a conexão
            Connection conn = conectar();

            // Cria um Statement simples
            Statement stmt = conn.createStatement();

            // Executa o comando
            stmt.executeUpdate(sql);

            conn.close();

            return true;

        } catch (SQLException e) {
            System.out.println("Erro ao executar SQL: " + e.getMessage());
        }

        return false;
    }

    // Metodo genérico para SELECT

    // Não abrimos a conexão porque precisamos manter-la aberta enquanto o ResultSet estiver em uso.
    public static ResultSet executarQuery(String sql, Connection conn) throws SQLException {
        // Cria o Statement
        Statement stmt = conn.createStatement();

        // Executa o SQL genérico

        /*Retorna um ResultSet
        O ResultSet contém uma tabela retornada por uma consulta

        Você percorre as linhas uma por uma usando: resultSet.next();

        Você pode pegar o valor de cada coluna em cada linha usando:
        resultSet.get<tipodedados>("nome coluna");
        Exemplo: rs.getString("titulo")
        return stmt.executeQuery(sql);


    }

    */

}
