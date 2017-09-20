package com.example.mutanteMarceloCruz.repository;

import com.example.mutanteMarceloCruz.domain.Humano;
import org.springframework.data.querydsl.QueryDslPredicateExecutor;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.List;

public interface HumanoRepository extends PagingAndSortingRepository<Humano, Long> {

    Humano findByAdn(String adn);

    List<Humano> findAllByAndMutante(boolean mutante);

}
