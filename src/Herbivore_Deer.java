import java.util.HashMap;

public class Herbivore_Deer extends Herbivore {

    static final double weight = 300;
    static final int cellsPerStep = 4;
    static final double kilosForSatiety = 50;
    private static HashMap<Class<?>, Integer> whom = whomInit(Herbivore_Deer.class);
    Herbivore_Deer(int y, int x) {
        super(y, x);
    }
    @Override
    public Responce move() {
        return super.move(cellsPerStep);
    }
    public Responce eat() { return super.eat(weight, kilosForSatiety, whom); }
}
