import java.sql.Connection;

import java.sql.Statement;

 

public class CriarTabela {

 

    public static void main(String[] args) {

 

        String sql = """

            CREATE TABLE IF NOT EXISTS alunos (

                id INTEGER PRIMARY KEY AUTOINCREMENT,

                nome TEXT NOT NULL,

                idade INTEGER NOT NULL,

                nota REAL NOT NULL

            )

            """;

 

        try (Connection conn = Conexao.conectar();

             Statement stmt = conn.createStatement()) {

 

            stmt.execute(sql);

 

            System.out.println("Tabela alunos criada com sucesso!");

 

        } catch (Exception e) {

            System.out.println("Erro ao criar tabela:");

            e.printStackTrace();

        }

    }

}