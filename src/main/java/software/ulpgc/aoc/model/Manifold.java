package software.ulpgc.aoc.model;

import java.util.List;

public class Manifold {
    private final List<String> grid;
    private final int startColumn;

    public Manifold(List<String> grid) {
        this.grid = grid;
        this.startColumn = calculateStart();
    }

    private int calculateStart() {
        // Busca la 'S' en la primera fila (fila 0)
        return grid.get(0).indexOf('S');
    }

    public char getStructureAt(int row, int col) {
        // Protección de límites: si sale del mapa, devolvemos espacio vacío
        if (row < 0 || row >= grid.size() || col < 0 || col >= grid.get(row).length()) {
            return '.';
        }
        return grid.get(row).charAt(col);
    }

    public int getHeight() {
        return grid.size();
    }

    public int getStartColumn() {
        return startColumn;
    }
}