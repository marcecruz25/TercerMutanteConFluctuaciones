package com.example.mutanteMarceloCruz.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "humano")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Humano implements Serializable {

    public Humano(String adn, boolean mutante) {
        this.adn = adn;
        this.mutante = mutante;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;

    @Column(name = "adn")
    private String adn;

    @Column(name = "mutante")
    private boolean mutante;

    @Override
    public String toString() {
        return adn;
    }
}
