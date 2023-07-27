import java.util.HashMap;

public class Carnivore_Bear extends Carnivore {

    private static final double weight = 500;
    private static final int cellsPerStep = 2;
    private static final double kilosForSatiety = 80;
    private static HashMap<Class<?>, Integer> whom = whomInit(Carnivore_Bear.class);
    Carnivore_Bear(int y, int x) {
        super(y, x);
    }
    @Override
    public Responce move() {
        return super.move(cellsPerStep);
    }
    public Responce eat() { return super.eat(weight, kilosForSatiety, whom); }

}
