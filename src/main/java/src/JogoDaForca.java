/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package src;

/**
 *
 * @author Gabri
 */

public class JogoDaForca {
    private String palavraEscolhida;
    private String palavraAdivinhada;
    private int tentativasRestantes;
    private boolean fimDeJogo;

    public JogoDaForca(String palavra) {
        palavraEscolhida = palavra;
        palavraAdivinhada = new String(new char[palavra.length()]).replace('\0', '_');
        tentativasRestantes = 6;
        fimDeJogo = false;
    }

    public boolean isFimDeJogo() {
        return fimDeJogo;
    }

    public boolean isVitoria() {
        return !palavraAdivinhada.contains("_");
    }

    public String getPalavraAdivinhada() {
        return palavraAdivinhada;
    }

    public int getTentativasRestantes() {
        return tentativasRestantes;
    }

    public void diminuiTentativasRestantes() {
        tentativasRestantes--;
        if (tentativasRestantes == 0) {
            fimDeJogo = true;
        }
    }

    public void atualizaPalavraAdivinhada(char letra) {
        for (int i = 0; i < palavraEscolhida.length(); i++) {
            if (palavraEscolhida.charAt(i) == letra) {
                palavraAdivinhada = palavraAdivinhada.substring(0, i) + letra + palavraAdivinhada.substring(i + 1);
            }
        }

        if (!palavraAdivinhada.contains("_")) {
            fimDeJogo = true;
        }
    }
}
