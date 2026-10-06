import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import java.sql.Connection;
import java.sql.PreparedStatement;

public class TelaCadastro {

    public static void main(String[] args) {

        JFrame janela = new JFrame("Cadastro de Alunos");

        JLabel labelNome = new JLabel("Nome:");
        JTextField campoNome = new JTextField();

        JLabel labelIdade = new JLabel("Idade:");
        JTextField campoIdade = new JTextField();

        JLabel labelNota = new JLabel("Nota:");
        JTextField campoNota = new JTextField();

        JButton botaoCadastrar = new JButton("CADASTRAR");

        labelNome.setBounds(30, 30, 80, 25);
        campoNome.setBounds(100, 30, 200, 25);
        labelIdade.setBounds(30, 70, 80, 25);
        campoIdade.setBounds(100, 70, 200, 25);
        labelNota.setBounds(30, 110, 80, 25);
        campoNota.setBounds(100, 110, 200, 25);
        botaoCadastrar.setBounds(100, 160, 120, 30);

        botaoCadastrar.addActionListener(e -> {
            String sql = "INSERT INTO alunos (nome, idade, nota) VALUES (?, ?, ?)";
            try (Connection conn = Conexao.conectar();
                 PreparedStatement stmt = conn.prepareStatement(sql)) {

                String nome = campoNome.getText().trim();
                if (nome.isEmpty()) {
                    JOptionPane.showMessageDialog(janela, "Informe o nome.");
                    return;
                }
                int idade = Integer.parseInt(campoIdade.getText().trim());
                double nota = Double.parseDouble(
                        campoNota.getText().trim().replace(",", "."));

                stmt.setString(1, nome);
                stmt.setInt(2, idade);
                stmt.setDouble(3, nota);
                stmt.executeUpdate();

                JOptionPane.showMessageDialog(janela, "Aluno cadastrado com sucesso!");
                campoNome.setText("");
                campoIdade.setText("");
                campoNota.setText("");

            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(janela, "Idade e nota devem ser números.");
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(janela, "Erro ao cadastrar: " + ex.getMessage());
                ex.printStackTrace();
            }
        });

        janela.add(labelNome);
        janela.add(campoNome);
        janela.add(labelIdade);
        janela.add(campoIdade);
        janela.add(labelNota);
        janela.add(campoNota);
        janela.add(botaoCadastrar);

        janela.setSize(360, 250);
        janela.setLayout(null);
        janela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        janela.setLocationRelativeTo(null);
        janela.setVisible(true);
    }
}