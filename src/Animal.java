public abstract class Animal implements Creature {


    final Cell coords;
    private final int id;


    public Animal(int y, int x) {
        coords = Main.Params.terr.getCellArray()[y][x];
        this.id = Main.Params.creaturesNumber.incrementAndGet();
    }

    public Responce move() {
        return new Responce();
    }

    @Override
    public abstract Responce eat();

    @Override
    public Responce reproduce() {
        return new Responce();
    }

    public int getId() {
        return id;
    }

    public Cell getCoords() {
        return coords;
    }
}
