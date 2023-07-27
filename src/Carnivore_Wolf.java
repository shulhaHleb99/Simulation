import java.util.HashMap;

public class Carnivore_Wolf extends Carnivore {

    private static final double weight = 50;
    private static final int cellsPerStep = 3;
    private static final double kilosForSatiety = 8;
    private static HashMap<Class<?>, Integer> whom = whomInit(Carnivore_Wolf.class);
    Carnivore_Wolf(int y, int x) {
        super(y, x);
    }
    @Override
    public Responce move() {
        return super.move(cellsPerStep);
    }
    public Responce eat() { return super.eat(weight, kilosForSatiety, whom); }
}
