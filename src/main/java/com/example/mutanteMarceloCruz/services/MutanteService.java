package com.example.mutanteMarceloCruz.services;

import com.example.mutanteMarceloCruz.view.Stats;

/**
 * Created by marce on 9/16/17.
 */
public interface MutanteService {

    public boolean isMutante(String[] dna);

    public Stats getStats();

}
