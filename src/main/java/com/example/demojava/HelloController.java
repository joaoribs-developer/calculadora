package com.example.demojava;

import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Objects;
import java.util.Scanner;

public class HelloController {
    public static void funct(){
        Scanner entrada = new Scanner(System.in);
        String operacao;
        double media;
        double soma;
        double subtracao;
        double multiplicacao = 1;
        double divisao;
        String decisao;
        try {
            DecimalFormat decimalFormat = new DecimalFormat("#,##0.00");
            decimalFormat.setRoundingMode(RoundingMode.HALF_UP);

            System.out.print("Digite a operacoo desejada(\"+\",\"-\",\"*\",\"/\", \"media\"): ");
            operacao = entrada.next();

                ArrayList<Double> valoresRecebidos = new ArrayList<>();
                int elementos;
                System.out.print("Digite o numero de elementos: ");
                elementos = entrada.nextInt();

                if (elementos > 15){
                    System.out.println("O valor maximo sao 15 elementos");
                    System.out.print("Digite o novamente o numero de elementos: ");
                    elementos = entrada.nextInt();
                }

                for (int i = 0; i < elementos; i++){
                    System.out.print("Digite o valor: ");
                    double value = entrada.nextDouble();
                    valoresRecebidos.add(value);
                }

            switch (operacao) {
                case "+" -> {
                    soma = valoresRecebidos.stream().mapToDouble(Double::doubleValue).sum();
                    System.out.println("O valor da media eh: "+decimalFormat.format(soma));
                    System.out.println(("-").repeat(10));
                }
                case "media"-> {
                    media = valoresRecebidos.stream().mapToDouble(Double::doubleValue).average().orElse(0.0);
                    System.out.println("O valor da media eh: "+decimalFormat.format(media));
                    System.out.println(("-").repeat(10));
                }
                case "-" -> {
                    subtracao = valoresRecebidos.get(0);
                    for (int i = 1; i < elementos; i++){
                        subtracao -= valoresRecebidos.get(i);
                    }
                    System.out.println("O resultado da subtracao eh: " + decimalFormat.format(subtracao));
                    System.out.println(("-").repeat(10));
                }
                case "*" -> {
                    for (int i = 0; i < elementos; i++){
                        multiplicacao *= valoresRecebidos.get(i);
                    }
                    System.out.println("O resultado da multiplicacao eh: " + decimalFormat.format(multiplicacao));
                    System.out.println(("-").repeat(10));
                }
                case "/" -> {
                    divisao = valoresRecebidos.get(0);
                    for (int i = 1; i < elementos; i++){
                        divisao /= valoresRecebidos.get(i);
                    }
                    System.out.println("O resultado da divisao eh: " + decimalFormat.format(divisao));
                    System.out.println(("-").repeat(10));
                }
                default ->{
                    System.out.println("Esta operação nao eh valida") ;
                    System.out.println(("-").repeat(10));
                }

            }
            System.out.println("Para realizar outra operacao, insira: SIM");
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
