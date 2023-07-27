import java.util.HashMap;

public class Carnivore_Eagle extends Carnivore {

    private static final double weight = 6;
    private static final int cellsPerStep = 3;
    private static final double kilosForSatiety = 1;
    private static final HashMap<Class<?>, Integer> whom = whomInit(Carnivore_Eagle.class);
    Carnivore_Eagle(int y, int x) {
        super(y, x);
    }
    @Override
    public Responce move() {
        return super.move(cellsPerStep);
    }
    public Responce eat() { return super.eat(weight, kilosForSatiety, whom); }
}
