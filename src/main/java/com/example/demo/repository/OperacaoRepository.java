package com.example.demo.repository;

import com.example.demo.model.Operacao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface OperacaoRepository extends JpaRepository<Operacao, Long> {
    @Query(value = "select * from operacao o where o.operacao = :sinal", nativeQuery = true)
List<Operacao> findBySinal(String sinal);
}
