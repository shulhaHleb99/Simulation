import java.util.HashMap;

public class Herbivore_Buffalo extends Herbivore {

    static final double weight = 700;
    static final int cellsPerStep = 3;
    static final double kilosForSatiety = 100;
    private static HashMap<Class<?>, Integer> whom = whomInit(Herbivore_Buffalo.class);
    Herbivore_Buffalo(int y, int x) {
        super(y, x);
    }
    @Override
    public Responce move() {
        return super.move(cellsPerStep);
    }
    public Responce eat() { return super.eat(weight, kilosForSatiety, whom); }
}
