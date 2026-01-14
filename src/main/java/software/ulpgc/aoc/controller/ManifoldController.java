package software.ulpgc.aoc.controller;

import software.ulpgc.aoc.command.BeamSplitSimulation;
import software.ulpgc.aoc.command.QuantumPathSimulation;
import software.ulpgc.aoc.model.Manifold;

import java.util.List;

public class ManifoldController {

    // lógica de la Parte 1
    public long calculateBeamSplits(List<String> data) {
        Manifold manifold = new Manifold(data);
        return new BeamSplitSimulation().execute(manifold);
    }

    // lógica de la Parte 2
    public long calculateQuantumTimelines(List<String> data) {
        Manifold manifold = new Manifold(data);
        return new QuantumPathSimulation().execute(manifold);
    }
}