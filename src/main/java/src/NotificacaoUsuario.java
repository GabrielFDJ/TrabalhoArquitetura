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

    public String listaOpcoes() {
        String mensagemOpcoes = "\nAqui você verá o seu progresso:";
        return mensagemOpcoes;
    }

    /*public String opcaoEscolhida(int opcao, boolean jogoIniciou) {
        String mensagemOpcaoEscolhida = "";
        if (opcao == 1 && !jogoIniciou) {
            mensagemOpcaoEscolhida = "\nOpção " + opcao + " escolhida"
                    + "\nProssiga digitando uma letra abaixo";
        }
        if (opcao == 2 && !jogoIniciou) {
            mensagemOpcaoEscolhida = "\nOpção " + opcao + " escolhida"
                    + "\nProssiga digitando a nova palavra abaixo";
        }
        if (jogoIniciou) {
            mensagemOpcaoEscolhida = "\nTermine o jogo em andamento para escolher outra opção!";
        }
        return mensagemOpcaoEscolhida;
    }*/
    
    public String mensagemContinuacaoJogo(){
        return "\nPara continuar jogando apenas digite outra letra abaixo";
    }

    public String tentativasAcertarPalavra(JogoDaForca jogoDaForca) {
        return "\nTentativas restantes: " + jogoDaForca.getTentativasRestantes();
    }

    public String mensagemLetraEncontrada(char letraUsuario, JogoDaForca jogoDaForca) {
        return "\nA letra " + letraUsuario + " foi encontrada na palavra!" + "\nPalavra: " + jogoDaForca.getPalavraAdivinhada();
    }
    
    public String mensagemLetraNaoEncontrada(char letraUsuario, JogoDaForca jogoDaForca) {
        return "\nA letra " + letraUsuario + " não foi encontrada na palavra..."  + "\nPalavra: " + jogoDaForca.getPalavraAdivinhada();
    }

    public String mensagemVitoria(String palavraEscolhida) {
        return "\nParabéns, você ganhou! A palavra era: " + palavraEscolhida;
    }

    public String mensagemDerrota(String palavraEscolhida) {
        return "Que pena, você perdeu... A palavra era: " + palavraEscolhida;
    }

}
