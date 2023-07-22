public class _Plant implements Creature {

    private static final int weight = 1;

    final Cell coords;
    private final int id;


    public _Plant(int y, int x) {
        coords = Main.Params.terr.getCellArray()[y][x];
        this.id = Main.Params.creaturesNumber.incrementAndGet();
    }

    @Override
    public Responce eat() {
        return new Responce();
    }

    @Override
    public Responce reproduce() {
        return new Responce();
    }

    public Responce move() {
        return new Responce();
    }


    public int getId() {
        return id;
    }

    public Cell getCoords() {
        return coords;
    }
}
