import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexao {
    public static Connection conectar() throws SQLException {
        String url = "jdbc:sqlite:banco/alunos.db";
        return DriverManager.getConnection(url);
    }
}