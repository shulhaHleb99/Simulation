import java.util.HashMap;

public class Herbivore_Mouse extends Herbivore {

    static final double weight = 0.05;
    static final int cellsPerStep = 1;
    static final double kilosForSatiety = 0.01;
    private static HashMap<Class<?>, Integer> whom = whomInit(Herbivore_Mouse.class);
    Herbivore_Mouse(int y, int x) {
        super(y, x);
    }

    @Override
    public Responce move() {
        return super.move(cellsPerStep);
    }
    public Responce eat() { return super.eat(weight, kilosForSatiety, whom); }
}
