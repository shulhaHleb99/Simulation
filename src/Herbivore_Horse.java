import java.util.HashMap;

public class Herbivore_Horse extends Herbivore {

    static final double weight = 400;
    static final int cellsPerStep = 4;
    static final double kilosForSatiety = 60;
    private static HashMap<Class<?>, Integer> whom = whomInit(Herbivore_Horse.class);
    Herbivore_Horse(int y, int x) {
        super(y, x);
    }
    @Override
    public Responce move() {
        return super.move(cellsPerStep);
    }
    public Responce eat() { return super.eat(weight, kilosForSatiety, whom); }
}
