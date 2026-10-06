import java.sql.Connection;

import java.sql.ResultSet;

import java.sql.Statement;

 

public class VerificarTabela {

 

    public static void main(String[] args) {

 

        String sql = "PRAGMA table_info(alunos)";

 

        try (Connection conn = Conexao.conectar();

             Statement stmt = conn.createStatement();

             ResultSet rs = stmt.executeQuery(sql)) {

 

            System.out.println("Estrutura da tabela alunos:");

 

            while (rs.next()) {

 

                System.out.println(

                    rs.getInt("cid") + " - " +

                    rs.getString("name") + " - " +

                    rs.getString("type")

                );

            }

 

        } catch (Exception e) {

            e.printStackTrace();

        }

    }

}