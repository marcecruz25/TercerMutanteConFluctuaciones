package com.example.mutanteMarceloCruz.controller;

import com.example.mutanteMarceloCruz.services.MutanteService;
import com.example.mutanteMarceloCruz.view.Stats;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * Created by marce on 9/15/17.
 */

@RestController
@RequestMapping("/mutant")
public class MutanteController {

    private final MutanteService mutanteService;

    @Autowired
    public MutanteController(MutanteService mutanteService) {
        this.mutanteService = mutanteService;
    }

    @RequestMapping(method = RequestMethod.POST)
    @ResponseBody
    public ResponseEntity<String> isMutante(@RequestParam String[] dna) {
        if (mutanteService.isMutante(dna)) {
            return new ResponseEntity<String>(HttpStatus.OK);
        } else {
            return new ResponseEntity<String>(HttpStatus.FORBIDDEN);
        }
    }

    @RequestMapping(value = "/stats", method = RequestMethod.GET)
    @ResponseBody
    public Stats isMutante() {
        return mutanteService.getStats();
    }
}
