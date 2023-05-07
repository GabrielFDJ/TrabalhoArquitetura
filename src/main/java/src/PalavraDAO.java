/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package src;

/**
 *
 * @author Gabri
 */
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PalavraDAO {
    private Connection conn;
    List<String> palavras = Arrays.asList("java", "teste");

    public PalavraDAO() {
        try {
            String dbUrl = "jdbc:mysql://db:3306/jogoforca";
            String dbUser = "jogo";
            String dbPassword = "jogo123";
            conn = DriverManager.getConnection(dbUrl, dbUser, dbPassword);
        } catch (SQLException e) {
            System.err.println("Erro ao conectar ao banco de dados: " + e.getMessage());
        }
    }

    public List<String> recuperarPalavras() {
        List<String> palavras = new ArrayList<>();
        try {
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT palavra FROM palavras");
            while (rs.next()) {
                palavras.add(rs.getString("palavra"));
            }
            stmt.close();
        } catch (SQLException e) {
            System.err.println("Erro ao recuperar palavras: " + e.getMessage());
        }
        return palavras;
    }

    public void adicionarPalavra(String palavra) {
        try {
            PreparedStatement pstmt = conn.prepareStatement(
                    "INSERT INTO palavras (palavra) VALUES (?)");
            pstmt.setString(1, palavra);
            pstmt.executeUpdate();
            pstmt.close();
        } catch (SQLException e) {
            System.err.println("Erro ao adicionar palavra: " + e.getMessage());
        }
    }

	public List<String> getPalavras() {
		return palavras;
	}

	public void setPalavras(List<String> palavras) {
		this.palavras = palavras;
	}
    
    
}
