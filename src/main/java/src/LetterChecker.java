/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package src;

/**
 *
 * @author Gabri
 */
public class LetterChecker {

    // Método que verifica se uma letra está presente em uma palavra
    public static boolean checkLetter(char letter, String word) {
        // Verifica se a palavra é nula ou vazia
        if (word == null || word.isEmpty()) {
            return false;
        }

        // Converte a palavra para letras minúsculas para evitar problemas de comparação
        word = word.toLowerCase();

        // Verifica se a letra está presente na palavra
        return word.indexOf(Character.toLowerCase(letter)) != -1;
    }
}

