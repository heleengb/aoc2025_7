package software.ulpgc.aoc.command;

import software.ulpgc.aoc.model.Manifold;
import java.util.HashMap;
import java.util.Map;

// Parte 2: Contar líneas temporales cuánticas
public class QuantumPathSimulation implements ManifoldSimulation {

    @Override
    public long execute(Manifold manifold) {
        // Estado inicial: Posición -> Cantidad de líneas temporales
        Map<Integer, Long> timelines = new HashMap<>();
        timelines.put(manifold.getStartColumn(), 1L);

        for (int row = 1; row < manifold.getHeight(); row++) {
            timelines = processNextRow(manifold, row, timelines);
        }

        // Sumar todas las líneas que llegaron al fondo
        return timelines.values().stream().mapToLong(Long::longValue).sum();
    }

    private Map<Integer, Long> processNextRow(Manifold manifold, int row, Map<Integer, Long> previous) {
        Map<Integer, Long> next = new HashMap<>();

        for (Map.Entry<Integer, Long> entry : previous.entrySet()) {
            int col = entry.getKey();
            long count = entry.getValue();
            char structure = manifold.getStructureAt(row, col);

            if (structure == '^') {
                // se bifurca sumando la cantidad actual a ambos lados
                next.merge(col - 1, count, Long::sum);
                next.merge(col + 1, count, Long::sum);
            } else {
                // Espacio normal, se propaga hacia abajo
                next.merge(col, count, Long::sum);
            }
        }
        return next;
    }
}