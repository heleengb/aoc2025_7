package software.ulpgc.aoc.command;

import software.ulpgc.aoc.model.Manifold;

public interface ManifoldSimulation {
    long execute(Manifold manifold);
}