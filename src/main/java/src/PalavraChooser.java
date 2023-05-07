/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package src;

/**
 *
 * @author Gabri
 */
import java.util.List;
import java.util.Random;

public class PalavraChooser {
    private List<String> palavras;
    private Random random;
    private PalavraDAO dao;

    public PalavraChooser() {
        dao = new PalavraDAO();
        palavras = dao.palavras;
        random = new Random();
    }

    public void adicionarPalavra(String palavra) {
        dao.adicionarPalavra(palavra);
        palavras.add(palavra);
    }

    public String chooseWord() {
        int indice = random.nextInt(palavras.size());
        return palavras.get(indice);
    }
}
