package br.com.alura;

import br.com.alura.command.*;

import java.util.Scanner;

public class AdopetConsoleApplication {

    public static void main(String[] args) {
        var executor = new CommandExecutor();

        System.out.println("##### BOAS VINDAS AO SISTEMA ADOPET CONSOLE #####");
        try {
            int opcaoEscolhida = 0;
            while (opcaoEscolhida != 5) {
                showMenu();

                String textoDigitado = new Scanner(System.in).nextLine();
                opcaoEscolhida = Integer.parseInt(textoDigitado);

                switch (opcaoEscolhida) {
                    case 1 -> executor.executeCommand(new ListSheltersCommand());
                    case 2 -> executor.executeCommand(new RegisterShelterCommand());
                    case 3 -> executor.executeCommand(new ListPetsCommand());
                    case 4 -> executor.executeCommand(new ImportPetsCommand());
                    case 5 -> System.exit(0);
                    default ->  System.out.println("NÚMERO INVÁLIDO!");
                }
            }
            System.out.println("Finalizando o programa...");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void showMenu () {
        System.out.println("\nDIGITE O NÚMERO DA OPERAÇÃO DESEJADA:");
        System.out.println("1 -> Listar abrigos cadastrados");
        System.out.println("2 -> Cadastrar novo abrigo");
        System.out.println("3 -> Listar pets do abrigo");
        System.out.println("4 -> Importar pets do abrigo");
        System.out.println("5 -> Sair");
    }
}