import java.util.ArrayList;

public class Cell {
    private final Terrain.TypeOfTerrain type;

    private ArrayList<Creature> creatures = new ArrayList<>();

    public Cell(Terrain.TypeOfTerrain type) {
        this.type = type;
    }

    Terrain.TypeOfTerrain getType() {
        return type;
    }

    ArrayList<Creature> getCreatures() {
        return creatures;
    }

    void setCreatures(ArrayList<Creature> creatures) {
        this.creatures = creatures;
    }
}
