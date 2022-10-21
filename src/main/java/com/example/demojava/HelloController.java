package com.example.demojava;

import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Objects;
import java.util.Scanner;

public class HelloController {
    public static void funct(){
        Scanner entrada = new Scanner(System.in);
        double n1;
        double n2;
        String operacao;
        double soma;
        double subtracao;
        double multiplicacao;
        double divisao;
        String decisao;
    try {
        System.out.print("Digite o primeiro Numero: ");
        n1 = entrada.nextDouble();

            System.out.print("Digite o segundo Numero: ");
            n2 = entrada.nextDouble();

        System.out.print("Digite a operacoo desejada(\"+\",\"-\",\"*\",\"/\"): ");
        operacao = entrada.next();

        switch (operacao) {
            case "+" -> {
                soma = n1 + n2;
                System.out.println("O resultado da soma eh: " + soma);
            }
            case "-" -> {
                subtracao = n1 - n2;
                System.out.println("O resultado da subtracao eh: " + subtracao);
            }
            case "*" -> {
                multiplicacao = n1 * n2;
                System.out.println("O resultado da multiplicacao eh: " + multiplicacao);
            }
            case "/" -> {
                divisao = n1 / n2;
                System.out.println("O resultado da divisao eh: " + divisao);
            }
            default -> System.out.println("Esta operação nao eh valida");
        }


        System.out.println("Deseja realizar outra operacao? Insira: SIM ");
        decisao = entrada.next();
        if ((Objects.equals(decisao, "SIM") || Objects.equals(decisao, "sim"))) {
            funct();
        }
    }catch (Exception e){
        System.out.println("Valores inseridos sao envalidos, Erro: "+e);
        funct();
    }

    }
        public static void main (String[]args){
            funct();
        }


}
