public abstract class Animal implements Creature {


    final Cell coords;
    private final int id;


    public Animal(int y, int x) {
        coords = Main.Params.terr.getCellArray()[y][x];
        this.id = Main.Params.creaturesNumber.incrementAndGet();
    }

    public boolean move() {
        return true;
    }

    @Override
    public abstract boolean eat();

    @Override
    public boolean reproduce() {
        return true;
    }

    public int getId() {
        return id;
    }


}
