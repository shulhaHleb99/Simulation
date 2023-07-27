import java.util.HashMap;

public class Herbivore_Sheep extends Herbivore {

    static final double weight = 70;
    static final int cellsPerStep = 3;
    static final double kilosForSatiety = 15;
    private static HashMap<Class<?>, Integer> whom = whomInit(Herbivore_Sheep.class);
    Herbivore_Sheep(int y, int x) {
        super(y, x);
    }

    @Override
    public Responce move() {
        return super.move(cellsPerStep);
    }
    public Responce eat() { return super.eat(weight, kilosForSatiety, whom); }

}
