package com.example.demo;

import com.example.demo.model.Operacao;
import com.example.demo.repository.OperacaoRepository;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Objects;
import java.util.Scanner;

public class Banco {
    public void banco(OperacaoRepository operacaoRepository){
        try {
        String decisao;
        Scanner entrada = new Scanner(System.in);
        System.out.println("Quais informacoes voce quer?");
        System.out.println("Buscar pelo sinal da operacao insira: (sinal)");
        System.out.println("O quantidade total de operasoes realizadas insira: (quantidade)");
        System.out.println("Buscar pelo id da operacao insira: (id)");
        decisao = entrada.next();
        switch (decisao){
            case "sinal" -> {
                System.out.println("insira o sinal da operacao");
                decisao = entrada.next();
                List<Operacao> list = operacaoRepository.findBySinal(decisao);
                for (int i=0; i < list.size(); i++){
                    Operacao op = list.get(i);
                    System.out.println("--------------");
                    System.out.println("elementos:" + op.getElementos());
                    System.out.println("resultado:" + op.getResultado());
                    System.out.println("sinal:" + op.getSinal());
                    System.out.println("--------------");
                }
            }
            case "quantidade" -> {
                int list = operacaoRepository.findAll().size();
                System.out.println("--------------");
                System.out.println("O total de operacoes realizadas foram: "+list);
                System.out.println("--------------");
            }
            case "id" -> {
                System.out.println("Digite o ID");
                long id = entrada.nextInt();
                Operacao op = operacaoRepository.findById(id).get();
                System.out.println("--------------");
                System.out.println("elementos:" + op.getElementos());
                System.out.println("resultado:" + op.getResultado());
                System.out.println("sinal:" + op.getSinal());
                System.out.println("--------------");
            }
            default -> {
                System.out.println("Valor de entrada nao reconhecido");
            }
        }
        System.out.println("Gostaria de realizar outra acao? insira (sim)");
        decisao = entrada.next();
        if (!Objects.equals(decisao, "sim")){
            System.out.println("FIM");
            System.exit(1);
        }else {
            banco(operacaoRepository);
        }

    }catch (Exception e){
            System.out.println("Erro:"+e);
            System.exit(1);
        }
} }
