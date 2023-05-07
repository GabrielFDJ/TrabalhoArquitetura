/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Bean;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import org.primefaces.PrimeFaces;
import src.JogoDaForca;
import src.LetterChecker;
import src.NotificacaoUsuario;
import src.PalavraChooser;

/**
 *
 * @author Gabri
 */
@ManagedBean
@ViewScoped
public class ForcaBean {

    int opcao = 0;
    boolean jogoIniciou;
    PalavraChooser seletorPalavra = new PalavraChooser();
    JogoDaForca jogoDaForca = null;
    NotificacaoUsuario notificacao = new NotificacaoUsuario();
    String palavraEscolhida = "";
    String mensagemResposta = "";
    char letraUsuario;

    public ForcaBean() {
        this.mensagemResposta += notificacao.listaOpcoes();
    }

    public void validaMensagemUser() {
        if (!jogoIniciou) {
            jogoIniciou = true;
            palavraEscolhida = seletorPalavra.chooseWord();
            jogoDaForca = new JogoDaForca(palavraEscolhida);
        }
        //if (!jogoDaForca.isFimDeJogo()) {
            mensagemResposta += notificacao.tentativasAcertarPalavra(jogoDaForca);
            atualizaTelaResposta();
            boolean letraEncontrada = LetterChecker.checkLetter(letraUsuario, palavraEscolhida);
            if (letraEncontrada) {
                jogoDaForca.atualizaPalavraAdivinhada(letraUsuario);
                mensagemResposta += notificacao.mensagemLetraEncontrada(letraUsuario, jogoDaForca);
                atualizaTelaResposta();
                limpaInputUsuario();
                if (jogoDaForca.isVitoria()) {
                    limpaSaidaResposta();
                    mensagemResposta += notificacao.mensagemVitoria(palavraEscolhida);
                    mensagemResposta += notificacao.mensagemContinuacaoJogo();
                    jogoIniciou = false;
                }
            } else {
                jogoDaForca.diminuiTentativasRestantes();
                mensagemResposta += notificacao.mensagemLetraNaoEncontrada(letraUsuario, jogoDaForca);
                atualizaTelaResposta();
                limpaInputUsuario();
                if (jogoDaForca.isFimDeJogo()) {
                    limpaSaidaResposta();
                    mensagemResposta += notificacao.mensagemDerrota(palavraEscolhida);
                    mensagemResposta += notificacao.mensagemContinuacaoJogo();
                    jogoIniciou = false;
                }
            }
        //}
    }

    public void opcao(int opcao) {
        this.opcao = opcao;
        //this.mensagemResposta += notificacao.opcaoEscolhida(opcao, jogoIniciou);
        jogoIniciou = true;
        atualizaTelaResposta();
    }

    public void limpaSaidaResposta() {
        mensagemResposta = "";
    }

    public String getMensagemResposta() {
        return mensagemResposta;
    }

    public char getLetraUsuario() {
        return letraUsuario;
    }

    public void setLetraUsuario(char letraUsuario) {
        this.letraUsuario = letraUsuario;
    }

    public int getOpcao() {
        return opcao;
    }

    public void atualizaTelaResposta() {
        PrimeFaces.current().ajax().update(":parteSuperior");
    }

    public void limpaInputUsuario() {
        this.letraUsuario = '\0';
    }

}
