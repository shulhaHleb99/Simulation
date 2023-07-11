import java.util.Arrays;

public class Terrain {

    private static Terrain terr;

    private final Cell[][] cellArray;

    public Cell[][] getCellArray() {
        return cellArray;
    }

    private Terrain() {
        cellArray = generate(Main.Params.getTerrainSizeY(), Main.Params.getTerrainSizeX());
    }

    public static Terrain getTerr() {
        if (terr == null) {
            terr = new Terrain();
        }
        return terr;
    }

    private static Cell[][] generate(int y, int x) {
        Cell[][] array = new Cell[y][x];
        for (int i = 0; i < y; i++) {
            for (int k = 0; k < x; k++) {
                array[i][k] = new Cell(TypeOfTerrain.F, i, k);
            }
        }

        return array;
    }

    enum TypeOfTerrain {
        F("forest", Constants.Colours.GREEN);

        private String name;
        private Constants.Colours colour;

        TypeOfTerrain(String name, Constants.Colours colour) {
            this.name = name;
            this.colour = colour;
        }
    }
}
