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
            System.out.print("Digite a operacoo desejada(\"+\",\"-\",\"*\",\"/\", \"media\"): ");
            operacao = entrada.next();

            if (Objects.equals(operacao, "media")){
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
                double media = valoresRecebidos.stream().mapToDouble(Double::doubleValue).average().orElse(0.0);
                DecimalFormat decimalFormat = new DecimalFormat("#,##0.00");
                decimalFormat.setRoundingMode(RoundingMode.HALF_UP);
                System.out.println("O valor da media eh: "+decimalFormat.format(media));
                System.out.println(("-").repeat(10));
                System.out.println("Para realizar outra operacao, insira: SIM");
                decisao = entrada.next();
                if ((Objects.equals(decisao, "SIM") || Objects.equals(decisao, "sim"))) {
                    funct();
                }
            }
            System.out.print("Digite o primeiro Numero: ");
            n1 = entrada.nextDouble();

            System.out.print("Digite o segundo Numero: ");
            n2 = entrada.nextDouble();


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
