import java.util.HashMap;

public class Herbivore_Duck extends Herbivore {

    static final double weight = 1;
    static final int cellsPerStep = 4;
    static final double kilosForSatiety = 0.15;
    private static HashMap<Class<?>, Integer> whom = whomInit(Herbivore_Duck.class);
    Herbivore_Duck(int y, int x) {
        super(y, x);
    }
    @Override
    public Responce move() {
        return super.move(cellsPerStep);
    }
    public Responce eat() { return super.eat(weight, kilosForSatiety, whom); }
}
