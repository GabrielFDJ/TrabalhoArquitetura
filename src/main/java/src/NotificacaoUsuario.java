/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package src;

import org.primefaces.PrimeFaces;

/**
 *
 * @author Gabri
 */
public class NotificacaoUsuario {

    public String mensagemInicial() {       
        return "\nAqui você verá o seu progresso:";
    }

    public String mensagemContinuacaoJogo(){
        return "\nPara continuar jogando apenas digite outra letra abaixo";
    }

    public String tentativasAcertarPalavra(JogoDaForca jogoDaForca) {
        return "\nTentativas restantes: " + jogoDaForca.getTentativasRestantes();
    }

    public String mensagemLetraEncontrada(char letraUsuario, JogoDaForca jogoDaForca) {
        return "\nAqui você verá o seu progresso:" + "\nTentativas restantes: " + jogoDaForca.getTentativasRestantes()+ "\nA letra " + letraUsuario + " foi encontrada na palavra!"
        + "\nPalavra: " + jogoDaForca.getPalavraAdivinhada();
    }
    
    public String mensagemLetraNaoEncontrada(char letraUsuario, JogoDaForca jogoDaForca) {
        return "\nAqui você verá o seu progresso:" + "\nTentativas restantes: " + jogoDaForca.getTentativasRestantes()+ "\nA letra " + letraUsuario + " não foi encontrada na palavra..."
        + "\nPalavra: " + jogoDaForca.getPalavraAdivinhada();
    }

    public String mensagemVitoria(String palavraEscolhida) {
        return "\nParabéns, você ganhou! A palavra era: " + palavraEscolhida;
    }

    public String mensagemDerrota(String palavraEscolhida) {
        return "Que pena, você perdeu... A palavra era: " + palavraEscolhida;
    }

}
