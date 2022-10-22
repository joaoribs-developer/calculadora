package com.example.demo;

import com.example.demo.model.Operacao;
import com.example.demo.repository.OperacaoRepository;
import net.bytebuddy.asm.Advice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.i18n.LocaleContext;
import org.springframework.stereotype.Component;

import javax.print.attribute.standard.Finishings;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Objects;
import java.util.Scanner;

//@Component
public class Calculadora{

//    @Bean
    public void calculadora(OperacaoRepository operacaoRepository){
        Scanner entrada = new Scanner(System.in);
        String operacao;
        double media;
        double soma;
        double subtracao;
        double multiplicacao = 1;
        double divisao;
        String decisao;
        String erro = "";
        double resultado=0;
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
                    System.out.println("O valor da soma eh: "+decimalFormat.format(soma));
                    System.out.println(("-").repeat(10));
                    resultado = soma;
                }
                case "media"-> {
                    media = valoresRecebidos.stream().mapToDouble(Double::doubleValue).average().orElse(0.0);
                    System.out.println("O valor da media eh: "+decimalFormat.format(media));
                    System.out.println(("-").repeat(10));
                    resultado = media;
                }
                case "-" -> {
                    subtracao = valoresRecebidos.get(0);
                    for (int i = 1; i < elementos; i++){
                        subtracao -= valoresRecebidos.get(i);
                    }
                    System.out.println("O resultado da subtracao eh: " + decimalFormat.format(subtracao));
                    System.out.println(("-").repeat(10));
                    resultado = subtracao;
                }
                case "*" -> {
                    for (int i = 0; i < elementos; i++){
                        multiplicacao *= valoresRecebidos.get(i);
                    }
                    System.out.println("O resultado da multiplicacao eh: " + decimalFormat.format(multiplicacao));
                    System.out.println(("-").repeat(10));
                    resultado = multiplicacao;
                }
                case "/" -> {
                    divisao = valoresRecebidos.get(0);
                    for (int i = 1; i < elementos; i++){
                        divisao /= valoresRecebidos.get(i);
                    }
                    System.out.println("O resultado da divisao eh: " + decimalFormat.format(divisao));
                    System.out.println(("-").repeat(10));
                    resultado = divisao;
                }
                default ->{
                    System.out.println("Esta operação nao eh valida");
                    erro+="caiu aqui";
                    System.out.println(("-").repeat(10));
                }

            }
            if (!erro.equals("caiu aqui")){
                Operacao operacaoObject = new Operacao();
                operacaoObject.setElementos(elementos);
                operacaoObject.setSinal(operacao);
                operacaoObject.setResultado(resultado);
                operacaoRepository.save(operacaoObject);
            }

            System.out.print("Para realizar outra operacao, insira: SIM");
            decisao = entrada.next();
            if ((Objects.equals(decisao, "SIM") || Objects.equals(decisao, "sim"))) {
                calculadora(operacaoRepository);
            }else {
                System.out.println("FIM");
                System.exit(1);
            }
        }catch (Exception e){
            System.out.println("Valores inseridos sao envalidos, Erro: "+e);
            calculadora(operacaoRepository);
        }
    }

}
