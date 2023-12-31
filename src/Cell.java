import java.util.ArrayList;

public class Cell {
    private final Terrain.TypeOfTerrain type;

    Terrain.TypeOfTerrain getType() {
        return type;
    }

    //-------------------------------------------------------------------------

    private final int y;

    private final int x;

    public int getY() {
        return y;
    }

    public int getX() {
        return x;
    }

    //--------------------------------------------------------------------------

    private volatile ArrayList<Creature> creatures = new ArrayList<>();

    ArrayList<Creature> getCreatures() {
        return creatures;
    }

    synchronized void addCreature(Creature c) {
        creatures.add(c);
    }

    synchronized void removeCreature(Creature c) {
        creatures.remove(c);
    }

    //--------------------------------------------------------------------------


    public Cell(Terrain.TypeOfTerrain type, int y, int x) {
        this.type = type;
        this.y = y;
        this.x = x;
    }
}
