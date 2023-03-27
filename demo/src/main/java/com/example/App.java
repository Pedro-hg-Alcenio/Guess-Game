package com.example;

import java.util.Random;
import java.util.Scanner;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        thisGame();
    }

    public static void thisGame() {
        // Boas vindas
        System.out.print("Jogo de Adivinhar Numeros!\n\n");

        // Gerando um numero qualquer de 0 a 100
        Random rand = new Random();
        Scanner scan = new Scanner(System.in);
        int guess = rand.nextInt(100);
        boolean correct = false;
        int type = 2;
        int leitura;

        // Gerando uma Pequena forca
        for (int trys = 7; trys != 0 && !correct; --trys) {
            System.out.println("   |-----|");
            System.out.println("   |     " + (trys <= 6 ? "0" : ""));
            System.out.println("   |    " + (trys == 5 ? "/" : trys == 4 ? "/|" : trys <= 3 ? "/|\\" : ""));
            System.out.println("   |    " + (trys == 2 ? "/" : trys <= 1 ? "/ \\" : ""));
            System.out.println("-------");

            System.out.println(type == 0 ? "Muito pequeno. Tente novamente: " : type == 1 ? "Muito grande. Tente novamente: " : "Digite um numero: ");
            leitura = scan.nextInt();

            if (leitura == guess) {
                correct =! correct;
            } else if (leitura < guess) {
                type = 0;
            } else {
                type = 1;
            }
        }

        if (correct) {
            System.out.println("Parabéns você ganhou!");
        } else {
            System.out.println("F! O numero correto era " + guess + "!");
        }

        newGame();

        scan.close();
    }

    public static void newGame() {
        System.out.println("Deseja jogar novamente? (y/n)");
        Scanner scanner = new Scanner(System.in);
        char leitura = 'a';
        boolean errou = false;

        for (; leitura != 'n' && leitura != 'y' ;) {
            if (errou) {
                System.out.print("Essa opção e invalida! Tente novamente, (y/n):");
            }
            leitura = scanner.nextLine().charAt(0);
            errou = true;
        }
        
        if (leitura == 'y') 
            thisGame();
        else
            System.out.println("Obrigado por jogar!");

        scanner.close();
    }
}
