public class _Plant implements Creature {

    private static final int weight = 1;

    final Cell coords;
    private final int id;


    public _Plant(int y, int x) {
        coords = Main.Params.terr.getCellArray()[y][x];
        this.id = Main.Params.creaturesNumber.incrementAndGet();
    }

    @Override
    public boolean eat() {
        return true;
    }

    @Override
    public boolean reproduce() {
        return true;
    }

    public boolean move() {
        return false;
    }


    public int getId() {
        return id;
    }
}
