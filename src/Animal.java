public abstract class Animal implements Creature {


    public final Cell coords;
    private final int id;

    public Animal(int y, int x) {
        coords = Main.Params.terr.getCellArray()[y][x];
        this.id = Main.Params.creaturesNumber.incrementAndGet();
    }

    public void move() {}

    public void chooseDirection() {}

    @Override
    public abstract void eat();

    @Override
    public void reproduce() {

    }

    @Override
    public void makeMove() {

    }

    @Override
    public void calculateChance() {

    }
}
