package com.seunome.conversor;

import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {  // Corrigido: String[] args
        Scanner scanner = new Scanner(System.in);
        CurrencyConverterAPI api = new CurrencyConverterAPI();

        System.out.println("**************************************************");
        System.out.println("Bem-vindo(a) ao Conversor de Moedas Alura ONE!");
        System.out.println("**************************************************\n");

        System.out.println("Escolha uma opção de conversão:");
        for (int i = 0; i < CurrencyOption.values().length; i++) {
            System.out.println((i + 1) + ". " + CurrencyOption.values()[i].getDescription());
        }
        System.out.println("7. Sair");

        int choice;
        try {
            System.out.print("\nDigite o número da opção desejada: ");
            choice = scanner.nextInt();

            if (choice < 1 || choice > CurrencyOption.values().length + 1) {
                System.out.println("Opção inválida. Por favor, escolha um número entre 1 e 7.");
                return;
            }

            if (choice == CurrencyOption.values().length + 1) {
                System.out.println("Obrigado por usar o conversor de moedas. Encerrando o programa.");
                return;
            }

            CurrencyOption selectedOption = CurrencyOption.values()[choice - 1];

            System.out.print("Digite o valor a ser convertido: ");
            double amount = scanner.nextDouble();

            ExchangeRateResponse response = api.getConversionRate(
                    selectedOption.getBaseCurrency(),
                    selectedOption.getTargetCurrency()
            );

            if (response != null) {
                double convertedValue = amount * response.getConversion_rate();
                System.out.printf("\n%.2f %s equivale a %.2f %s\n",
                        amount, selectedOption.getBaseCurrency(),
                        convertedValue, selectedOption.getTargetCurrency());
            } else {
                System.out.println("Não foi possível realizar a conversão. Verifique sua chave de API ou a conexão.");
            }

        } catch (InputMismatchException e) {
            System.out.println("Entrada inválida. Por favor, digite um número para a opção e para o valor.");
        } catch (IOException | InterruptedException e) {
            System.out.println("Ocorreu um erro de comunicação com a API: " + e.getMessage());
        } finally {
            scanner.close();
            System.out.println("\n**************************************************");
            System.out.println("Programa encerrado.");
            System.out.println("**************************************************");
        }
    }
}
