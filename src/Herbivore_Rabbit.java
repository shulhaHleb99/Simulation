import java.util.HashMap;

public class Herbivore_Rabbit extends Herbivore {

    static final double weight = 2;
    static final int cellsPerStep = 2;
    static final double kilosForSatiety = 0.45;
    private static HashMap<Class<?>, Integer> whom = whomInit(Herbivore_Rabbit.class);
    Herbivore_Rabbit(int y, int x) {
        super(y, x);
    }

    @Override
    public Responce move() {
        return super.move(cellsPerStep);
    }
    public Responce eat() { return super.eat(weight, kilosForSatiety, whom); }
}
