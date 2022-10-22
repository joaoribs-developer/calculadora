package com.example.demo.model;

import javax.persistence.*;
import java.io.Serializable;

@Entity
public class Operacao implements Serializable {
    private static final long serialVersionUID = -2420346134960559062L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "identificador")
    long id = 1;
    @Column(name = "operacao")
    String sinal = "";
    @Column(name = "elementos")
    int elementos = 0;
    @Column(name = "resultado")
    double resultado = 0;

    public void setId(long id) {
        this.id = id;
    }

    public void setSinal(String sinal) {
        this.sinal = sinal;
    }

    public void setElementos(int elementos) {
        this.elementos = elementos;
    }

    public void setResultado(double resultado) {
        this.resultado = resultado;
    }

    public long getId() {
        return id;
    }

    public String getSinal() {
        return sinal;
    }

    public int getElementos() {
        return elementos;
    }

    public double getResultado() {
        return resultado;
    }



}
