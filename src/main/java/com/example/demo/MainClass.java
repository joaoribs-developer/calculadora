package com.example.demo;

import com.example.demo.model.Operacao;
import com.example.demo.repository.OperacaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;
@Component
public class MainClass {
    @Autowired
    OperacaoRepository operacaoRepository;
    @Bean
    public void inicio(){
        Scanner entrada = new Scanner(System.in);
        String decisao;
        try {
            System.out.println("Para acessar a calculadora insira \"calc\" !");
            System.out.println("Para acessar o banco de dados insira \"banco\" !");
            decisao = entrada.next();
            if (Objects.equals(decisao, "calc")){
                new Calculadora().calculadora(this.operacaoRepository);
            } else if (Objects.equals(decisao, "banco")) {
                new Banco().banco(this.operacaoRepository);
            }else {
                System.out.print("O valor de entrada eh invalido, tente novamente");
                inicio();
            }
        }catch (Exception e){
            System.out.print("Erro:" +e);
        }

    }
}
