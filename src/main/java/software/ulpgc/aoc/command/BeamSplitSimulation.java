package software.ulpgc.aoc.command;

import software.ulpgc.aoc.model.Manifold;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

// Parte 1: Contar divisiones de rayos
public class BeamSplitSimulation implements ManifoldSimulation {

    @Override
    public long execute(Manifold manifold) {
        int totalSplits = 0;
        // Estado inicial: Un conjunto con la posición de la columna 'S'
        Set<Integer> activeBeams = Set.of(manifold.getStartColumn());

        // Recorremos fila a fila (empezando por la 1)
        for (int row = 1; row < manifold.getHeight(); row++) {
            final int currentRow = row;

            // Contar divisiones en esta fila
            long splitsInRow = activeBeams.stream()
                    .filter(col -> manifold.getStructureAt(currentRow, col) == '^')
                    .count();

            totalSplits += splitsInRow;

            // Calcular posiciones para la siguiente fila
            activeBeams = activeBeams.stream()
                    .flatMap(col -> nextBeamPositions(manifold, currentRow, col))
                    .collect(Collectors.toSet());

            if (activeBeams.isEmpty()) break;
        }

        return totalSplits;
    }

    private Stream<Integer> nextBeamPositions(Manifold manifold, int row, int col) {
        char c = manifold.getStructureAt(row, col);
        if (c == '^') {
            return Stream.of(col - 1, col + 1); // División
        } else {
            return Stream.of(col); // Sigue recto
        }
    }
}