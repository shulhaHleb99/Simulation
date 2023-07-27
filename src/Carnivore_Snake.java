import java.util.HashMap;

public class Carnivore_Snake extends Carnivore {

    private static final double weight = 15;
    private static final int cellsPerStep = 1;
    private static final double kilosForSatiety = 3;
    private static HashMap<Class<?>, Integer> whom = whomInit(Carnivore_Snake.class);
    Carnivore_Snake(int y, int x) {
        super(y, x);
    }
    @Override
    public Responce move() {
        return super.move(cellsPerStep);
    }
    public Responce eat() { return super.eat(weight, kilosForSatiety, whom); }
}
