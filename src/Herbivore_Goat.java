import java.util.HashMap;

public class Herbivore_Goat extends Herbivore {

    static final double weight = 60;
    static final int cellsPerStep = 3;
    static final double kilosForSatiety = 10;
    private static HashMap<Class<?>, Integer> whom = whomInit(Herbivore_Duck.class);
    Herbivore_Goat(int y, int x) {
        super(y, x);
    }
    @Override
    public Responce move() {
        return super.move(cellsPerStep);
    }
    public Responce eat() { return super.eat(weight, kilosForSatiety, whom); }
}
