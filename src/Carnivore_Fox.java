import java.util.HashMap;

public class Carnivore_Fox extends Carnivore {

    private static final double weight = 8;
    private static final int cellsPerStep = 2;
    private static final double kilosForSatiety = 2;
    private static HashMap<Class<?>, Integer> whom = whomInit(Carnivore_Fox.class);
    Carnivore_Fox(int y, int x) {
        super(y, x);
    }
    @Override
    public Responce move() {
        return super.move(cellsPerStep);
    }
    public Responce eat() { return super.eat(weight, kilosForSatiety, whom); }
}
